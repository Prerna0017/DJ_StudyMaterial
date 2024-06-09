// C program for the above approach
#include <stdio.h>
#include <string.h>

// Function for bit stuffing
void bitStuffing(int N, int arr[])
{
	int brr[30];
	int i=0, j=0, k;
	while (i < N) {
		if (arr[i] == 1) {
			int count = 1;
			brr[j] = arr[i];
			for (k = i + 1;arr[k] == 1 && k < N && count < 5; k++) {
				j++;
				brr[j] = arr[k];
				count++;
				if (count == 5) {
					j++;
					brr[j] = 0;
				}
				i = k;
			}
		}
		else {
			brr[j] = arr[i];
		}
		i++;
		j++;
	}

	// Print Answer
	for (i = 0; i < j; i++)
		printf("%d", brr[i]);
}


// Function for bit de-stuffing
void bitDestuffing(int N, int arr[])
{
	int brr[30];
	int i=0, j=0, k;
	int count = 1;//
	while (i < N) {
		if (arr[i] == 1) {
			brr[j] = arr[i];
			for (k = i + 1; arr[k] == 1 && k < N && count < 5; k++) {
				j++;
				brr[j] = arr[k];
				count++;
				if (count == 5) {
					k++;//
				}
				i = k;
			}
		}
		else {
			brr[j] = arr[i];
		}
		i++;
		j++;
	}

	// Print Answer
	for (i = 0; i < j; i++)
		printf("%d", brr[i]);
}


// Driver Code
int main()
{
	int N = 6;

	int arr[] = { 1, 1, 1, 1, 1, 1 };

	printf("\nAfter Bit Stuffing:\t");
	bitStuffing(N, arr);

	printf("\n\nAfter Bit DeStuffing:\t");
    int arr2[] = {1,1,1,1,1,0,1};

    bitDestuffing(N, arr2);

	return 0;
}
