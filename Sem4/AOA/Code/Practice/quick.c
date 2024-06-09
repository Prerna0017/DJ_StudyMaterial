// C code for the recursive function of Quicksort
#include <stdio.h>

int partition(int array[], int low, int high)
{

    // selecting the rightmost element as pivot
    int pivot = array[high];

    // setting the left pointer to point at the lowest index initially
    int left = low;

    // setting the left pointer to point at the lowest index initially
    int right = high - 1;

    // running a loop till left is smaller than right
    while (left <= right)
    {

        // incrementing the value of left until the value at left'th
        // index is smaller than pivot
        while (array[left] < pivot)
        {
            left++;
        }

        // decrementing the value of right until the value at right'th
        // index is greater than pivot
        while (array[right] > pivot)
        {
            right--;
        }

        if (left < right)
        {
            // swapping the elements at left & right index
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    // swapping pivot with the element where left and right meet
    int temp = array[left];
    array[left] = array[high];
    array[high] = temp;

    // return the partition point
    return (left);
}

void quickSort(int array[], int low, int high)
{
    if (low < high)
    {

        // since this function returns the point where the array is
        // partitioned, it is used to track the subarrays/partitions in
        // the array
        int pi = partition(array, low, high);

        // recursively calling the function on left subarray
        quickSort(array, low, pi - 1);

        // recursively calling the function on right subarray
        quickSort(array, pi + 1, high);
    }
}

// Main Function
int main()
{ 
    int size = 6;
    int array[] = {11, 9, 6, 16, 8, 9};

    quickSort(array, 0, size - 1);

    int i;
    for (i = 0; i < size; i++)
    {
        printf("%d ", array[i]);
    }
}
