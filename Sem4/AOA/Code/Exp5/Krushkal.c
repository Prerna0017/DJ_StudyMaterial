#include <stdio.h>
#define MAX 10

int parent[MAX];

int find(int i)
{
  while (parent[i] != i)
  {
    i = parent[i];
  }
  return i;
}

//we join a and b and assign b as parent of a 
void union_ij(int i, int j)
{
  int a = find(i);
  int b = find(j);
  parent[a] = b;
}
void kruskal(int cost[][MAX], int n)
{
  int mincost = 0, ne = 1, i, j, a, b, u, v;
  for (i = 1; i <= n; i++)
  {
    parent[i] = i;
  }
  while (ne < n)  //if total_vertices = n, edges = ne bcoz minimumspantree has n-1 edges so loop runs for n-1 times
  {
    //finding the minimum edge cost
    int min = 999;
    for (i = 1; i <= n; i++)
    {
      for (j = 1; j <= n; j++)
      {
        if (find(i) != find(j) && cost[i][j] < min)
        {
          min = cost[i][j];
          a = u = i;
          b = v = j;
        }
      }
    }

    //finding there absolute parent and checking they dont have same parents
    if (find(u) != find(v))
    {
      printf("\nEdge %d: (%d, %d) cost: %d", ne++, a, b, min);
      mincost += min;
      union_ij(u, v);
    }
    cost[a][b] = cost[b][a] = 999;
  }
  printf("\nMinimum cost = %d\n", mincost);
}
int main()
{
  int n=5;

  int cost[MAX][MAX] = {{ -1, -1, -1, -1, -1, -1},
                        { -1, 999, 2, 999, 6, 999},
                        { -1, 2, 999, 3, 8, 5},  
                        { -1, 999, 3, 999, 999, 7},
                        { -1, 6, 8, 999, 999, 9},
                        { -1, 999, 5, 7, 9, 999}};
 
  kruskal(cost, n);
  return 0;
}

//input
// Enter the number of vertices: 5
// Enter the cost matrix:
// 0 2 0 6 0
// 2 0 3 8 5  
// 0 3 0 0 7
// 6 8 0 0 9
// 0 5 7 9 0

// Edge 1: (1, 2) cost: 2
// Edge 2: (2, 3) cost: 3
// Edge 3: (2, 5) cost: 5
// Edge 4: (1, 4) cost: 6
// Minimum cost = 16