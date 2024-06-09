import random
import time

def hoare_partitioning(low, high, data):
    i = low-1
    j = high+1
    pivot = data[low]

    while True:

        i+=1
        if data[i]<pivot:
            i+=1

        j-=1
        if data[j] >pivot:
            j-=1

        if i>=j:
            return j
        
        data[i], data[j] = data[j], data[i]

def quick_sort(low, high, data):
    if low<high:
        p = hoare_partitioning(low,high,data)
        quick_sort(low, p, data)
        quick_sort(p+1, high, data)

def randomized_partitioning(low, high, data):
    random_index = random.randint(low, high)
    data[random_index], data[low] = data[low], data[random_index]
    return hoare_partitioning(low, high, data)

def quick_sort_rand(low, high, data):
    if low<high:
        p = randomized_partitioning(low,high,data)
        quick_sort(low, p, data)
        quick_sort(p+1, high, data)

data = [i for i in range(900, 0, -1)]
start = time.time()
quick_sort(0, len(data)-1, data)
end = time.time()
print("Time Taken (Hoare): ",end-start)

data = [i for i in range(900, 0, -1)]
start = time.time()
quick_sort_rand(0, len(data)-1, data)
end = time.time()
print("Time Taken (Hoare with Randomization): ",end-start)

