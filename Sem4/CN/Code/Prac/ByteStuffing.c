#include <stdio.h>
#include <string.h>

int main(){
    int i, j, n, len;
    char send[n][100], receive[100];

    printf("***********Sender***********\n");
    
    printf("Enter the no. of frames: ");
    scanf("%d", &n);

    for (i = 0; i<n; i++){
        printf("Frame %d: ",(i+1));
        scanf("%s",&send[i]);
    }

    printf("\nData to be sent: \n");
    for (int i = 0; i<n; i++){
        printf("$");
        for (j=0; j<strlen(send[i]); j++){
            if (send[i][j]=='$' || send[i][j]=='#'){
                printf("#");
            }
            printf("%c",send[i][j]);
        }
        printf("$");
    }

    printf("\n\n***********Receiver***********\n");

    printf("\nEnter the received data: ");
    scanf("%s",receive);

    len=strlen(receive);
    i=1;

    while(i<len-1){
        printf("\n");
        do{
            if(receive[i] == '#'){
                i++;
            }
            printf("%c",receive[i]);
            i++;
        }while(receive[i] != '$');
        i++;
        if(receive[i] == '$'){
            i++;
        }
        else{
            break;
        }
    }
}