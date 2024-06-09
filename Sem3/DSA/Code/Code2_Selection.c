#include <stdio.h>
#include <conio.h>
void select(int a[], int n)
{
    int i, r, j, min, index;
    for (i = 0; i < n - 1; i++)
    {
        min = a[i];
        index = i;
        for (j = i + 1; j < n; j++)
        {
            if (min > a[j])
            {
                index = j;
                min = a[j];
            }
        }

        a[index] = a[i];
        a[i] = min;
    }
    printf("Sorted elements are as follows:\n");
    for (r = 0; r < n; r++)
    {
        printf("%d\n", a[r]);
    }
}
void main()
{
    printf("Prerna Sunil Jadhav - 60004220127\n");

    int a[100], n, r;
    printf("Enter the number of elements: \n");
    scanf("%d", &n);
    printf("Enter the elements: \n");
    for (r = 0; r < n; r++)
        scanf("%d", &a[r]);
    select(a, n);
    getch();
}
