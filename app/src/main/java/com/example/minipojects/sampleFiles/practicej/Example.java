package com.example.minipojects.sampleFiles.practicej;

import java.util.Arrays;
import java.util.Comparator;

//Swapping
public class Example {
    public static void main(String[] args) {

        Example example = new Example();

        int[] arr = {1,0,0,1,1,0,0,1,1,1,0,1};
        example.swapping0And1toTheEnds(arr);
    }

    //Sorting 0's & 1's in an array to theire respective ends
    public void swapping0And1toTheEnds(int[] a) {
        //array positions for 0's and 1's
        int left = 0;
        int right = a.length - 1;
        //loops runs until both left and right are swapped
        while (left < right) {
            //runs loop till it satisfies the given condition
            while (a[left] == 0 && left < right) { //left side with 0's
                left++;
            }
            while (a[right] == 1 && left < right) { //right side with 1's
                right++;
            }
            //swap the elements
            int temp = a[left];
            a[left] = a[right];
            a[right] = a[left];
        }
        System.out.println(Arrays.toString(a));////[0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1]
    }


    //sorting different data types by using Comparator
    public void sortingOnDifferentDataTypes() {
        Object[] obj = {"apple", 2.5, "custardapple", 10, 8.3, "guava", 5};
        
        Arrays.sort(obj, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                //compare data types of 2 objects
                int typeCompare = o1.getClass().getName().compareTo(o2.getClass().getName());
                //if both data types are same then compare
                if (typeCompare == 0) {
                    //compare based on their types using instanceof()
                    if (o1 instanceof String) {
                        return ((String) o1).compareTo((String) o2);
                    } else if (o1 instanceof Integer) {
                        return ((Integer) o1).compareTo((Integer) o2);
                    } else if (o1 instanceof Double) {
                        return ((Double) o1).compareTo((Double) o2);
                    } else {
                        return 0;//for unsupported data types
                    }
                }
                else {
                    return typeCompare;
                }
            }
        });
        System.out.println("Sorted : "+Arrays.toString(obj));//Sorted : [2.5, 8.3, 5, 10, apple, custardapple, guava]
        //still has to be modified with double and int comparision
    }
}
