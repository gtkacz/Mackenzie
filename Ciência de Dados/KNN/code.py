from sklearn.datasets import load_iris
from sklearn.metrics import classification_report, confusion_matrix
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.preprocessing import StandardScaler


def main():
    iris = load_iris()
    X = iris.data
    y = iris.target

    X_train, X_test, y_train, y_test = train_test_split(
        X, y, test_size=0.2, random_state=42)

    scaler = StandardScaler()
    scaler.fit(X_train)

    X_train = scaler.transform(X_train)
    X_test = scaler.transform(X_test)

    k = 5
    classifier = KNeighborsClassifier(n_neighbors=k)
    classifier.fit(X_train, y_train)

    y_pred = classifier.predict(X_test)

    print('Matriz de Confusão:')
    print(confusion_matrix(y_test, y_pred))
    print('\nRelatório de Classificação:')
    print(classification_report(y_test, y_pred))

    with open('resultados_knn.txt', 'w') as f:
        f.write('Matriz de Confusão:\n')
        f.write(str(confusion_matrix(y_test, y_pred)) + '\n')
        f.write('\nRelatório de Classificação:\n')
        f.write(str(classification_report(y_test, y_pred)))


if __name__ == '__main__':
    main()
