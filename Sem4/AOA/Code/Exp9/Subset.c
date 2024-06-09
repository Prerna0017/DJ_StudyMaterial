#include <stdio.h>
int m, n, arr[100], x[100] = {0};
int SumOfSubsets(int s, int k, int r)
{
    x[k] = 1;
    if (s + arr[k] == m)
    {
        for (int j = k + 1; j < n; j++)
        {
            x[j] = 0;
        }
        printf("Answer is\n");
        for (int i = 0; i < n; i++)
        {
            printf("%d ", x[i]);
        }
        printf("\n");
    }
    else if (s + arr[k] + arr[k + 1] <= m)
    {
        SumOfSubsets(s + arr[k], k + 1, r - arr[k]);
    }
    if (s + r - arr[k] >= m && s + arr[k + 1] <= m)
    {
        x[k] = 0;
        SumOfSubsets(s, k + 1, r - arr[k]);
    }
}
int main()
{
    int s = 0;
    printf("Sum of Subsets\nEnter the number of elements: ");
    scanf("%d", &n);
    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
        s += arr[i];
    }
    printf("Enter the sum needed: ");
    scanf("%d", &m);
    SumOfSubsets(0, 0, s);
    return 0;
}