import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] a = inputData();
        // mergeSort(a, 0, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
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
    // QuickSort
    public static int partition(int[] a, int i , int j) {
        int pivot = a[j];
        int low = i;
        int high = j -1;
        while(true) {
            while(low <= high && a[low] < pivot) low++;
            while (high >= low && a[high] > pivot) high--;
            if(low >= high) break;
            swap(a, low, high);
            low++;
            high--;
        }
        swap(a, low, j); 
        return low;
    }
    public static void quickSort(int[] a, int i, int j) {
        if (i < j) {
           int pi = partition(a, i, j);
           quickSort(a, i, pi -1);
           quickSort(a, pi + 1, j);
        }
    }

    public static void swap(int a[], int i, int k) {
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    // //Merge sort
    // public static void mergeSort(int[] a, int l, int r) {
    //     if(l >= r) return;
    //     int mid = (l + r) / 2;
    //     mergeSort(a,l,mid);
    //     mergeSort(a,mid+1,r);
    //     merge(a,l,mid,r);
    // }
    // public static void merge(int[] a, int l, int m, int r) {
    //     int[] x = Arrays.copyOfRange(a,l, m);
    //     int[] y = Arrays.copyOfRange(a,m,r);
    //     System.out.println(Arrays.toString(x)+":"+Arrays.toString(y));
    //     int i = 0, j = 0;
    //     while (i < x.length && j <y.length) {
    //         if(a[i] <= y[j]) {
    //             a[l] = x[i];
    //             l++;
    //             i++;
    //         }else {
    //             a[l] = y[j];
    //             l++;
    //             j++;
    //         }
    //     }
    //     while(i < x.length) {
    //         a[l] = x[i];
    //         l++;
    //         i++;
    //     }
    //     while(j < y.length) {
    //         a[l] = y[j];
    //         l++;
    //         j++;
    //     }
        

        
    // }

    public static int[] inputData() {
        String myfile = "F:/HocTap/UDThuatToan/ontap/myArray.txt";
        int[] array = new int[1];
        try (BufferedReader reader = new BufferedReader(new FileReader(myfile))) {
            String line;
            int rows = 0;
            int j = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                if (rows == 0) {
                    array = new int[Integer.parseInt(values[0])];
                    rows = 1;
                } else {
                    for (int i = 0; i < values.length; i++) {
                        array[j] = Integer.parseInt(values[i]);
                        j++;
                    }
                }
            }
            return array;
        } catch (Exception e) {
            return array;
        }
    }
}
