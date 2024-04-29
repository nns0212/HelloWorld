import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn.metrics import accuracy_score
# Load the dataset from the CSV file
def load_dataset(file_path):
df = pd.read_csv(file_path)
X = df.drop('label', axis=1) # Features
y = df['label'] # Target variable
return X, y
def split_dataset(X, y, test_size=0.2):
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=test_size, random_state=42)
return X_train, X_test, y_train, y_test
# Train the SVM classifier
def train_SVM(X_train, y_train, kernel='linear'):
svm_classifier = SVC(kernel=kernel)
svm_classifier.fit(X_train, y_train)
return svm_classifier
# Evaluate the trained classifier
def evaluate_classifier(classifier, X_test, y_test):
y_pred = classifier.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)
# Main function
def main():
# File path to the CSV dataset
file_path = "dataset.csv"
# Load dataset
X, y = load_dataset(file_path)
# Split dataset into training and testing sets
X_train, X_test, y_train, y_test = split_dataset(X, y)
# Train SVM classifier
svm_classifier = train_SVM(X_train, y_train)
# Evaluate the classifier
evaluate_classifier(svm_classifier, X_test, y_test)
if __name__ == "__main__":
main()
