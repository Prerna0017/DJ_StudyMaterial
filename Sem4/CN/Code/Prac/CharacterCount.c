#include <stdio.h>
#include <string.h>

int main(){
    int i, j, k, n, count, c, len;
    char send[n][100], receive[100];
    printf("***********Sender***********\n");
    
    printf("Enter the no. of frames: ");
    scanf("%d", &n);
    for (i = 0; i<n; i++){
        printf("Frame %d: ",(i+1));
        scanf("%s",&send[i]);
    }
    for (i = 0; i<n ; i++){
        c = strlen(send[i])+1;
        printf("%d%s", c, send[i]);
    }

    printf("***********Receiver***********\n");

    printf("Enter the received data: ");
    scanf("%s",&receive);

    len = strlen(receive);

    for (i = 0; i<len; i++){
        c = receive[i]-'0'-1;
        count = 0;
        while (count<c){
            i++;
            printf("%c",receive[i]);
            count++;
        }
        printf("\n");
    }
    return 0;
}