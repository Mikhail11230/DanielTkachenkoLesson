import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Mikhail on 4/18/2015.
 */

public class Application {
    public static void main(String[] args) {
        int timer = 10000;
        long startTime = System.currentTimeMillis();
        while (timer > 0) {

            int[] arr = new int[1000];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 100);
            }
            Arrays.sort(arr);
            timer--;

        }
        System.out.println(System.currentTimeMillis() - startTime + "Milliseconds");
    }
}