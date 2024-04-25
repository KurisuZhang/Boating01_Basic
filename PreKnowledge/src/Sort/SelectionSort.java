package Sort;

import Utility.SortingHelper;
import Utility.Student;
import Utility.ArrayGenerator;

public class SelectionSort {

    public static <E extends Comparable<E>> void sort(E[] arr){

        for(int i = 0; i < arr.length; i ++){

            // 选择 arr[i...n) 中的最小值
            int minIndex = i;
            for(int j = i; j < arr.length; j ++){
                if(arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }

            // swap
            E tem = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tem;
        }
    }


    public static void main(String[] args) throws Exception {
        int[] dataSize = {10000, 100000};
        for(int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("Sort.SelectionSort", arr);
        }

        Student[] students = {new Student("Alice", 98),
                new Student("Bobo", 100),
                new Student("Charles", 66)};
        SortingHelper.sortTest("Sort.SelectionSort", students);
    }
}
