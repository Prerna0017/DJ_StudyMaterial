import random
import time

def lumoto_partitoning(low, high, data):
    i = low
    j = low
    pivot = data[high]

    while j<high:
        if data[j]<pivot:
            data[i], data[j] = data[j],data[i]
            i+=1
        j+=1

    data[i],data[high] = data[high], data[i]
    return i

def quick_sort(low, high, data):
    if low<high:
        p = lumoto_partitoning(low, high, data)
        quick_sort(low, p-1, data)
        quick_sort(p+1, high, data)

def randomized_partitioning(low, high, data):
    rand_index = random.randint(low, high)
    data[rand_index], data[high] = data[high], data[rand_index]
    return lumoto_partitoning(low, high, data)

def quick_sort_rand(low, high, data):
    if low<high:
        p = randomized_partitioning(low, high, data)
        quick_sort(low, p-1, data)
        quick_sort(p+1, high, data)

data = [i for i in range(900,0,-1)]
start = time.time()
quick_sort(0,len(data)-1,data)
end = time.time()
print("Time taken (Lumoto): ",end-start)

data = [i for i in range(900,0,-1)]
start = time.time()
quick_sort_rand(0,len(data)-1,data)
end = time.time()
print("Time taken (Lumoto with Randomization): ",end-start)