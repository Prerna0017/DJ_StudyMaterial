stack = []
arr = [8,3,1,9,8,7,3,6]
operations = 0
total_cost = 0
unit = []

def push(element):
    global stack,operations,total_cost,unit
    stack.append(element)
    operations+=1
    total_cost+=1
    unit.append(1)
    print("Stack after pushing ",element,": ",stack)

def pop():
    global stack,operations,total_cost,unit
    if len(stack)==0: return
    stack.pop()
    operations+=1
    total_cost+=1
    unit.append(1)

def multipop(n, length):
    for i in range(n):
        pop()
    print("Stack after poping ",n,"elements: ",stack,"\t\t(As",n,"is less than stack length",length,")")
    
for i in arr:
    print("For element: ",i)
    if i<=len(stack):
        multipop(i, len(stack))
    push(i)

print("T(n) = ",sum(unit)," and Total cost: ",total_cost)
print("Amortized Cost: ",sum(unit)//operations)