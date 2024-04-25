package Sort;

import Utility.ArrayGenerator;
import Utility.SortingHelper;

import java.util.Arrays;

public class BubbleSort {


    public static <E extends Comparable<E>> void sort(E[] data){

        for(int i = 0; i + 1 < data.length; i ++){

            // arr[n - i, n) 已排好序
            // 通过冒泡在 arr[n - i - 1] 位置放上合适的元素
            for(int j = 0; j < data.length - i - 1; j ++)
                if(data[j].compareTo(data[j + 1]) > 0)
                    swap(data, j, j + 1);
        }
    }

    //如果遍历没有交换操作, 则已经排好序
    public static <E extends Comparable<E>> void sort2(E[] data){

        for(int i = 0; i + 1 < data.length; i ++){

            // arr[n - i, n) 已排好序
            // 通过冒泡在 arr[n - i - 1] 位置放上合适的元素
            boolean isSwapped = false;
            for(int j = 0; j < data.length - i - 1; j ++)
                if(data[j].compareTo(data[j + 1]) > 0){
                    swap(data, j, j + 1);
                    isSwapped = true;
                }

            if(!isSwapped) break;
        }
    }

    // 最有一次交换的位置后, 已经排好序了
    public static <E extends Comparable<E>> void sort3(E[] data){

        for(int i = 0; i + 1 < data.length; ){

            // arr[n - i, n) 已排好序
            // 通过冒泡在 arr[n - i - 1] 位置放上合适的元素
            int lastSwappedIndex = 0;
            for(int j = 0; j < data.length - i - 1; j ++)
                if(data[j].compareTo(data[j + 1]) > 0){
                    swap(data, j, j + 1);
                    lastSwappedIndex = j + 1;
                }

            i = data.length - lastSwappedIndex;
        }
    }

    private static <E> void swap(E[] arr, int i, int j){

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) throws Exception {

        int n = 10000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array");
        SortingHelper.sortTest("Sort.BubbleSort", arr);
        System.out.println();


    }
}
