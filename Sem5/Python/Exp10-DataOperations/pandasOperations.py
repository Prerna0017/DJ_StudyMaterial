import pandas as pd
import numpy as np

a = [9,1,4]
print(pd.Series(a))

a = [9,1,4]
print(pd.Series(a, index=["a","b","c"]))

a = {"day1":900, "day2":321, "day3":908, "day4":667}
print(pd.Series(a))

a = {
    "calories": [34,67,53,21],
    "food":["tea","coffee","chocolate","coke"]
}
print(pd.DataFrame(a))

a = {
    "calories": [34,67,53,21],
    "food":["tea","coffee","chocolate","coke"]
}
print(pd.DataFrame(a, index=["day1","day2","day3","day4"]))

df = pd.read_csv("C:/Users/Jadhav/Documents/BTech/Docs/5th Sem/ADBMS/Practicals/registered_companies.csv")
# print(df)

print("Head(): ",df.head())
print("Tail(): ",df.tail())
print("Info(): ",df.info())

# #with randomValue - 130
# df["Calories"].fillna(130, inplace = True)
# #with mean
# x = df["Calories"].mean()
# df["Calories"].fillna(x, inplace = True)
# #with median
# x = df["Calories"].median()
# df["Calories"].fillna(x, inplace = True)

print(df.describe())
print(df.corr())