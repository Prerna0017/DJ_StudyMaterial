try:
    # 1: KeyError
    dict1 = {1:2, 3:9}
    dict1[4]

    # 2: ArithmeticError
    # a=10/0

    # 3: NameError
    # print(b)

    # 4: AssertionError
    # y = 0
    # assert y!=0,"y!=0 is false, Custom Assertion Error"

    # 5. TypeError
    # a = 10
    # print(a())

    # 6: KeyboardInterrupt
    # data = input("Enter Data: ")

    # 7. ModuleNotFoundError
    # import xyx

except KeyError as e:
    print("Key not present: ",str(e))
except ArithmeticError as e:
    print("Divide By zero Exception: ",str(e))
except NameError as e:
    print("Variable name not found: ",str(e))
except AssertionError as e:
    print("Assertion Error msg: ",str(e))
except TypeError as e:
    print("a is not a function: ",str(e))
except KeyboardInterrupt as e:
    print("keyboard interrupted: ",str(e))
except ModuleNotFoundError as e:
    print("No such module: ",str(e))
else:
    print("No exceptions at all")
finally:
    print("Going to run anyways")