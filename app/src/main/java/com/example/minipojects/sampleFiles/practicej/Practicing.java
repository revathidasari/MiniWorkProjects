package com.example.minipojects.sampleFiles.practicej;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

//FCA
public class Practicing {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String []args){
        System.out.println("Hello, World!");

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the 2 numbers");
        int a = scn.nextInt();
        int b = scn.nextInt();
        squareOfNumbers(a, b);// by making method as static we can call it directly

        Practicing practicing = new Practicing();
        practicing.sumOfSquaresTillA(a);

        practicing.duplicateElements();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(5);
        list.forEach((integer) ->{
            System.out.println(integer+" , ");
        });
        practicing.findDuplicates(list); // int[] arr = new int[] {1,2,4,2,21,3,4,5,6,7,8,6,6,7};

        System.out.println("unique years called "+practicing.uniqueYears());
    }

    public int uniqueYears() {
        Map<String, Integer> map = new HashMap();
        String s = "hello todays date was 13-03-2023 and tomorrows date was 14-03-2024";

        String[] splits = s.split(" ");
        for (String split : splits) {
            if (split.contains("-")) {
                String[] underScore = split.split("-");
                map.put(underScore[2], 0);
                System.out.println("  under score " + Arrays.toString(underScore));
            }
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()) {//to iterate map values
            if (entry.getKey() == "2024") {
                System.out.println("year is "+entry.getKey());
            }
            if (entry.getValue() == 0) {
                System.out.println("default value");
            }
        }
        for (String key : map.keySet()) { //to iterate keys in map
            System.out.println("keys : "+key);
        }
        Iterator<Integer> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(" value is "+iterator.next());
        }
        for (Integer value : map.values()) {System.out.println("values : "+value);}  //to iterate values in map
        return map.entrySet().size();
    }

    public void addElementsToIntegerArray(int i) {
        Integer a[] = {1,2,3,4,5,6};
        i = 7;
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(a));
        arrayList.add(i);
        a = arrayList.toArray(a);
        System.out.println(Arrays.toString(a));//[1, 2, 3, 4, 5, 6, 7]
    }

    public static int[] toInt(Set<Integer> set) {
        int[] a = new int[set.size()];
        int i = 0;
        for (Integer val : set) {
            // treat null as 0
            a[i++] = val == null ? 0 : val;
        }
        return a;//[2, 3]
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Integer[] streamToArrayInt(Set<Integer> set) {// call this method in Arrays.toString(...)
        Integer[] array = set.stream().toArray(Integer[]::new);
        return array;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int[] streamAndMapToInt(Set<Integer> set) { // call this method in Arrays.toString(...)
        Integer[] arr = set.toArray(new Integer[0]);
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
    public void findDuplicates(List<Integer> list){ //(int[] arr)
        if(list!=null && !list.isEmpty()){
            Set<Integer> uniques = new HashSet<>();
            Set<Integer> duplicates = new HashSet<>();

            for(int i=0;i<list.size();i++){ //arr.length
                if(!uniques.add(list.get(i))){ //a[i]
                    duplicates.add(list.get(i)); //a[i]
                }
            }
            System.out.println("Uniques: "+uniques); // Uniques: [1, 2, 3, 5] || Uniques: [1, 2, 3, 4, 21, 5, 6, 7, 8]
            System.out.println("Duplicates: "+duplicates); // Duplicates: [2] || Duplicates: [2, 4, 6, 7]
        }else{
            System.out.println("LIST IS INVALID");
        }
    }
    private void duplicateElements() {

        int[] a = new int[] {1,2,4,2,21,3,4,5,6,7,8,6,6,7};
        int[] b = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            for (int j=i+1; j<a.length; j++) {
                if (a[i] == a[j]) {
                    b[i] = a[i];
                    System.out.println("Duplicate element is "+a[i]+"  b[i] is "+b[i]);
                }
            }
        }
        System.out.println("Duplicates elements as array "+Arrays.toString(b));
    }

    private void sumOfSquaresTillA(int a) {
        int sum = 0;
        if (a < 1)
            return;
        for(int i = 1; i <= a; i++) {
            sum += Math.pow(i, 2);
        }
        System.out.println("sum till A is "+sum);// = 1^2 + 2^2 + ... + N^2
    }

    public static void squareOfNumbers(int a, int b) {
        double sum = 0.0; //it should be double else {error: incompatible types: possible lossy conversion from double to int}
        sum = Math.pow(a, 2)+Math.pow(b,2);
        System.out.println("Sum of the squares of the number is "+sum); // = a^2 + b^2
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void duplicatesListToSet() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 3));
        Set<Integer> set = new LinkedHashSet<>();
        set.addAll(numbers);

        // delete al elements of arraylist by using set
        numbers.clear();
        numbers.addAll(set);
        System.out.println("ArrayList without duplicate elements: " + numbers);

        //method-2 // convert the stream to arraylist
        numbers = (ArrayList<Integer>)numbers.stream().distinct().collect(Collectors.toList());//by using stream of distinct

        System.out.println("ArrayList without duplicate elements: " + numbers);
    }
}
