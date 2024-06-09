#include <stdio.h>
#define N 5
int count=0;

int helper(int arr[], int sum, int tempSum, int i){
    count+=1;
    if (sum == tempSum){
        printf("\n%d + %d\n",arr[i-1],tempSum-arr[i-1]);
        return 1;
    }

//backtracking
    if (tempSum>sum){
        return 0;
    }

    if (i >= N){
        //sol not found
        return 0;
    }

    int recCall1 = helper(arr, sum, tempSum+arr[i], i+1);
    int recCall2 = helper(arr, sum, tempSum, i+1);

    return recCall1 || recCall2;
}

int subset (int arr[], int sum){
    return helper(arr, sum, 0, 0);
}

int main(){
   int arr[N]  = {10, 12, 6, 22, 0};
   int sum = 22;

    if (!subset(arr, sum)){
        printf("No solution Found\n");
    }

    printf("function call Count: %d",count);
}