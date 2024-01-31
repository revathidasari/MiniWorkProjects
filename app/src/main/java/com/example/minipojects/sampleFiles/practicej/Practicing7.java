package com.example.minipojects.sampleFiles.practicej;

import java.util.Arrays;
import java.util.Scanner;

//Algorithms
public class Practicing7 {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //bubble sort
        int[] data = {-2, 45, 0, 11, -9};
        Practicing7 practicing7 = new Practicing7();
        practicing7.bubbleSort(data);
        System.out.println("Sorted array in Ascending order");//Sorted array in Ascending order
        System.out.println(Arrays.toString(data));//[-9, -2, 0, 11, 45]

        //quick sort
        int[] quick = {8,7,2,1,0,9,6};
        System.out.println("Unsorted array:");//Unsorted array:
        System.out.println(Arrays.toString(quick));//[8, 7, 2, 1, 0, 9, 6]
        int size = quick.length;
        QuickSort.quickSort(quick, 0, size -1);
        System.out.println("Sorted array in Ascending order");//Sorted array in Ascending order
        System.out.println(Arrays.toString(quick));//[0, 1, 2, 6, 7, 8, 9]

        //merge sort
        int[] merge = {6, 5, 12, 10, 9, 1};
        practicing7.mergeSort(merge, 0, merge.length -1);
        System.out.println("Sorted array:");//Sorted array:
        System.out.println(Arrays.toString(merge));//[1, 5, 6, 9, 10, 12]

        //binary search
        int[] search = {3, 4, 5, 6,7,8,9};
        int n = search.length;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter element to be searched");//Enter element to be searched
        int element = scanner.nextInt();//7
        scanner.close();
        int result = practicing7.binarySearch(search, element, 0, n - 1);
        if (result == -1)
            System.out.println("not found");
        else
            System.out.println("Element found at index "+ result);// Element found at index 4
    }

    //Bubble sort
    void bubbleSort(int array[]) {
        int size = array.length;
        System.out.println("Choose sorting order");//Choose Sorting Order:
        System.out.println("1 is Ascending \n2 for Descending");//1 for Ascending 2 for Descending
        int sortOrder = input.nextInt();//1 //2
        for (int i = 0 ; i < size - 1; i++) {
            for (int j = 0 ; j < size -i -1; j++) {
                if (sortOrder == 1) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                } else {
                    if (array[j] < array[j+1]) {
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
        }
    }

    //merge sort
    void merge(int array[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int L[] = new int[n1];
        int M[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = array[p + i];
        }
        for (int j = 0; j < n2; j++) {
            M[j] = array[q + 1 + j];
        }
        int i, j, k;
        i = 0;
        j = 0;
        k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = M[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
    }
    void mergeSort(int array[], int left, int right) {
        if (left < right) {
            int mid = (left + right)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    //binary search
    int binarySearch(int array[], int element, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == element)
                return mid;
            if (array[mid] < element)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}

//Quick sort
class QuickSort {
    static int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);
    }
    static void quickSort(int array[], int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi -1);
            quickSort(array, pi +1, high);
        }
    }
}
