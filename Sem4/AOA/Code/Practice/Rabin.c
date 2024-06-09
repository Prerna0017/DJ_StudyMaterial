#include <stdio.h>
#include <string.h>
#define d 23

void rabin(char T[], char P[], int q){
    int n = strlen(T);
    int m = strlen(P);
    int i,j, p = 0, t = 0, h = 1;

    for (int i = 0; i<m-1; i++){
        h = (h*d)%q;
    }

    for (int i = 0; i<m;i++){
        p = (d*p + P[i])%q;
        t = (d*t + T[i])%q;
    }

    for (int i = 0; i<=n-m; i++){
        if (p==t){
            for (j=0; j<m; j++){
                if (P[j] != T[i+j]){
                    return;
                }
            }
            if (j==m){
                printf("Pattern found at index %i",i);
            }
        }
        if(i<n-m){
            t = (d*(t-T[i]*h) + T[i+m])%q;
            if (t<0){
                t+=q;
            }
        }
    }


    
}

int main(){
    char Pattern[20];
    char Text[20];

    printf("Enter a string: ");
    scanf("%s", &Text);

    printf("Enter a Pattern to be checked: ");
    scanf("%s", &Pattern);

    int hashValue = 23;

    rabin(Text, Pattern, hashValue);
    
    return 0;
}