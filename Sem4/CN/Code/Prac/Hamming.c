#include<stdio.h>

int main(){
    int c, c1, c2, c3;
    int data[7];
    printf("***********Sender***********\n");

    printf("Enter data Bit 1: ");
    scanf("%d", &data[0]);
    printf("Enter data Bit 2: ");
    scanf("%d", &data[1]);
    printf("Enter data Bit 3: ");
    scanf("%d", &data[2]);
    printf("Enter data Bit 4: ");
    scanf("%d", &data[4]);

    data[6] = data[0] ^ data[2] ^ data[4];      //p1-->1st parity
    data[5] = data[0] ^ data[1] ^ data[4];      //p2-->2nd parity
    data[3] = data[0] ^ data[1] ^ data[2];      //p3-->3rd parity

    printf("\nData to be sent:\n");
    for (int i = 0; i<7; i++){
        printf("%d",data[i]);
    }

    printf("\n***********Receiver***********\n");

    printf("Enter the data received\n");
    for (int i  = 0; i<7; i++){
        printf("Enter data bit %d: ",(i+1));
        scanf("%d",&data[i]);
    }

    c1 = data[6] ^ data[0] ^ data[2] ^ data[4];
    c2 = data[5] ^ data[0] ^ data[1] ^ data[4];
    c3 = data[3] ^ data[0] ^ data[1] ^ data[2];

    c = 4 * c3 + 2 * c2 + c1;

    if (c==0){
        printf("No Error");
    }
    else{
        printf("Error Detected at %d", c);
        if (data[7-c] == 1){
            data[7-c] = 0;
        }
        else{
            data[7-c] = 1;
        }
        printf("\nCorrected data: ");
        for (int i  = 0; i<7; i++){
            printf("%d",(data[i]));
        }

    }

}