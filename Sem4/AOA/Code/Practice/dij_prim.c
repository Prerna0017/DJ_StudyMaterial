#include <stdio.h>
#include <stdbool.h>
#include <limits.h>
#define V 5

void printSolution(int parent[], int graph[V][V]){
    printf("\nEdge\t\t\tWeight\n");
    for (int i = 1; i<V; i++)
        printf("%d-%d\t\t\t%d\n", parent[i], i, graph[i][parent[i]]);
}

int minimum_Distance(int dist[], bool visited[]){
    int min = INT_MAX, min_index;
    for (int v = 0; v<V; v++){
        if (visited[v] == false && dist[v] <= min){
            min = dist[v];
            min_index = v;
        }
    }
    return min_index;
}

void greedy (int graph[V][V]){
    int parent[V];
    int dist[V];
    bool visited[V];

    for (int i = 0; i<V; i++){
        dist[i] = INT_MAX;
        visited[i] = false;
    }

    dist[0] = 0;
    parent[0] = -1;

    for (int i = 0; i<V-1; i++){
        int u = minimum_Distance(dist, visited);
        visited[u] = true;

        for (int v = 0; v<V; v++){
            if (visited[v] == false && 
                graph[u][v] && 
                graph[u][v] < dist[v]){
                dist[v] = graph[u][v];
                parent[v] = u;
            }
        }
    }

    printSolution(parent, graph);
}

int main(){
    int graph[V][V] = {
        { 0, 2, 0, 6, 0 },
        { 2, 0, 3, 8, 5 },
        { 0, 3, 0, 0, 7 },
        { 6, 8, 0, 0, 9 },
        { 0, 5, 7, 9, 0 }
    };

    greedy(graph);

    return 0;
}