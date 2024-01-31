package com.example.minipojects.sampleFiles.practicej;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Practicing4 {

    public static void main(String[] args) {
        Test1 obj1 = new Test1();
        Test2 obj2 = new Test2();
        System.out.println("The class of obj1 is : " + obj1.getClass());//The class of obj1 is : class Test1
        System.out.println("The class of obj2 is : " + obj2.getClass());//The class of obj2 is : class Test2
        if (obj1 instanceof Test1)
            System.out.println("obj1 is an object of Test1");//obj1 is an object of Test1
        else
            System.out.println("obj1 is not instance of Test1");
        if (Test2.class.isInstance(obj2))
            System.out.println("obj2 is an object of Test2");//obj2 is an object of Test2
        else
            System.out.println("obj2 is not an instance of Test2");




        System.out.println("The size of the pizza I get is "+Size.SMALL.getSize());//The size of the pizza I get is small
        System.out.println("The size of the pizza I want is "+Size.LARGE.getSize());//The size of the pizza I want is large



        /*Java Program to Print object of a class*/
        System.out.println(obj1);//Test1@2c7b84de
        Test3 obj3 = new Test3();
        System.out.println(obj3);//Test3-object


        Practicing4 practicing4 = new Practicing4();
        try {
            practicing4.checkLanguage("Swift");
            practicing4.checkLanguage("Java");
        } catch (CustomException e) {
            System.out.println("["+e+"] Exception occurred");//[CustomException: Java already exists] Exception occurred
        }

        practicing4.languageAvailability("Ruby");
        practicing4.languageAvailability("Python");



        Immutable immutable = new Immutable("practicing4", 27032023);
        System.out.println("Name : "+immutable.getName()+", Date: "+immutable.getDate());//Name : practicing4, Date: 27032023
    }

    ArrayList<String> languages = new ArrayList<>(Arrays.asList("Java","Python", "JavaScript"));
    public void checkLanguage(String language) throws CustomException {
        if (languages.contains(language))
            throw new CustomException(language + " already exists");
        else {
            languages.add(language);
            System.out.println(language+" is added to the arraylist");//Swift is added to the arraylist
        }
    }

    public void languageAvailability(String language) {
        if (languages.contains(language)) {
            try {
                throw new CustomException(language + " is already available");
                //CustomException: Python is already available
                // at Practicing4.languageAvailability(Practicing4.java:21)
                // at Practicing4.main(Practicing4.java:35)
            } catch (CustomException e) {
                e.printStackTrace();
            }
        } else {
            languages.add(language);
            System.out.println(language + " is added to available arraylist");//Ruby is added to available arraylist
        }
    }

    public void averageUsingArrays() {
        double[] arr = {12.3, 45.6, -78.9, 34.0, 23.5, 45.6};
        double sum = 0.0;
        for (double a : arr) {
            sum += a;
        }
        double average = sum / arr.length;
        System.out.format("Average is %.2f", average);//Average is 13.68
    }

    public void largestElementInAnArray() {
        double[] arr = {98.0, 87.3, 63.4, 13.3, 123.4, -76.9, 54.2};
        double largest = arr[0];
        for (double a : arr) {
            if (largest < a)
                largest = a;
        }
        System.out.format("Largest element is %.2f", largest);//Largest element is 123.40
    }

    public void calculateStandardDeviation() {
        double[] arr = {10,9,8,7,6,5,4,3,2,1};
        double sum = 0.0, standardDeviation = 0.0;
        int length = arr.length;

        for (double a : arr)
            sum += a;

        double mean = sum / length;
        for (double a: arr) {
            standardDeviation += Math.pow(a - mean, 2);
        }
        double sd = Math.sqrt(standardDeviation / length);
        System.out.format("Standard deviation is %.6f", sd);//Standard deviation is 2.872281
    }

    public void addMatrices() {
        int rows = 2, columns = 3;
        int[][] matrix1 = {{2,3,4}, {5,4,3}};
        int[][] matrix2 = {{-4,5,6}, {9,6,8}};
        int[][] sum = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("Sum of the two matrices are : ");
        for (int[] row : sum) {
            for (int column : row) {
                System.out.print(column +" ");
                //-2 8 10
                //14 10 11
            }
            System.out.println();
        }
    }

    public void multiply2MatricesUsingMultiDimensionalArrays() {
        int r1 = 2, c1 = 3;
        int r2 = 3, c2 = 2;
        int[][] matrix1 = {{1,4,5}, {-6, 4, 6}};
        int[][] matrix2 = {{3,5},{7,1}, {-2, 8}};

        int[][] product = multiplyMatrices(matrix1, matrix2, r1, c1, c2);

        displayProduct(product);

    }
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2, int r1, int c1, int c2) {
        int[][] product = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return product;
    }
    public static void displayProduct(int[][] product) {
        System.out.println("Multiplication of 2 matrices is : ");
        for (int[] row : product) {
            for (int column : row) {
                System.out.print(column+" ");
                //21 49
                //-2 22
                //|-    (1 x 3) + (4 x 7) + (5 x -2)    (1 x 5) + (4 x 1) + (5 x 8)    -|3+28-10    5+4+40
                //|_    (-6 x 3) + (4 x 7) + (6 x -2)   (-6 x 5) + (4 x 1) + (6 x 8)   _|-18+28-12  -30+4+48
            }
            System.out.println();
        }
    }

    public void transposeOfAMatrix() {
        int rows = 2, columns = 3;
        int[][] matrix = {{3,5,6}, {6,2,1}};
        displayProduct(matrix);

        int[][] transpose = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0 ; j < columns; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        displayProduct(transpose);
        //3 6
        //5 2
        //6 1
    }

    public void printAnArray() {
        int[] a = {2,5,7,9,0};
        for (int i : a)
            System.out.println(i);
        //2
        //5
        //7
        //9
        //0
        //method-2
        System.out.println(Arrays.toString(a));//[2, 5, 7, 9, 0]
        int[][] arr = {{1,2},{3,4},{5,6, 7}};
        System.out.println(Arrays.deepToString(arr));//[[1, 2], [3, 4], [5, 6, 7]]
    }

    public void concatenate2Arrays() {
        int[] a1 = {1,3, 5};
        int[] a2 = {9,6,3};
        int lenA1 = a1.length;
        int lenA2 = a2.length;
        int[] res = new int[lenA1 + lenA2];
        System.arraycopy(a1, 0, res, 0, lenA1);
        System.arraycopy(a2, 0, res, lenA1, lenA2);
        System.out.println(Arrays.toString(res));//[1, 3, 5, 9, 6, 3]

        //method-2
        int len = a1.length + a2.length;
        int[] result = new int[len];
        int pos = 0;
        for (int i : a1) {
            result[pos] = i;
            pos++;
        }
        for (int i : a2) {
            result[pos] = i;
            pos++;
        }
        System.out.println(Arrays.toString(result));//[1, 3, 5, 9, 6, 3]
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void containsValueInAnArray() {
        int[] a = {9, 8, 7, 6, 5};
        int toFind = 7;
        boolean found = false;
        for (int n : a) {
            if (n == toFind) {
                found = true;
                break;
            }
        }
        if (found)
            System.out.println(toFind+" is found");//7 is found
        else
            System.out.println(toFind+" is not found");

        //method-2
        boolean isExists = IntStream.of(a).anyMatch(i -> i == toFind);
        if (isExists)
            System.out.println(toFind+" is exists");//7 is exists
        else
            System.out.println(toFind+" is doesn't exists");

        //method-3
        String[] arr = {"qw", "er", "yu", "io","pl"};
        String s = "yu";
        boolean contains = Arrays.stream(arr).anyMatch(i -> i.equals(s));
        if (contains)
            System.out.println(s+" contains in arr");//yu contains in arr
        else
            System.out.println(s+" doesn't contains in arr");
    }
}

