import java.util.Random;

/**
 * Created by Mikhail on 4/19/2015.
 */
public class SumOfDiagonal {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int min = 4;
        int max = 13;
        int sumOfDiagonal = 0;
        int lineValue = 0;
        double average = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                Random random = new Random();
                arr[i][j] = random.nextInt(max - min + 1) + min;
                //arr[i][j] = 4 + (int) (Math.random() * ((13 - 4)) + 1); did not work?
            }
        }
        // calculate sum of all values and print out matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                lineValue = lineValue + arr[i][j];
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");

        }
        System.out.println(lineValue);

        // calculate main diagonal
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j)
                sumOfDiagonal = sumOfDiagonal + arr[i][j];
            }
        }
        System.out.println(sumOfDiagonal);
        average = (double)lineValue / (arr.length * arr.length);
        System.out.println(average);

    }
}


