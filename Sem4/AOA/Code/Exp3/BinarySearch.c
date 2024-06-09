#include <stdio.h>

int binarySearch(int a[], int low, int high, int key){
    if (high >= low){
        int mid = low + (high-low)/2;
        if (key == a[mid]){
            return mid;
        }
        else if(a[mid] > key){
            binarySearch(a, low, mid-1, key);
        }
        else{
            binarySearch(a, mid+1, high, key);
        }
    }
    else{
        return -1;
    }
}
int main(){
    int a[] = {1,2,3,4,5,6,7,8,9,10};
    int low = 0;
    int high = 9;
    printf("Enter any element: ");
    int num=0;
    scanf("%d", &num);
    int flag = binarySearch(a, low, high, num);
    if (flag == -1){
        printf("Element not found");
    }
    else{
        printf("Element found at %d index",flag);
    }
    return 0;
}


