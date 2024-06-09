#include <stdio.h>
#include <string.h>

#define N strlen(gen_poly)

char data[28];
char check_value[28];
char gen_poly[28];
int data_length, i , j;

void XOR(){
    for (j=1; j<N; j++){
        check_value[j] = (check_value[j] == gen_poly[j]) ? '0' : '1';
    }
}

void crc(){
    for (i = 0; i<N; i++){
        check_value[i] = data[i];
    }

    do{
        
        if (check_value[0] == '1'){
            XOR();
        }

        for (j = 0; j<N-1; j++){
            check_value[j] = check_value[j+1];
        }

        check_value[j] = data[i++];
    }while(i<=data_length+N-1);
}

void receiver(){
    printf("\n----------------------------\n");
    printf("Enter the data received: ");
    scanf("%s",data);
    crc();

    for (i = 0; (i<N-1) && (check_value[i]!='1'); i++);
        if (i<N-1){
            printf("Error");
        }
        else{
            printf("No error");
        }
    
}

int main(){
    
    printf("Enter data: ");
    scanf("%s",data);

    printf("Enter the generating polynomial: ");
    scanf("%s",gen_poly);

    //append zero
    data_length = strlen(data);
    for (i = data_length; i<N; i++){
        data[i] = '0';
    }

    printf("\n----------------------------\n");

    printf("Data with padded zeros %s\n",data);

    printf("----------------------------\n");

    crc();

    printf("\nCRC or Check value is : %s",check_value);

    receiver();

    return 0;
}