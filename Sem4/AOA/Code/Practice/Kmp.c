#include <stdio.h>
#include <string.h>

char pat[] = "bc";
char Text[] = "abfdabc";

int lps[100];

void computeLPS(){
    int len = 0, i = 1;
    int M = strlen(pat);
    lps[0] = 0;
    while(i<M){
        if (pat[i] == pat[len]){
            len++;
            pat[i] = len;
            i++;
        }
        else{
            if(len!=0){
                len = lps[len - 1];
            }
            else{
                lps[i] = 0;
                i++;
            }
        }
    }
}

void KMP(char Pattern[], char Text[]){
    int M = strlen(pat);
    int N = strlen(Text);
    int i = 0;
    int j = 0;
    computeLPS();

    while (i<N){
        if (Text[i] == pat[j]){
            i++;
            j++;
        }
        if (j == M){
            printf("Found the string at index %d",i-j);
            j = lps[j-1];
        }
        else if(Text[i] != pat[j]){
            if (j!=0){
                j = lps[j - 1];
            }
            else{
                i++;
            }
        }
    }
    

}

int main(){
    KMP(pat, Text);
    return 0;
}