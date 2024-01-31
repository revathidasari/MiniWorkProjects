package com.example.minipojects.sampleFiles.practicej;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Samples {
    public static void main(String[] args) {

        int q[] = {5, 7, 10, 5, 15};
        int w[] = {1, 2 ,1,5,5};
        minStepsArrayElementsAreEqual(q, w, 5);
    }
    //Minimum steps to make an array elements equal
    public static void minStepsArrayElementsAreEqual(int[] a, int[] b, int n) {
        int steps = 0;
        boolean defaultValue = true;

        //To get minimum value in an array - Arrays.stream(a).min().getAsInt()
        while (Arrays.stream(a).min().getAsInt() > -1) {
            int min = Arrays.stream(a).min().getAsInt();//min of a[] is 5
            for (int i = 0; i < n; i++) {
                if (a[i] != min) {
                    a[i] -= b[i];
                    steps++;
                }
            }
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < n; j++) {//to avoid duplicates make use of set to add elements
                hashSet.add(a[j]);
            }
            if (hashSet.size() == 1) {//when set has only 1 element as same value
                defaultValue = false;
                System.out.println(steps +" number of steps taken to make elements in an array as equal");//8 number of steps taken to make elements in an array as equal
                break;
            }
        }
        if (defaultValue)
            System.out.println("Elements in array are not equal so returning -1 steps");


        /* o/p explanation :::
        * min = 5
        * 5 == 5 - no check
        * 7 != 5 -> 7 - 2 = 5 & steps = 1
        * 10 != 5 -> 10 - 1 = 9 & steps = 2
        * 5 == 5 -> no check
        * 15 != 5 -> 15 - 5 = 10 & steps = 3, hashset = [5, /5\, 9, /5\, 10] = [5, 9, 10]
        * min = 5
        * 5 == 5, 5 == 5 -> no check
        * 9 != 5 -> 9 -1 = 8 & steps = 4
        * 5 == 5 -> no check
        * 10 != 5 -> 10 - 5 = 5 & steps = 5, hashset = [5, /5\, 8, /5\, /5\] = [5, 8]
        * min = 5
        * 5 == 5, 5 == 5 -> no check
        * 8 != 5 -> 8 - 1 = 7 & steps = 6
        * 5 == 5, 5 == 5-> no check, hashset = [5, /5\, 7, /5\, /5\] = [5, 7]
        * min = 5
        * 5 == 5, 5 == 5 -> no check
        * 7 != 5 -> 7 - 1 = 6 & steps = 7
        * 5 == 5, 5 == 5-> no check, hashset = [5, /5\, 6, /5\, /5\] = [5, 6]
        * min = 5
        * 5 == 5, 5 == 5 -> no check
        * 6 != 5 -> 6 - 1 = 5 & steps = 8
        * 5 == 5, 5 == 5-> no check, hashset = [5, /5\, /5\, /5\, /5\] = [5]
        * as steps == 1 ->defaultValue = false -> o/p => steps = 8
        * */
    }



    //input - zozooo if z is 2 then o must be 4(2* no. of z's)
//    Note: The maximum length of this word must be 20

    public static boolean isOAn2MultipleOfZ() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string : ");//Enter the string : zzooooo
        String s = scanner.nextLine();
        System.out.print(s);

        char[] ch = s.toCharArray();
        int nZ = 0, nO = 0;
        if (ch.length >= 20)
            return false;
        for (char c : ch) {
            if (c == 'z' || c == 'Z') {
                nZ++;
            } else if (c == 'o' || c == 'O') {
                nO++;
            }
        }
        if (nZ != 0 && nO != 0 && nO == 2 * nZ) {
            System.out.println("Entered word is valid");
            return true;
        }
        System.out.println("Entered word is not valid");//Entered word is not valid
        return false;
        /*o/p
        * zzooooo
        * z -> 1, 2 = 2
        * o -> 1, 2, 3, 4, 5 = 5
        * 5 = 2*2 -> 5 != 4
        * not valid*/
    }


// Your task is to determine whether the number that is formed by selecting the last digit of all the N numbers is divisible by 10
    public static boolean isLastDigitsOfAnArrayIsDivisibleBy10() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in an array : ");//Enter the number of elements in an array : 5
        int n = scanner.nextInt();

        int[] ch = new int[n];
        for(int i = 0; i < n; i++) {
            ch[i] = scanner.nextInt();//85 25 65 21 84
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            sb.append(ch[i]%10);
        }
        System.out.println("string builder is "+sb);//string builder is 55514
        int k = Integer.parseInt(sb.toString());
        if (k % 10 == 0) {
            System.out.println(k + "is divisible ");
            return true;
        }
        System.out.println(k + " is not divisible by 10");//55514 is not divisible by 10
        return false;
    }

