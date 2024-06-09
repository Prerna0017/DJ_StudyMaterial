#include <stdio.h>
#include <stdbool.h>
#define N 3

int main(){
    float weight[] = {10, 20, 30};
    float profit[] = {60, 100, 120};
    // int profit[N] = {10, 20, 30, 50, 10, 100, 40, 80, 70, 70};
    // int weight[N] = {20, 10, 20, 80, 50, 30, 10, 80, 90, 20};
    // bool used[N] = {false, false, false, false, false, false, false, false, false, false};
    bool used[] = {false, false, false};
    int Capacity = 50;
    int Current_Capacity = Capacity;
    float TotalProfit = 0.0;
    float ratio[N];

    for (int i = 0; i<N; i++){
        ratio[i] = profit[i]/weight[i];
    }

    printf("Profit:\n");
    for (int i = 0; i<N; i++){
        printf("%f\t",profit[i]);
    }

    printf("\nWeight:\n");
    for (int i = 0; i<N; i++){
        printf("%f\t",weight[i]);
    }

    printf("\nRatio:\n");
    for (int i = 0; i<N; i++){
        printf("%f\t",ratio[i]);
    }
    printf("\n");

    while (Current_Capacity > 0){
        //search for the highest ratio
        int maxRatio = -1, maxRatioIndex = -1;
        for (int i = 0; i<N; ++i){
            if (used[i] != true && ((maxRatioIndex == -1) || ratio[i] > ratio[maxRatioIndex])){
                // maxRatio = ratio[i];
                maxRatioIndex = i;
            }
        }

        used[maxRatioIndex] = true;
        Current_Capacity -= weight[maxRatioIndex];
        TotalProfit += profit[maxRatioIndex];

        if (Current_Capacity >= 0)
            printf("Added object %d (%f Rs., %fKg) completely in the bag. Space left: %d.\n", maxRatioIndex + 1, profit[maxRatioIndex], weight[maxRatioIndex], Current_Capacity);
        else
        {
            int item_percent = (int) ((1 + (float) Current_Capacity / weight[maxRatioIndex]) * 100);
            printf("Added %d%% (%d Rs., %dKg) of object %d in the bag.\n", item_percent, profit[maxRatioIndex], weight[maxRatioIndex], maxRatioIndex + 1);
            TotalProfit -= profit[maxRatioIndex];
            TotalProfit += (1 + (float)Current_Capacity / weight[maxRatioIndex]) * profit[maxRatioIndex];
        }

    }

    printf("Filled the bag with objects worth %.2f Rs.\n", TotalProfit);
}