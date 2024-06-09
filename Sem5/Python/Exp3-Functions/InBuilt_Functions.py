#Lists
def list_func():

    list1 = [10]
    print(list1)

    list1.append(999)
    print(list1)

    list1.extend([9,4,5,6])
    print(list1)

    list1.insert(3,10002)
    print(list1)

    print("Sorted: ",sorted(list1))
    print("Minimum: ",min(list1))
    print("Maximum: ",max(list1))
    print("Total Sum: ",sum(list1))

    list1.pop(3)
    print(list1)
    
    print(len(list1))

    list2 = list1.copy()
    print(list2)

    list2 = list1.clear()
    print(list2)

def tuple_func():
    tuple1 = (90,90,89,9,0,8,9,76,4,3,2,90)
    print(tuple1, type(tuple1))

    print(len(tuple1))

    print(tuple1, tuple1.count(90))

    print(tuple1, tuple1.index(89))

    print("Sort: ",sorted(tuple1))
    print("Minimum: ",min(tuple1))
    print("Maximum: ",max(tuple1))
    print("Total Sum: ",sum(tuple1))

def set_func():
    set1 = {19,89,90}
    print(set1)

    set1.add(8888)
    print(set1)

    try:
        set1.remove(909)
        print(set1)
    except Exception as e:
        print("Element not found exception raised: ",str(e))

    set1.discard(89)
    print(set1)

    print(set1.pop(), "removed")
    print(set1)

    set1.clear()
    print(set1)

def dict_func():
    dict1 = {"roll":89, 
             "name":"prerna", 
             "age": 12, 
             "college": "djsanghvi", 
             "city":"mumbai", 
             "country":"India"
            }
    print(dict1)

    dict2 = dict1.copy()
    print(dict2)

    list1 = (1,2,3)
    list2 = ('a','b','c')
    print(dict2.fromkeys(list1, list2))

    print(dict1.get("name"))
    print(dict1.items())
    print(dict1.keys())
    print(dict1.values())
    print(dict1.pop('college'))
    dict1.update({'branch':"comp"})
    print(dict1)

dict_func()
# set_func()
# list_func()
# tuple_func()







