#include <stdio.h>
#include <string.h>

int main(){
    char ip[15], firstOctet[3], IP_class;
    char network[12], host[12];
    for (int k = 0; k < 12; k++)
        network[k] = host[k] = '\0';
    printf("Enter the IP address (xxx.xxx.xxx.xxx): ");
    scanf("%s", &ip);

    int i = 0;
    while(ip[i] != '.'){
        firstOctet[i] = ip[i];
        i++;
    }
    i--;

    int intIP = 0, j=1;
    while (i>=0){
        intIP = intIP + (firstOctet[i]-'0') *j;
        j = j*10;
        i--;
    }

    // Class A
    if (intIP >=1 && intIP <= 126)
        IP_class = 'A';
 
    // Class B
    else if (intIP >= 128 && intIP <= 191)
        IP_class = 'B';
 
    // Class C
    else if (intIP >= 192 && intIP <= 223)
        IP_class = 'C';
 
    // Class D
    else if (intIP >= 224 && intIP <= 239)
        IP_class = 'D';
 
    // Class E
    else
        IP_class = 'E';

    printf("Class of the IP address is %c\n",IP_class);

    if (IP_class == 'A'){
        i = j = 0;
        while (ip[j] != '.'){
            network[i++] = ip[j++];
        }
        i = 0; j++;
        while (ip[j] != '\0'){
            host[i++] = ip[j++];
        }
        printf("Network ID is %s\n", network);
        printf("Host ID is %s\n", host);
    }

    else if (IP_class == 'B'){
        i=j=0;
        int dotCount = 0;
        while (dotCount<2){
            network[i++] = ip[j++];
            if (ip[j] == '.'){
                dotCount++;
            }
        }
        i=0;j++;
        while (ip[j] != '\0'){
            host[i++] = ip[j++];
        }
        printf("Network ID is %s\n", network);
        printf("Host ID is %s\n", host);
    }

    else if (IP_class == 'C'){
        i=j=0;
        int dotCount = 0;
        while (dotCount<3){
            network[i++] = ip[j++];
            if (ip[j] == '.'){
                dotCount++;
            }
        }
        i=0;j++;
        while (ip[j] != '\0'){
            host[i++] = ip[j++];
        }
        printf("Network ID is %s\n", network);
        printf("Host ID is %s\n", host);
    }

    else{
        printf("In this Class, IP address is not divided into Network and Host ID\n");
    }
}