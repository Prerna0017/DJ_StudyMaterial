def merge_sort(file1, file2, output_file):
    # Open the input files for reading and the output file for writing
    with open(file1, 'r') as f1, open(file2, 'r') as f2, open(output_file, 'w') as out:
        # Read the initial lines from both files
        num1 = f1.readline().strip()
        num2 = f2.readline().strip()

        # Initialize empty strings to store merged content
        merged_content = ""

        # Merge and sort the content
        while num1 and num2:
            if int(num1) < int(num2):
                merged_content += num1 + '\n'
                num1 = f1.readline().strip()
            else:
                merged_content += num2 + '\n'
                num2 = f2.readline().strip()

        # Append any remaining content from file1
        while num1:
            merged_content += num1 + '\n'
            num1 = f1.readline().strip()

        # Append any remaining content from file2
        while num2:
            merged_content += num2 + '\n'
            num2 = f2.readline().strip()

        # Write the sorted merged content to the output file
        out.write(merged_content)

# Input and output file names
file1_name = "file1.txt"
file2_name = "file2.txt"
output_file_name = "file3.txt"

# Call the merge_sort function to merge and sort the files
merge_sort(file1_name, file2_name, output_file_name)

print(f"Sorted and merged content saved in {output_file_name}")
