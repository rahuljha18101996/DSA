/*
Stats for Merge Sort

    Input Size       Time(ms)
    10                 0
    100                0
    1,000              0
    10,000             2
    100,000            13
    1,000,000          84
    10,000,000         631    :) [WARNING: DO NOT TRY THIS SIZE WITH O(n^2) ALGORITHM]

PC Specification: i9 12th Gen
*/

public class MergeSort {

    public static void main(String[] args) {
        int n = 10000000;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) array[i] = n--;
        //printArray(array,'o');
        long t1 = System.currentTimeMillis();
        divide(array,0,array.length - 1);
        t1 = System.currentTimeMillis() - t1;
        //printArray(array,'f');
        System.out.printf("Time taken to sort array is %d ms%n",t1);
    }
    private static void divide(int[] array,int lower,int upper) {
        if (lower >= upper) return;
        int middle = (lower + upper) / 2;
        divide(array,lower,middle);
        divide(array,middle + 1,upper);
        merge(array,lower,middle,upper);
    }
    private static void merge(int[] array, int lower, int middle, int upper) {
        int m = middle - lower + 1;
        int[] a = new int[upper - lower + 1];
        int n = upper  - middle;
        int[] b = new int[n];

        int index = 0;
        for (int i = lower; i <= middle; i++) a[index++] = array[i];
        index = 0;
        for (int i = middle + 1; i <= upper; i++) b[index++] = array[i];

        mergeTwoSortedArray(a,m,b,b.length);

        index = 0;

        for (int i = lower; i <= upper; i++) {
            array[i] = a[index++];
        }
    }
    private static void mergeTwoSortedArray(int[] a, int m, int[] b, int n) {
//        printArray(a,'a');
//        printArray(b,'b');
        if (n == 0) return;
        int i = m - 1;
        int j = n - 1;
        for (int k = a.length - 1; k >= 0; k--) {
            if (i > -1 && j > -1) {
                //In case of Reverse sort replace greater than with less than
                if (a[i] > b[j]) {
                    a[k] = a[i--];
                }else {
                    a[k] = b[j--];
                }
            }else {
                if (i > -1) a[k] = a[i--];
                if (j > -1) a[k] = b[j--];
            }
        }
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
}
