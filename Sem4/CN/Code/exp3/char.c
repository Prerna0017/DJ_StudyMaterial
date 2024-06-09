#include <stdio.h>
#include <string.h>

char* sender(int n){
    char length[1];
    char data_unit[20];
    static char data_to_be_transmitted[100];

    for (int i = 0; i<n; i++){
        printf("Enter %d data unit: ",i+1);
        scanf("%s", data_unit);

        length[0] = (strlen(data_unit) + 1) + '0';
        printf("length: %d",length[0]);

        strcat(data_to_be_transmitted, length);
        // strcat(data_to_be_transmitted, data_unit);
    }


    return data_to_be_transmitted;
}

int main(){
    int n;
    char *data_to_be_transmitted;
    printf("Enter the no. of data units: ");
    scanf("%d", &n);

    data_to_be_transmitted = sender(n);

    printf("Data to be transmitted: %s", data_to_be_transmitted);
    return 0;
}