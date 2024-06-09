#include <stdio.h>
#include <stdbool.h>
#define V 4

bool isSafe(int v, int c, int graph[V][V], int color[V]){
    for (int i = 0; i<V; i++){
        if (graph[i][v] && c == color[i]){
            return false;
        }
    }
    return true;
}

bool colorGraph(int graph[V][V], int m, int color[V], int v){
    if (v==V){
        return true;
    }
    for (int c = 1; c<=m ; c++){
        if (isSafe(v,c,graph,color)){
            color[v] = c;
            if (colorGraph(graph,m,color,v+1)){
                return true;
            }
            color[v] = 0;
        }
    }
    return false;
}

void printSol(int color[V]){
    for (int i = 0; i<V; i++){
        printf("%d --> %d\n",i,color[i]);
    }
}
int main(){
    int graph[V][V] = {
        { 0, 1, 1, 1 },
        { 1, 0, 1, 0 },
        { 1, 1, 0, 1 },
        { 1, 0, 1, 0 },
    };
    int m = 2;

    int color[V];
    for (int i = 0; i<V; i++){
        color[i] = 0;
    }

    if (!colorGraph(graph, m, color, 0)){
        printf("No Solution exists!!");
        return 1;
    }
    printf("Solution is: ");
    printSol(color);

    return 0;
}