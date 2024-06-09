def merge_sort(file1, file2, outputFile):
    with open(file1, 'r') as f1, open(file2, 'r') as f2, open(outputFile, 'w') as op:
        num1 = f1.readline().strip()
        num2 = f2.readline().strip()

        while num1 and num2:
            if num1<num2:
                op.write(num1)
                op.write("\n")
                num1 = f1.readline().strip()
            else:
                op.write(num2)
                op.write("\n")
                num2 = f2.readline().strip()
            

        while num1:
            op.write(num1)
            op.write("\n")
            num1 = f1.readline().strip()
        
        while num2:
            op.write(num2)
            op.write("\n")
            num2 = f2.readline().strip()

        f1.close()
        f2.close()
        op.close()

merge_sort("Exp6/mergeSortFiles/file1.txt", "Exp6/mergeSortFiles/file2.txt", "Exp6/mergeSortFiles/op.txt")