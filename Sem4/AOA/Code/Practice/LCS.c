#include <stdio.h>
#include <stdlib.h>

int i, j, m, n, LCS[20][20];
char S1[20] = "ABDCF", S2[20] = "BDF";

void LCS_Algo(){
    
    n = strlen(S2);
    m = strlen(S1);

    for (i = 0; i<=m; i++){
        LCS[i][0] = 0;
    }

    for (i = 0; i<=n; i++){
        LCS[0][i] = 0;
    }

    for (i = 1; i<=m ; i++){
        for (j=1; j<=n; j++){
            if (S1[i-1] == S2[j-1]){
                LCS[i][j] = LCS[i-1][j-1] + 1;
            }
            else if (LCS[i-1][j] >= LCS[i][j-1]) 
            {
                LCS[i][j] = LCS[i-1][j];
            }
            else{
                LCS[i][j] = LCS[i][j-1];
            } 
        }
    }

    for (i = 1; i<=m ; i++){
        for (j=1; j<=n; j++){
            printf("%d\t",LCS[i][j]);
        }
        printf("\n");
    }

    int index = LCS[m][n];
    char lcsAlgo[index+1];
    lcsAlgo[index] = '\0';
    int i = m, j = n;
    while(i>0 && j>0){
        if (S1[i-1] == S2[j-1]){
            lcsAlgo[index-1] = S1[i-1];
            i--;
            j--;
            index--;
        }
        else if(LCS[i-1][j]>LCS[i][j-1]){
            i--;
        }
        else{
            j--;
        }
    }

    printf("\nS1: %s\nS2: %s\n",S1,S2);
    printf("LCS: %s",lcsAlgo);
}   

int main(){
    LCS_Algo();
}