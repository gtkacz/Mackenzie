import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] vector = new int[N];

        for (int i = 0; i < N; i++) {
            vector[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();

        int index = 0;
        for (int i = 0; i < N; i++) {
            if (vector[i] != 0) {
                int temp = vector[i];
                vector[i] = vector[index];
                vector[index] = temp;
                index++;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
}
