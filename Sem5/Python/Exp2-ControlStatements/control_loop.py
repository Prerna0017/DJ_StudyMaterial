def square_root(num):
    for i in range(int(num/2)):
        if num==i*i:
            print("Square root of ",num," is ",i)
            break
square_root(144)

def rectangle_measures(len, breadth):
    print("Area: ",len*breadth)
    print("Perimeter: ",(2*len+breadth))
rectangle_measures(10,5)

def swap(a,b):
    print("a: ",a,"\tb: ",b)
    a = a+b
    b = a-b
    a = a-b
    print("a: ",a,"\tb: ",b)
swap(34,-67)

def addingElements(num):
    list1 = [9,9,9]
    list1.append(num)
    print("List: ",list1)
    set = {6, 6, 6}
    set.add(num)
    print("Set: ",set)
    tup = (7, 7 ,7)
    list_of_tup_elements = list(tup)
    list_of_tup_elements.append(num)
    tup = tuple(list_of_tup_elements)
    print("Tuple: ",tup)
addingElements(88)

def star_pattern1(num):
    for i in range(1,num):
        for j in range(i):
            print("*",end='')
        print()
# star_pattern1(6)

def star_pattern2(num):
    for i in range(1,num+1):
        for j in range(1,num+1):
            if j>num-i:
                print("*",end='')
            else:
                print(" ",end='')
        print()
# star_pattern2(4)
        
def star_pattern3(num):
    k = num-1
    for i in range(0,num):
        for j in range(0,k):
            print(end=' ')
        k-=1
        for j in range(0, i+1):
            print("* ",end='')
        print("\r")
# star_pattern3(5)

def num_pyramid1(num):
    for i in range(1,num):
        for j in range(i):
            print(i," ",end='')
        print()
# num_pyramid1(6)

def num_pyramid2(num):
    for i in range(1,num):
        for j in range(i):
            print(j+1," ",end='')
        print()
# num_pyramid2(6)

def num_pyramid3(num):
    count=0
    for i in range(1,num):
        for j in range(i):
            count+=1
            print(count," ",end='')
        print()
# num_pyramid3(6)
        
def fact(num):
    if num==0 or num==1:
        return 1
    else:
        return num*fact(num-1)
print(fact(5))

def fact2(num):
    if num==0 or num==1:
        return 1
    else:
        result = 1
        for i in range(1, num+1):
            result = result*i
    return result
# print(fact2(3))

def fibo(num):
    n1 = 0
    n2 = 1
    print(n1, end=" ")
    print(n2, end=" ")
    for i in range(num):
        s = n1+n2
        print(s, end=" ")
        n1=n2
        n2=s
    print("\r")
fibo(5)

def demoWhile(number):
    while number > 0:
        print(number,end=' ')
        number-=1
    print("\r")
demoWhile(10)

def leapYear_nested(year):
    if (year%4==0):
        if(year%100==0):
            if(year%100==0):
                print(year," is a leap year")
            else:
                print(year," is not a leap year")
        else:
            print(year," is a leap year")
    else:
        print(year," is not a leap year")
leapYear_nested(2024)

def continue_break_pass_demo(num):
    for i in range(num):
        if i == 1:
            pass
        else:
            print("Pass: ",i)
            
        if i==2:
            continue
        if i==7:
            break
        print(i)
continue_break_pass_demo(10)

            