/*Java Program to Add Two Complex Numbers by Passing Class to a Function*/
class Complex {
    double real, imag;
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public static void main(String[] args) {
        Complex n1 = new Complex(2.3, 4.5),
                n2 = new Complex(3.4, 5.6),
                temp;
        temp = add(n1, n2);
        System.out.printf("Sum = %.1f + %.1fi", temp.real, temp.imag);//Sum = 5.7 + 10.1i
    }
    public static Complex add(Complex n1, Complex n2) {
        Complex temp = new Complex(0.0, 0.0);
        temp.real = n1.real + n2.real;
        temp.imag = n1.imag + n2.imag;
        return temp;
    }
}

/*Java Program to Calculate Difference Between Two Time Periods*/
class Time {
    int seconds, minutes, hours;
    public Time(int seconds, int minutes, int hours) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    public static void main(String[] args) {
        Time start = new Time(8, 12, 15);
        Time stop = new Time(12,34, 55);
        Time diff;
        diff = difference(start, stop);
        System.out.printf("Time difference : %d:%d:%d - ", start.hours, start.minutes, start.seconds);//Time difference : 15:12:8 -
        System.out.printf("%d:%d:%d ", stop.hours, stop.minutes, stop.seconds);// 55:34:12
        System.out.printf("= %d:%d:%d\n", diff.hours, diff.minutes, diff.seconds);//= 40:22:4
    }
    private static Time difference(Time start, Time stop) {
        Time diff = new Time(0,0,0);
        if (start.seconds > stop.seconds) {
            --stop.minutes;
            stop.seconds += 60;
        }
        diff.seconds = stop.seconds - start.seconds;
        if (start.minutes > stop.minutes) {
            --stop.hours;
            stop.minutes += 60;
        }
        diff.minutes = stop.minutes - start.minutes;
        diff.hours = stop.hours - start.hours;
        return diff;
    }
}

/*Java Program to Determine the class of an object*/
class Test1 { }
class Test2 { }
class Test3 {
    @NonNull
    @Override
    public String toString() {
        return "Test3-object";
    }
}

/*Java program to create an enum class*/
enum Size {
    SMALL, MEDIUM, LARGE, EXTRALARGE;
    public String getSize() {
        switch (this) {
            case SMALL: return "small";
            case MEDIUM: return "medium";
            case LARGE: return "large";
            case EXTRALARGE: return "extra large";
            default: return null;
        }
    }
}

/*Java Program to Create custom exception*/
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

/*Java Program to Create an Immutable Class*/
final class Immutable {
    private String name;
    private int date;
    public Immutable(String name, int date) {
        this.name = name;
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public int getDate() {
        return date;
    }
}