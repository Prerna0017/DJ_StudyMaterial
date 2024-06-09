#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

char *sender(int n)
{
    static char ch[100];
    char data_unit[30];
    char length[1];

    for (int i = 0; i < n; i++)
    {
        printf("Enter the Data Unit %d: ", (i + 1));
        scanf("%s", data_unit);
        length[0] = (strlen(data_unit) + 1) + '0';
        strcat(ch, length);
    }
    return ch;
}

void receiver(char *data)
{
    size_t i = 0;
    int count = 0;
    printf("\nThe Data Units transferred were: \n");
    while (data[i] != '\0')
    {
        int isADigit = isdigit(data[i]);
        if (isADigit == 1)
        {
            count++;
            printf("Data Unit %d: ", count);
            int dataUnitLen = 0;
            dataUnitLen = data[i] - '0';
            for (int j = 0; j < dataUnitLen - 1; j++)
            {
                i++;
                printf("%c", data[i]);
            }
            i++;
            printf("\n");
        }
    }
}

int main()
{
    int n = 0;
    char *data_To_Be_Transmitted;

    printf("Enter the number of data units: ");
    scanf("%d", &n);

    if (n <= 0)
    {
        printf("No data units received");
        return 1;
    }

    data_To_Be_Transmitted = sender(n);

    printf("Data String to be Transmitted: %s", data_To_Be_Transmitted);

    receiver(data_To_Be_Transmitted);

    return 0;
}