# Import necessary libraries
import numpy as np
import pandas as pd
from sklearn.datasets import load_breast_cancer
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.svm import SVC
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score, classification_report

# Load the Breast Cancer dataset
cancer = load_breast_cancer()
X = cancer.data
y = cancer.target

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Define classifiers
classifiers = {
  'Decision Tree': DecisionTreeClassifier(),
  'SVM': SVC(),
  'KNN': KNeighborsClassifier()
}

# Train and evaluate classifiers
results = {}
for name, clf in classifiers.items():
  clf.fit(X_train, y_train)
  y_pred = clf.predict(X_test)
  accuracy = accuracy_score(y_test, y_pred)
  report = classification_report(y_test, y_pred, target_names=cancer.target_names, 
  output_dict=True)
  results[name] = {'accuracy': accuracy, 'report': report}

# Print results
for name, result in results.items():
  print(f"Classifier: {name}")
  print(f"Accuracy: {result['accuracy']}")
  print("Classification Report:")
  print(pd.DataFrame(result['report']).transpose())
  print()


import matplotlib.pyplot as plt

# Extract accuracies
classifier_names = list(results.keys())
accuracies = [results[name]['accuracy'] for name in classifier_names]

# Plot
plt.figure(figsize=(7, 3))
plt.bar(classifier_names, accuracies, color=['#0077b6', '#009e46', 'red'])
plt.title('Classifier Accuracies')
plt.xlabel('Classifier')
plt.ylabel('Accuracy')
plt.ylim(0.9, 1.0)  # Set y-axis limits
plt.xticks(rotation=45)  # Rotate x-axis labels for better readability
plt.grid(axis='y', linestyle='--', alpha=0.7)
plt.show()