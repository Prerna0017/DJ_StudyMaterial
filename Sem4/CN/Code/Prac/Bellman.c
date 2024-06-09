#include <stdio.h>
#include <stdlib.h>
#define INF 99999

struct Edge{
    int u,v,w;
};

struct Graph{
    int V, E;
    struct Edge * edge;
};

void display(int arr[], int size){
	for (int i = 0; i<size; i++){
		printf("%d\t",arr[i]);
	}
	printf("\n");
}

void bellman(struct Graph *g, int source){
    int i,j,u,v,w;
    int tV = g->V;
    int tE = g->E;
    int d[tV];
    int p[tV];
    
    for (int i = 0; i<tV; i++){
        d[i] = INF;
        p[i] = 0;
    }

    d[source] = 0;

    for (int i = 1; i<=tV-1; i++){
        for (int j = 0; j<tE; j++){
            u = g->edge[j].u;
            v = g->edge[j].v;
            w = g->edge[j].w;

            if (d[u]!=INF && d[v]>d[u]+w){
                d[v] = d[u]+w;
                p[v] = u;
            }
        }
    }

    for (int j = 0; j<tE; j++){
        u = g->edge[j].u;
        v = g->edge[j].v;
        w = g->edge[j].w;

        if (d[u]!=INF && d[v]>d[u]+w){
            printf("Negetive weight detected");
            return;
        }
    }

    printf("Distance array:  \t");
    display(d, tV);
    printf("Predecessor array:\t ");
    display(p, tV);
}

int main(){
    struct Graph *g = (struct Graph*) malloc (sizeof(struct Graph));
    g->V = 4;
    g->E = 5;
    g->edge = (struct Edge*) malloc (g->E*sizeof(struct Edge));

    //edge 0 --> 1
  g->edge[0].u = 0;
  g->edge[0].v = 1;
  g->edge[0].w = 5;

  //edge 0 --> 2
  g->edge[1].u = 0;
  g->edge[1].v = 2;
  g->edge[1].w = 4;

  //edge 1 --> 3
  g->edge[2].u = 1;
  g->edge[2].v = 3;
  g->edge[2].w = 3;

  //edge 2 --> 1
  g->edge[3].u = 2;
  g->edge[3].v = 1;
  g->edge[3].w = 6;

  //edge 3 --> 2
  g->edge[4].u = 3;
  g->edge[4].v = 2;
  g->edge[4].w = 2;

  bellman(g, 0);  //0 is the source vertex

  return 0;
}