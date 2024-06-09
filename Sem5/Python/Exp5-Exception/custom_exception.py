class InvalidAgeException(Exception):
    pass

while True:
    try:
        age = int(input("Enter Age: "))
        if age<18:
            raise InvalidAgeException("Invalid age: Come Back when grown up")
        else:
            print("Congrats you made it")
    except Exception as e:
        print(str(e))
    else:
        print("No Exception was raised")
    finally:
        print("Goodbye!!")
