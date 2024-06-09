#include <stdio.h>
#include <stdlib.h>
#include <time.h>
// Function to swap two elements
void swap(int* a, int* b) {
	int t = *a;
	*a = *b;
	*b = t;
}

// Partition the array using the last element as the pivot
int partition(int arr[], int low, int high) {
	int pivot = arr[high];
	int i = (low - 1);

	for (int j = low; j <= high - 1; j++) {
		if (arr[j] < pivot) {
			i++;
			swap(&arr[i], &arr[j]);
		}
	}
	swap(&arr[i + 1], &arr[high]);
	return (i + 1);
}

// Function to implement Quick Sort
void quickSort(int arr[], int low, int high) {
	if (low < high) {
		int pi = partition(arr, low, high);
		quickSort(arr, low, pi - 1);
		quickSort(arr, pi + 1, high);
	}
}

// Function to print the array
void printArray(int arr[], int size) {
	int i;
	for (i = 0; i < size; i++)
		printf("%d ", arr[i]);
	printf("\n");
}

// Driver program
int main() {
   clock_t start, stop;
   clock_t start_w, stop_w;

	int n = 5000;
	int arr[n];
	for (int i = 0; i<n; i++){
		arr[i] = rand();
	}

   start = clock();

	quickSort(arr, 0, n - 1);
   stop = clock();
   float res = stop - start;
   printf("\nAverage/best case CPU time =%f units", res);

   start_w = clock();
	//worst case
	quickSort(arr, 0, n - 1);
   stop_w = clock();
   float x = stop_w - start_w;
   printf("\nworst case CPU time =%f units\n", x);

	return 0;
}