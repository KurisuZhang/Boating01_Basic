package Sort;
import Utility.ArrayGenerator;
import Utility.SortingHelper;

import java.util.Arrays;

public class InsertionSort {

    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = 1; i < arr.length; i++) {
            E element = arr[i];
            int minIndex = i;
            for (int j = i-1; j >= 0; j--) {
                if (element.compareTo(arr[j]) < 0){
                    // 元素前移一个位置
                    arr[j+1] = arr[j];
                    minIndex = j;
                }else {
                    break;
                }
            }
            arr[minIndex] = element;
        }
    }

    // 优化写法
    public static <E extends Comparable<E>> void sort2(E[] arr){
        for(int i = 0; i < arr.length; i ++){
            // 将 arr[i] 插入到合适的位置
            E t = arr[i];
            int j;
            for(j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j --){
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) throws Exception {

        int[] dataSize = {10000, 100000};
        for(int n: dataSize){

            System.out.println("Random Array : ");
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("Sort.InsertionSort", arr);
            SortingHelper.sortTest("Sort.SelectionSort", arr2);

            System.out.println();

            System.out.println("Ordered Array : ");
            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("Sort.InsertionSort", arr);
            SortingHelper.sortTest("Sort.SelectionSort", arr2);

            System.out.println();
        }
    }
}
