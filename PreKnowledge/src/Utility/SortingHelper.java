package Utility;

import java.lang.reflect.Method;

public class SortingHelper {

    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){

        for(int i = 1; i < arr.length; i ++)
            if(arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String className, E[] arr) throws Exception {

        Class<?> cls = Class.forName(className);
        Object newInstance = cls.newInstance();
        Method method = cls.getMethod("sort", Comparable[].class);

        long startTime = System.nanoTime();
        method.invoke(newInstance, (Object) arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException(className + " failed");
        System.out.printf("%s , n = %d : %f s%n", className, arr.length, time);
    }
}
