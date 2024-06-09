def histogram(list1):
    dict1 = {}
    tup = tuple(list1)
    for i in tup:
        if i not in dict1.keys():
            dict1.update({i: tup.count(i)})
    print(dict1)
# histogram([13,12,11,13,14,13,7,7,13,14,12])
    
def perfect(num):
    sum=0
    for i in range(1,int(num/2)+1):
        if num%i == 0:
            sum+=i
    if sum==num:
        print("It is a perfect number")
    else:
        print("Not a perfect number")
# perfect(6)
        
def hanoi(disks, src, aux, dest):
    if disks == 1:
        print(f"Disk1 from {src} to {dest}")
        return
    hanoi(disks-1, src, dest, aux)
    print(f"Disk{disks} from {src} to {dest}")
    hanoi(disks-1, aux, src, dest)
disks=3
# hanoi(disks, 'A', 'B', 'C')

def lambda_demo(a,b):
    max = lambda a,b: a if a>b else b
    return max(a,b)
# print(lambda_demo(90,897))

def add_lists(list1, list2):
    def add(a,b):
        return a+b
    return list(map(add, list1, list2))
# print(add_lists([2,3,4],[10,100,1000]))

def cube_Of_Odd_no_in_list(list1):
    return list(map(
            lambda x: x**3,
            filter(
                lambda x: x%2!=0, 
                list1
            )
        )
    )
# print(cube_Of_Odd_no_in_list([1,2,3,4,5,6,7,8,9]))

# user input list
def user_input_list():
    list1=[]
    for i in range(5):
        num = int(input(f"Enter element{i+1}: "))
        list1.append(num)
    return list1




    

    

