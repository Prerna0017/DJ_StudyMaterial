#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
    clock_t start, stop;
    clock_t start_b, stop_b;
    clock_t start_w, stop_w;

    int n = 10000, i, j, position, swap;
    int a[n];
    for (i = 0; i < n; i++)
    {
        a[i] = rand();
    }

    // sorts a jumbled array to give average case time complexity
    start = clock();

    for (i = 0; i < n - 1; i++)
    {
        position = i;
        for (j = i + 1; j < n; j++)
        {
            if (a[position] > a[j])
                position = j;
        }
        if (position != i)
        {
            swap = a[i];
            a[i] = a[position];
            a[position] = swap;
        }
    }
    stop = clock();
    float res = stop - start;
    printf("\nAverage case CPU time =%f units", res);

    // sorts sorted array to give the best case time complexity
    start_b = clock();
    for (i = 0; i < n - 1; i++)
    {
        position = i;
        for (j = i + 1; j < n; j++)
        {
            if (a[position] > a[j])
                position = j;
        }
        if (position != i)
        {
            swap = a[i];
            a[i] = a[position];
            a[position] = swap;
        }
    }
    stop_b = clock();
    float x = stop_b - start_b;
    printf("\nBest case CPU time =%f units", x);

    // sorts the array in descending order to give worst case time complexity
    start_w = clock();

    for (i = 0; i < n - 1; i++)
    {
        position = i;
        for (j = i + 1; j < n; j++)
        {
            if (a[position] < a[j])
                position = j;
        }
        if (position != i)
        {
            swap = a[i];
            a[i] = a[position];
            a[position] = swap;
        }
    }
    stop_w = clock();
    x = stop_w - start_w;
    printf("\nworst case CPU time =%f units", x);
    return 0;
}