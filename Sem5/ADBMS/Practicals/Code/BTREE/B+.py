from bplustree import BPlusTree
import time

tree = BPlusTree('Practicals/Code/BTREE/b1.db', order=50)

for i in range(1000):
    tree[i] = (2*i).to_bytes(10, 'big')
    
data = int(input("Enter key : "))

start_time = time.time()
byte_data = tree.get(data)
end_time = time.time()

int_data = int.from_bytes(byte_data, 'big')
print("Value : ", int_data)
print("Time taken : ", (end_time-start_time)*1000," ms")
