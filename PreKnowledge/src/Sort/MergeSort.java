package Sort;

import Utility.ArrayGenerator;
import Utility.SortingHelper;
import java.util.Arrays;


public class MergeSort {

    public static <E extends Comparable> void sort(E[] arr){
        // 每次只开辟一次空间
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable> void sort(E[] arr, int l, int r, E[] temp){

        if (l >= r)
            return;

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        // 判断是否需要merge
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge2(arr, l, mid, r, temp);
    }

    private static <E extends Comparable> void merge2(E[] arr, int l, int mid, int r, E[] temp){

        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;

        for(int k = l; k <= r; k ++){

            if(i > mid){
                arr[k] = temp[j]; j ++;
            }
            else if(j > r){
                arr[k] = temp[i]; i ++;
            }
            else if(temp[i].compareTo(temp[j]) <= 0){
                arr[k] = temp[i]; i ++;
            }
            else{
                arr[k] = temp[j]; j ++;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

        SortingHelper.sortTest("Sort.MergeSort", arr);

    }
}