//H can move to left/right of grids - to get number of moves
    public static boolean check() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of grids");
        int n = 5;//scn.nextInt();
        System.out.println("Enter the number of houses : ");
        String s = scn.nextLine();
        char[] ch = s.toCharArray();
        if (n <= 20 && n == ch.length) {
            for (int i = 0; i < n; i++) {
                if (ch[i] == '.') {
                    if (ch[i-1] == 'H' || ch[i+1] == 'H') {
                        ch[i] = 'B';
                        System.out.println("surrounded by H "+i+Arrays.toString(ch));
                    }
                    if (ch[i-1] == 'B' || ch[i+1] == 'B') {
                        ch[i] = 'B';
                        System.out.println("surrounded by B"+i);
                    }
                }
            }
            System.out.println("Print it.... "+Arrays.toString(ch));
            return true;
        }
        System.out.println("Print it "+Arrays.toString(ch));
        return false;
    }

//number of tests as -t , g & p - cost of green & purple colour balloons, you have 0 & 1 as 0 1 (or) 1 0
    // 0 1 -> 0*g + 1*p = 1p in loop till n as number of participants
    // 1 0 -> 1*g + 0*p = 1g in loop till n as number of participants
    public static int minCostToBuyBalloons() {
        int times, nParticipansts, green, purple, sumGreen, sumPurple, totalSum = 0;
        Scanner s = new Scanner(System.in);
        times = s.nextInt();
        int[][] a = new int[10][times];
        for (int i = 0; i < times; i++) {
            sumGreen = sumPurple = 0;
            green = s.nextInt();
            purple = s.nextInt();
            nParticipansts = s.nextInt();
            for (int j = 0; j < nParticipansts; j++) {
                for (int k = 0; k < 2; k++) {
                    a[j][k] = s.nextInt();
                }
            }
            for (int j = 0; j < nParticipansts; j++) {
                if (a[j][0] == 1) {
                    sumGreen += green;
                    System.out.println("sum1 - g :: "+sumGreen);
                }
                if (a[j][1] == 1) {
                    sumGreen += purple;
                    System.out.println("sum1 - p :: "+sumGreen);
                }
            }
            for (int j = 0; j < nParticipansts; j++) {
                if (a[j][0] == 1) {
                    sumPurple += purple;
                    System.out.println("sum1 - g :: "+sumPurple);
                }
                if (a[j][1] == 1) {
                    sumPurple += green;
                    System.out.println("sum1 - g :: "+sumPurple);
                }
            }
            if (sumGreen > sumPurple)
                totalSum = sumPurple;
            else
                totalSum = sumGreen;
            System.out.println("total sum : "+totalSum);
        }
        return totalSum;
    }

    /*2
9 6
10
1 1
1 1
0 1
0 0
0 1
0 0
0 1
0 1
1 1
0 0
sum1 - g :: 9sum1 - p :: 15
sum1 - g :: 24
sum1 - p :: 30
sum1 - p :: 36
sum1 - p :: 42sum1 - p :: 48
sum1 - p :: 54
sum1 - g :: 63
sum1 - p :: 69
sum1 - g :: 6sum1 - g :: 15
sum1 - g :: 21
sum1 - g :: 30
sum1 - g :: 39
sum1 - g :: 48
sum1 - g :: 57
sum1 - g :: 66
sum1 - g :: 72sum1 - g :: 81
total sum : 69
1 9
10
0 1
0 0
0 0
0 1
1 0
0 1
0 1
0 0
0 1
0 0
sum1 - p :: 9
sum1 - p :: 18
sum1 - g :: 19sum1 - p :: 28
sum1 - p :: 37
sum1 - p :: 46
sum1 - g :: 1
sum1 - g :: 2
sum1 - g :: 11
sum1 - g :: 12
sum1 - g :: 13
sum1 - g :: 14
total sum : 14
    * */

    /*
    Tag is valid if the sum of every two consecutive digits of it is even and its letter is not a vowel (i.e.,"A","E","I","O","U","Y")
Input Format ::: The first line contains a string of length 9.
The format is "DDXDDD-DD", where D stands for a digit (non zero) and X is an uppercase english letter.*/
    public static boolean isTagValidWithFormat() { //Format ---->  DDXDDD-DD

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the quote : ");//Enter the quote :
        String s = scn.nextLine();// 00S022-46 (or) 12X345-67
        char[] ch = s.toCharArray();
        int flag1=0, flag2=0;
        for (int i = 0; i < ch.length; i++) {
            if((ch[0]+ch[1])%2 == 0 && (ch[3] +ch[4])%2 ==0 && (ch[4]+ch[5])%2 ==0 && (ch[7]+ch[8])%2 ==0) {
                flag1 = 1;
            }
            if(ch[2] == 'A' || ch[2]=='E'||ch[2]=='I' ||ch[2]=='O'||ch[2]=='U'||ch[2]=='Y') {
                flag2 = 1;
            }
        }
        if(flag1 == 1 && flag2 == 0) {
            System.out.println(s+" is valid");//00S022-46 is valid
            return true;
        } else {
            System.out.println(s+" is not valid");//12X345-67 is not valid
            return false;
        }
    }
}
