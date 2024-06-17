package EstructureOffice;

import exception.UserException;
import java.util.regex.Pattern;

public class User {
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;

    public User(String fullName, String address, String phoneNumber, String email) throws UserException {
        setFullName(fullName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws UserException {
        if (!Pattern.matches("^[a-zA-Z\\s]+$", fullName)) {
            throw new UserException("Invalid full name");
        }
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws UserException {
        // Validación del formato de la dirección
        if (!Pattern.matches("^.+?,\\s*.+?,\\s*.+?,\\s*\\d{5},\\s*(OAX|QROO|MOR|QRO|SIN)$", address)) {
            throw new UserException("Invalid address format. Please follow the format: 'Street Number, Neighborhood, City, Postal Code, State Alias'");
        }

        // Obtener el alias del estado desde la dirección
        String[] addressParts = address.split(",");
        String stateAlias = addressParts[4].trim();

        // Obtener la instancia de Distribution desde el alias
        Distribution distribution = Distribution.fromAlias(stateAlias);

        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws UserException {
        if (!Pattern.matches("^\\+52\\d{10}$", phoneNumber)) {
            throw new UserException("Invalid phone number. The phone number must follow the format: +521234567890");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws UserException {
        if (!Pattern.matches("^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)+$", email)) {
            throw new UserException("Invalid email");
        }
        this.email = email;
    }
}

