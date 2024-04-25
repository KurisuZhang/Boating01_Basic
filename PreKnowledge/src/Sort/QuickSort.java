package Sort;

import Utility.ArrayGenerator;
import Utility.SortingHelper;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static <E extends Comparable<E>> void sort(E[] arr){

        Random rnd = new Random();
        sort(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd){

        if(l >= r) return;

        int p = partition(arr, l, r, rnd);
        sort(arr, l, p - 1, rnd);
        sort(arr, p + 1, r, rnd);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random rnd){

        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while(true){
            // 左边小于pivot直接i++
            while(i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            // 右边大于pivot直接j--
            // 等于时候交换可以必变成O(n^2)
            while(j >= i && arr[j].compareTo(arr[l]) > 0){
                j --;
            }

            // 等于j代表,此元素与pivot相等
            if(i >= j) {
                break;
            }
            // 对于不小于左边的和不大于右边的元素, 进行交换
            swap(arr, i, j);

            i ++;
            j --;
        }

        swap(arr, l, j);
        return j;

    }

    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) throws Exception {

        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        arr = ArrayGenerator.generateOrderedArray(n);
        arr = ArrayGenerator.generateRandomArray(n, 1);

        SortingHelper.sortTest("Sort.QuickSort", arr);
    }

}
