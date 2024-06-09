#include <stdio.h>

int main()
{
    int route_Table[12][4] = {
        {0, 24, 20, 21},
        {12, 36, 31, 28},
        {25, 18, 19, 36},
        {40, 27, 8, 24},
        {14, 7, 30, 22},
        {23, 20, 19, 40},
        {18, 31, 6, 31},
        {17, 20, 0, 19},
        {21, 0, 14, 22},
        {9, 11, 7, 10},
        {24, 22, 22, 0},
        {29, 33, 9, 9}};

    int J_delay[] = {8, 10, 12, 6};
    int temp[4];
    int answer[12][2];

    for (int i = 0; i < 12; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            temp[j] = J_delay[j] + route_Table[i][j];
        }
        int min = 9999, min_index = -1;
        for (int j = 0; j < 4; j++)
        {
            if (temp[j] < min)
            {
                min = temp[j];
                min_index = j;
            }
        }

        answer[i][0] = min;
        answer[i][1] = min_index;
    }

    printf("\n\nDVR\n\n");

    for (int i = 0; i < 12; i++)
    {
        printf("%d\t\t", answer[i][0]);
        if (answer[i][1] == 0)
        {
            printf("A");
        }
        if (answer[i][1] == 1)
        {
            printf("I");
        }
        if (answer[i][1] == 2)
        {
            printf("H");
        }
        if (answer[i][1] == 3)
        {
            printf("K");
        }
        printf("\n");
    }
}