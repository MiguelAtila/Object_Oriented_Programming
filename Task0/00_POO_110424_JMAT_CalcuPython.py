# Import the math module for mathematical functions 
import math
from scipy.integrate import quad

def addition_number():
    num1 = float(input("type your first number: "))
    num2 = float(input("type your second number: "))
    
    addition = num1 + num2
    return addition

def subtraction_number():
    num1 = float(input("type your first number: "))
    num2 = float(input("type your second number: "))

    substraction = num1 - num2
    return substraction

     
def multiplication_number():
    num1 = float(input("type your first number: "))
    num2 = float(input("type your second number: "))

    multiplication = num1 * num2
    return multiplication

def division_number(): 
    num1 = float(input("type your numerator: "))
    num2 = float(input("type your denominator: "))
    if num2 == 0:
        print("Error: Can't be divided by zero.")
        return None
    
    division = num1 / num2
    return division

def square_root():
    num = float(input("type your number: "))
    if num < 0:
        print("Error: You can't calculate the square root of a negative number.")
        return None
    
    root = math.sqrt(num)
    return root

def integrate():
    funcion = input("Enter the function to be integrated: ")
    try: # Calculate the integral using quad from scipy
        result, error = quad(lambda x: eval(funcion), 0, 1)
        return result
    except Exception as e: # Handle any errors that occur during integration
        print("Error:", e)
        return None
    

def Matrix ():
    rows = int(input("Enter the number of rows in the array: "))
    columns = int(input("Enter the number of columns in the array: "))

    matr1 = []
    matr2 = []

    print("Enter the elements of the first Matrix:")
    for i in range(rows):
        row = []
        for j in range(columns):
            value = float(input(f"Enter the item in the ({i+1},{j+1}): "))
            row.append(value)
        matr1.append(row)

    
    print("Enter the elements of the second Matrix:")
    for i in range(rows):
        row = []
        for j in range(columns):
            value = float(input(f"Enter the item in the ({i+1},{j+1}): "))
            row.append(value)
        matr2.append(row)

    # add matri
    result = []
    for i in range(rows):
        row_result = []
        for j in range(columns):
            sum = matr1[i][j] + matr2[i][j]
            row_result.append(sum)
        result.append(row_result)

    return result

operation = input("Which math operation do you need? (addition/substraction/multiplication/division/integration/addmatr): ").lower()

if operation == "addition":
    result = addition_number()
    print("The addition us:", result)
elif operation == "substraction":
    result= subtraction_number()
    print("The substraction is:", result)
elif operation == "multiplication":
    result = multiplication_number()
    print("The multiplication is:", result)
elif operation == "division":
    result = division_number()
    if result is not None:
        print("The quetion is:", result)
elif operation == "integration":
    result = integrate()
    if result is not None:
        print("The value of the integral is:", result)
elif operation == "addmatr":
    result = Matrix()
    print("The matric is:")
    for row in result:
        print(row)
else:
    print("Invalid operation.")
