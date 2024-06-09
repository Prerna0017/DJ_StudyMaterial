#include <stdio.h>
#include <stdbool.h>

int N;

void printSolution(int board[N][N])
{
    for (int i = 0; i < N; i++)
     {
        for (int j = 0; j < N; j++)
            printf(" %d ", board[i][j]);
        printf("\n");
    }
}

bool isSafe(int board[N][N], int row, int col){
    //vertically
    for (int i = 0; i<col; i++ ){
        if ((board[row][i]) == 1){
            return false;
        }
    }
    for (int i=row, j = col; i>=0 && j>=0; i--,j--){
        if (board[i][j] == 1){
            return false;
        }
    }

    for (int i = row,j = col; i<N && j>=0; i++,j--){
        if (board[i][j] == 1){
            return false;
        }
    }
    return true;
}

bool solveNQueen(int board[N][N], int col){
    if (col>=N){
        return true;
    }
    for (int row = 0; row < N; row++){
        if (isSafe(board, row, col)){
            board[row][col] = 1;
            if (solveNQueen(board, col+1)){
                return true;
            }
            board[row][col] = 0;
        }
    }
    return false;
}
int main()
{
    printf("Enter the no. of queens to be placed: ");
    scanf("%d", &N);
    int board[N][N];
    for (int i = 0; i<N; i++){
        for (int j = 0; j<N; j++){
            board[i][j] = 0;
        }
    }

    if (solveNQueen(board,0) == false){
        printf("No solution exists");
        return 1;
    }

    printf("Solution Board is --->\n");
    printSolution(board);

    return 0;
}