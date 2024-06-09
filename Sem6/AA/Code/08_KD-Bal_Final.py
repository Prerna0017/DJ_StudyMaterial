class Node:
    def __init__(self, data):
        self.data = data
        self.depth = 0
        self.left = None
        self.right = None

def traverse_in_order(curr):
    if curr is None:
        return
    traverse_in_order(curr.left)
    print(f"({', '.join(map(str, curr.data))}) ", end="")
    traverse_in_order(curr.right)

def make_kd_tree(seq, depth=0):
    if len(seq) == 0:
        return None
    
    k = len(seq[0]) #no of dimensions
    dim = depth % k 
   
    seq.sort(key=lambda x: x[dim])
    mid = len(seq) // 2
    mid_elem = seq[mid]
   
    root = Node(mid_elem)
    left_sub_arr = seq[:mid]
    right_sub_arr = seq[mid+1:] 
   
    root.depth = depth
    root.left = make_kd_tree(left_sub_arr, depth+1)
    root.right = make_kd_tree(right_sub_arr, depth+1)
   
    return root

# if __name__ == "__main__":
seq = [[6,2], [7,1], [2,9], [3,6], [4,8], [8,4], [5,3], [1,5], [9,5]]
root = make_kd_tree(seq)
print("Inorder Traversal: ",end='')
traverse_in_order(root)