def accounting(n):
    size = 1
    total = 0
    doubling_cost = 0 
    insertion_cost = 0
    balance = 0

    print("Doubling Cost\tInsertion Cost\tTotal Cost\tBalance\t\tSize\n")

    for i in range(1, n+1):
        insertion_cost=1
        if i>size:
            size*=2
            doubling_cost = i-1
        total = doubling_cost+insertion_cost
        balance+=(3-total)
        print(doubling_cost,"\t\t",insertion_cost,"\t\t",total,"\t\t",balance,"\t\t",size)

        doubling_cost = 0
        insertion_cost = 0

accounting(10)


