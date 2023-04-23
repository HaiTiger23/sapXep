import java.io.FileReader;
import java.io.BufferedReader;

public class App {
    public static void main(String[] args) throws Exception {
        int[] a = inputData();
        sapXepChen(a);
    }

    // SapXepChon
    public static void sapXepChon(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int min_location = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    min_location = j;
                }
            }
            int temp = a[i];
            a[i] = a[min_location];
            a[min_location] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sapXepChen(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int key = a[i];
           
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
           
            a[j + 1] = key;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sapXepNoiBot(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);

                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void swap(int a[], int i, int k) {
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static int[] inputData() {
        String myfile = "F:/HocTap/UDThuatToan/ontap/myArray.txt";
        int[] array = new int[1];
        try (BufferedReader reader = new BufferedReader(new FileReader(myfile))) {
            String line;
            int rows = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                if (rows == 0) {
                    array = new int[Integer.parseInt(values[0])];
                    rows = 1;
                } else {
                    for (int i = 0; i < values.length; i++) {
                        array[i] = Integer.parseInt(values[i]);
                    }
                }
            }
            return array;
        } catch (Exception e) {
            return array;
        }
    }
}
