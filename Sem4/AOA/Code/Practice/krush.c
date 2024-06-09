#include<stdio.h>
#define MAX 10
int parent[MAX];

int find(int i){
    while (parent[i] != i){
        i = parent[i];
    }
    return i;
}

void union_ij(int i, int j){
    int a = find(i);
    int b = find(j);
    parent[a] = b;
}

void krushkal(int cost[MAX][MAX], int n){
    int mincost = 0,a,b,i,j,u,v,ne = 1;

    for(i = 1; i<=n; i++){
        parent[i] = i;
    }

    while (ne < n){
        int min = 999;
        for (i = 1; i<=n; i++){
            for (j=1; j<=n; j++){
                if (find(i)!=find(j) && cost[i][j]<min){
                    min = cost[i][j];
                    a = u = i;
                    b = v = j;
                }
            }
        }
        if (find(u)!=find(v)){
            printf("\nEdge %d:\t(%d,%d)\tCost %d\n",ne++, a, b, min);
            mincost+=min;
            union_ij(u,v);
        }
        cost[a][b] = cost[b][a] = 999;
    }
    printf("\nMinimum cost: %d",mincost);

    
    
}

int main(){
    int cost[MAX][MAX] = {
        { -1, -1, -1, -1, -1, -1},
        { -1, 999, 2, 999, 6, 999},
        { -1, 2, 999, 3, 8, 5},  
        { -1, 999, 3, 999, 999, 7},
        { -1, 6, 8, 999, 999, 9},
        { -1, 999, 5, 7, 9, 999}
    };  
    int n = 5;
    krushkal(cost, n);
    return 0;
}