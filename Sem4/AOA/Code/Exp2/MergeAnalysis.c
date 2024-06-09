#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void mergeDesc(int arr[], int p, int q, int r)
{

  // Create L ← A[p..q] and M ← A[q+1..r]
  int n1 = q - p + 1;
  int n2 = r - q;

  int L[n1], M[n2];

  for (int i = 0; i < n1; i++)
    L[i] = arr[p + i];
  for (int j = 0; j < n2; j++)
    M[j] = arr[q + 1 + j];

  // Maintain current index of sub-arrays and main array
  int i, j, k;
  i = 0;
  j = 0;
  k = p;

  // Until we reach either end of either L or M, pick larger among
  // elements L and M and place them in the correct position at A[p..r]
  while (i < n1 && j < n2)
  {
    if (L[i] >= M[j])
    {
      arr[k] = L[i];
      i++;
    }
    else
    {
      arr[k] = M[j];
      j++;
    }
    k++;
  }

  // When we run out of elements in either L or M,
  // pick up the remaining elements and put in A[p..r]
  while (i < n1)
  {
    arr[k] = L[i];
    i++;
    k++;
  }

  while (j < n2)
  {
    arr[k] = M[j];
    j++;
    k++;
  }
}

// Divide the array into two subarrays, sort them and merge them
void mergeSortDesc(int arr[], int l, int r)
{
  if (l < r)
  {

    // m is the point where the array is divided into two subarrays
    int m = l + (r - l) / 2;

    mergeSortDesc(arr, l, m);
    mergeSortDesc(arr, m + 1, r);

    // Merge the sorted subarrays
    mergeDesc(arr, l, m, r);
  }
}
// Merge two subarrays L and M into arr
void merge(int arr[], int p, int q, int r)
{

  // Create L ← A[p..q] and M ← A[q+1..r]
  int n1 = q - p + 1;
  int n2 = r - q;

  int L[n1], M[n2];

  for (int i = 0; i < n1; i++)
    L[i] = arr[p + i];
  for (int j = 0; j < n2; j++)
    M[j] = arr[q + 1 + j];

  // Maintain current index of sub-arrays and main array
  int i, j, k;
  i = 0;
  j = 0;
  k = p;

  // Until we reach either end of either L or M, pick larger among
  // elements L and M and place them in the correct position at A[p..r]
  while (i < n1 && j < n2)
  {
    if (L[i] <= M[j])
    {
      arr[k] = L[i];
      i++;
    }
    else
    {
      arr[k] = M[j];
      j++;
    }
    k++;
  }

  // When we run out of elements in either L or M,
  // pick up the remaining elements and put in A[p..r]
  while (i < n1)
  {
    arr[k] = L[i];
    i++;
    k++;
  }

  while (j < n2)
  {
    arr[k] = M[j];
    j++;
    k++;
  }
}

// Divide the array into two subarrays, sort them and merge them
void mergeSort(int arr[], int l, int r)
{
  if (l < r)
  {

    // m is the point where the array is divided into two subarrays
    int m = l + (r - l) / 2;

    mergeSort(arr, l, m);
    mergeSort(arr, m + 1, r);

    // Merge the sorted subarrays
    merge(arr, l, m, r);
  }
}

// Driver program
int main()
{
  clock_t start, stop;
  clock_t start_b, stop_b;
  clock_t start_w, stop_w;

  int size = 10000;

  int arr[size];

  for (int i = 0; i < size; i++)
  {
    arr[i] = rand();
  }

  start = clock();
  // sorting jumbled array
  mergeSort(arr, 0, size - 1);
  stop = clock();
  float res = stop - start;
  printf("\nAvg case CPU time =%f units", res);

  // sorting sorted array
  start_b = clock();
  mergeSort(arr, 0, size - 1);
  stop_b = clock();
  float x = stop_b - start_b;
  printf("\nBest case CPU time =%f units", x);

  // sorting sorted array in descending order
  start_w = clock();
  mergeSortDesc(arr, 0, size - 1);
  stop_w = clock();
  x = stop_w - start_w;
  printf("\nworst case CPU time =%f units", x);
}
