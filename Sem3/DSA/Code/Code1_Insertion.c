#include <stdio.h>
#include <conio.h>
void ins(int a[], int n)
{
    int no, i, j;
    for (i = 1; i < n; i++)
    {
        no = a[i];
        for (j = i - 1; j >= 0; j--)
        {
            if (a[j] > no)
                a[j + 1] = a[j];
            else
                break;
        }
        a[j + 1] = no;
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
    ins(a, n);
    printf("The sorted elements are as follows: \n");
    for (r = 0; r < n; r++)
    {
        printf("%d\n", a[r]);
    }
    getch();
}
