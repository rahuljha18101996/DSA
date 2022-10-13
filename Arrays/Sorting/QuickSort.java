/*
Stats for Quick Sort

    Input Size       Time(ms)
    10                  0
    100                 0
    1,000               0
    10,000              2
    100,000             15
    1,000,000           75
    10,000,000          775
PC Specification: i9 12th Gen
*/

public class QuickSort {
    private static void divide(int[] a, int low,int high) {
        if (low >= high) return;
        int pivot = pivot(a,low,high);
        divide(a,low,pivot - 1);
        divide(a,pivot + 1,high);
    }
    private static int pivot(int[] a,int low,int high) {
        int i = low - 1;
        int pivotPoint = a[high];
        for (int j = low; j < high; j++) {
            if (i < high && pivotPoint >= a[j]) {
                i++;
                swap(a,i,j);
            }
        }
        swap(a,i + 1,high);
        return i + 1;
    }
    private static void swap(int[] a,int i,int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void printArray(int[] a,char variableName) {
        if (a.length == 0) {
            System.out.printf("%c = []",variableName);
            return;
        }
        System.out.printf("%c = [%d",variableName,a[0]);
        for (int i = 1; i < a.length; i++) System.out.printf(",%d",a[i]);
        System.out.printf("]%n");
    }

    public static void main(String[] args) {
        int n = 10000000;
        int[] array = new int[n];
        /*
            Note that: when sorted randomly gives better performance
        */
        for (int i = 0; i < array.length; i++) array[i] = (int)(Math.random() * n);
        //printArray(array,'f');
        long t1 = System.currentTimeMillis();
        divide(array,0,array.length - 1);
        t1 = System.currentTimeMillis() - t1;
        //printArray(array,'f');
        System.out.printf("Time taken to sort array is %d ms%n",t1);
    }
}
