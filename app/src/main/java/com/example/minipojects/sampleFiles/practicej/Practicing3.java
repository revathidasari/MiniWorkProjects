package com.example.minipojects.sampleFiles.practicej;

import java.math.BigInteger;
import java.util.Scanner;

//Condition checks & loops
public class Practicing3 {

    public static void main(String[] args) {
        Practicing3 practicing3 = new Practicing3();

    }

    public void factorial() {
        int n = 10;
        //method-1
        long fact = 1;
        for (int i = 1; i <= n; i++) {//use while loop also
            fact *= i;
        }
        System.out.println("Factorial of 10 is "+fact);//Factorial of 10 is 3628800
        //method-2
        BigInteger bigInteger = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        System.out.printf("Factorial of 10 is %d ",bigInteger);//Factorial of 10 is 3628800
        //method-3
        int k = 6;
        long res = multiplyNumbers(k);
        System.out.println("Factorial by recursion of "+k+" = "+res);//Factorial by recursion of 6 = 720
    }

    public static long multiplyNumbers(int n){
        if (n > 1)
            return n * multiplyNumbers(n - 1);
        else
            return 1;
    }

    public void generateMultiplicationTable() {
        int n = 5;
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d * %d = %d \n", n, i , n * i);
//            7 * 1 = 7
//            7 * 2 = 14
//            7 * 3 = 21
//            7 * 4 = 28
//            7 * 5 = 35
//            7 * 6 = 42
//            7 * 7 = 49
//            7 * 8 = 56
//            7 * 9 = 63
//            7 * 10 = 70
        }
    }

    public void fibonacciSeries() {
        int n = 10, first = 0, second = 1;
        System.out.println("Fibonacci series till "+ n + " terms : ");
        for (int i = 1; i <= n ; i++) {
            System.out.println(first+", ");//0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
            int next = first + second;
            first = second;
            second = next;
        }
        //method-2
        int n1 = 100, first1 = 0, second1 = 1;
        while(first1 <= n1) {
            System.out.println(first1+",");//_____0,1,1,2,3,5,8,13,21,34,55,89,
            int next1 = first1 +  second1;
            first1 = second1;
            second1 = next1;
        }
    }

    public void numbersGCD() {
        int n1 = 81, n2 = 153;
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println("GCD of "+n1 +" and "+n2 +" is "+gcd);//GCD of 81 and 153 is 9
        //method-2
        while (n1 != n2) {
            if (n1 > n2) {
                n1 -= n2;
            } else {
                n2 -= n1;
            }
        }
        System.out.println("GCD : "+n1);//GCD : 9
        //method-3
        int n3 = 81, n4 = -153;
        n3 = (n3 > 0) ? n3 : -n3;
        n4 = (n4 > 0) ? n4 : -n4;
        while (n3 != n4) {
            if (n3 > n4) {
                n3 -= n4;
            } else {
                n4 -= n3;
            }
        }
        System.out.println("GCD with negative number is "+n3);//GCD with negative number is 9
        //method-4
        int a = 366, b = 60;
        int hcf = hcf(a, b);
        System.out.printf("G.C.D of %d and %d is %d.", a, b, hcf);//G.C.D of 366and 60 is 6.
    }
    public static int hcf(int a, int b) {
        if (b != 0)
            return hcf(b, a % b);
        else
            return a;
    }

    public void lcmOfNumbers() {
            int n1 = 72, n2 = 120, lcm;
            lcm = (n1 > n2) ? n1 : n2;
            while (true) {
                if (lcm % n1 == 0 && lcm % n2 == 0) {
                    System.out.printf("LCM of %d and %d is %d ", n1, n2 , lcm);//LCM of 72 and 120 is 360
                    break;
                }
                ++lcm;
            }
            //method-2
            int gcd = 1;
            for (int i = 1; i <= n1 && i <= n2; ++i) {
                if (n1 % i == 0 && n2 % i == 0) {
                    gcd = i;
                }
            }
            int lcm1 = (n1 * n2) /gcd ;
            System.out.printf("LCM1 of %d and %d is %d ",n1, n2 , lcm1);// LCM1 of 72and 120 is 360
    }

    public void displayAlphabets() {
        char c;
        for (c = 'A'; c <= 'Z'; ++c) {
            System.out.println(c+" ");//A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
        }
        for (c = 'a'; c <= 'z'; ++c) {
            System.out.println(c+" ");//a b c d e f g h i j k l m n o p q r s t u v w x y z
        }
    }

    public void numberOfDigitsInANumber() {
        int count = 0, n = 0003452, n1 = 123456, count1 = 0;
        while (n != 0) {
            n /= 10;
            ++count;
        }
        System.out.println("Number of digits in "+n +" is "+count);//Number of digits in 0 is 4
        for (; n1 !=0 ; n1 /= 10, ++count1) {
        }
        System.out.println("Number of digits in "+n1+" is "+count1);//Number of digits in 0 is 6
    }

    public void reverseANumber() {
        int n = 1234, rev = 0, temp = n;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        System.out.println(temp + " reversed as "+rev);//1234 reversed as 4321
        //method-2
        int n1 = 1234567, rev1 = 0, temp1 = n1;
        for (; n1 != 0; n1 /= 10) {
            int digit1 = n1 % 10;
            rev1 = rev1 * 10 + digit1;
        }
        System.out.println(temp1 +" is reversed as "+rev1);//1234567 is reversed as 7654321
    }

    public void powerOfANumber() {
        int base = 3, exponent = 4;
        long result = 1;
        while (exponent != 0) {
            result *= base;
            --exponent;
        }
        System.out.println("Result is "+result);//81
        //method-2
        int base1 = 3, exponent1 = 4;
        long result1 = 1;
        for (; exponent1 != 0; --exponent1) {
            result1 *= base1;
        }
        System.out.println(result1);//81
        //method-3
        int b = 3, e = -4;
        double p = Math.pow(b, e);
        System.out.println(p);//0.012345679012345678
        //method-4
        int b1 = -3, e1 = 4;
        double p1 = Math.pow(b1, e1);
        System.out.println(p1);//9.0

        int k = 3, n = 4;
        int res = power(k,n);
        System.out.println(k+"^"+n +"="+res);//3^4=81
    }
    public static int power(int a, int b){
        if (b != 0) {
            return (a * power(a, b-1));
        } else {
            return 1;
        }
    }

    public void palindrome() {
        String s = "Radar", revS = "";
        int length = s.length();
        for (int i = length-1; i >= 0; --i) {
            revS = revS + s.charAt(i);
        }
        if (s.toLowerCase().equals(revS.toLowerCase())) {
            System.out.println(s + " is an palindrome string");//Radar is an palindrome string
        } else
            System.out.println(s + " is not an palindrome string");

        //method-2
        int n = 34543, revN = 0, remainder;
        int actualN = n;
        while (n != 0) {
            remainder = n % 10;
            revN = revN * 10 + remainder;
            n /= 10;
        }
        if (actualN == revN)
            System.out.println(actualN +" is an palindrome");//34543 is an palindrome
        else
            System.out.println(actualN +" is not an palindrome");
    }

    public void primeNumberOrNot() {
        int n = 29;
        boolean flag = false;
        for (int i = 2; i <= n/2; ++i) {//use while loop also
            if (n%i == 0){
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println(n + " is a prime number");//29 is a prime number
        else
            System.out.println(n + " is not a prime number");
    }

    public void primeIn2Intervals() {
        int low = 20, high = 50;
        while (low < high) {
            if (checkPrimeNumber(low)) {
                System.out.println(low + " ");//23 29 31 37 41 43 47
            }
            ++low;
        }
    }
    public static boolean checkPrimeNumber(int n) {
        boolean isPrime = true;
        for (int i = 2; i <= n/2; ++i) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public void NumAsSumOf2PrimeNumbers() {
        int n = 34;
        boolean flag = false;
        for (int i = 2; i <= n/2; ++i) {
            if (checkPrimeNumber(i)) {
                if (checkPrimeNumber(n-i)) {
                    System.out.printf("%d = %d + %d,\n",n, i, n - i);//34= 3 + 31, 34 = 5 + 29, 34 = 11 + 23, 34 = 17 + 17,
                    flag = true;
                }
            }
        }
        if (!flag)
            System.out.println(n+" cannot be expressed as the sum of 2 prime numbers");
    }

    public void armstrongNumber() {//153 = 1*1*1 + 5*5*5 + 3*3*3  // 153 is an Armstrong number.
        int n = 371, actualN, remainder, result = 0;
        actualN = n;
        while (actualN != 0) {
            remainder = actualN % 10;
            result += Math.pow(remainder, 3);
            actualN /= 10;
        }
        if (result == n)
            System.out.println(n+ " is an armstrong number");//371 is an armstrong number
        else
            System.out.println(n+ " is not an armstrong number");

        //method-2
        int n1 = 1634, actualN1, remainder1, result1=0, i=0;
        actualN1 = n1;
        for (;actualN1 != 0; actualN1 /= 10, ++i);
        actualN1 = n1;
        for (; actualN1 != 0 ; actualN1 /= 10) {
            remainder1 = actualN1 % 10;
            result1 += Math.pow(remainder1, i);
        }
        if (result1 == n1)
            System.out.println(n1+ " is an armstrong number");//1634 is an armstrong number
        else
            System.out.println(n1+ " is not an armstrong number");
    }

    public void armstrongIn2Intervals() {
        int low = 999, high = 99999;
        for (int n = low + 1; n < high; ++n) {
            if (checkArmStrong(n))
                System.out.println(n+" ");//1634 8208 9474 54748 92727 93084
        }
    }

    public static boolean checkArmStrong(int n) {
        int digits = 0;
        int result = 0;
        int actualN = n;
        while (actualN != 0) {
            actualN /= 10;
            ++digits;
        }
        actualN = n;
        while (actualN != 0) {
            int remainder = actualN % 10;
            result += Math.pow(remainder, digits);
            actualN /= 10;
        }
        return result == n;
    }

    public void factorsOfN() {
        int n = 60;
        System.out.print("Factors of n "+n +"are : ");
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                System.out.println(i+" ");//Factors of n 60are : 1 2 3 4 5 6 10 12 15 20 30 60
            }
        }
        //method-2
        int k = -60;
        System.out.print("Factors of k "+k +"are : ");
        for (int i = k; i <= Math.abs(k); ++i) {
            if (i == 0)
                continue;
            else {
                if (k % i == 0)
                    System.out.print(i +" ");//Factors of k -60are : -60 -30 -20 -15 -12 -10 -6 -5 -4 -3 -2 -1 1 2 3 4 5 6 10 12 15 20 30 60
            }
        }
    }

    public void simpleCalculatorUsingSwitch() {
        char operator;
        Double n1, n2, result;
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an operator : +, -, * or /");
        operator = input.next().charAt(0); //*
        System.out.println("Enter first number");
        n1 = input.nextDouble();//3
        System.out.println("Enter second number");
        n2 = input.nextDouble();//9

        switch (operator) {
            case '+':
                result = n1 + n2;
                System.out.println(n1 +" + "+n2+" = "+result);
                break;
            case '-':
                result = n1 - n2;
                System.out.println(n1 +" - "+n2+" = "+result);
                break;
            case '*':
                result = n1 * n2;
                System.out.println(n1 +" * "+n2+" = "+result);//3.0 * 9.0 = 27.0
                break;
            case '/':
                result = n1 / n2;
                System.out.println(n1 +" / "+n2+" = "+result);
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
        input.close();
    }

    public void countVowelsConsonantsDigitsSpaces() {
        String line = "Line with Vowels Consonants 123.";
        int vowels = 0, consonants = 0, digits = 0, spaces = 0;
        line = line.toLowerCase();
        for (int i = 0; i < line.length(); ++i) {
            char ch = line.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                ++vowels;
            } else if (ch >= 'a' && ch <= 'z') {
                ++consonants;
            } else if (ch >= '0' && ch <= '9') {
                ++digits;
            } else if (ch == ' ') {
                ++spaces;
            }
        }
        System.out.println("Number of vowels: "+vowels+ ", consonants: "+consonants
        +", digits: "+digits+", spaces: "+spaces);//Number of vowels: 8, consonants: 16, digits: 3, spaces: 4
    }

    public void sortInLexicographicalOrder(){//Dictionary order
        String[] words = {"Ruby", "C", "Java", "Python"};
        for (int i = 0 ; i < 3; ++i) {
            for (int j = i + 1; j < 4; ++j) {
                if (words[i].compareTo(words[j]) > 0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        System.out.println(" In Lexicographical order : ");
        for (int i = 0; i < 4 ; ++i) {
            System.out.println(words[i]);//C Java Python Ruby
        }
    }

    public void halfPyramid() {
        int rows = 5;
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print("* ");
            }
            System.out.println();
            //*
            //* *
            //* * *
            //* * * *
            //* * * * *
        }
    }

    public void halfPyramidWithNumbers() {
        int rows = 5;
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j+" ");
            }
            System.out.println();
            //1
            //1 2
            //1 2 3
            //1 2 3 4
            //1 2 3 4 5
        }
    }

    public void halfPyramidWithAlphabets() {
        char last = 'E', alphabet = 'A';
        for (int i = 1; i <= (last - 'A'+1); ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(alphabet+" ");
            }
            ++alphabet;
            System.out.println();
            //A
            //B B
            //C C C
            //D D D D
            //E E E E E
        }
    }

    public void halfPyramidInverted() {
        int rows = 5;
        for (int i = rows; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print("* ");
            }
            System.out.println();
            //* * * * *
            //* * * *
            //* * *
            //* *
            //*
        }
    }

    public void halfPyramidWithNumbersInverted() {
        int rows = 5;
        for (int i = rows; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j+" ");
            }
            System.out.println();
            //1 2 3 4 5
            //1 2 3 4
            //1 2 3
            //1 2
            //1
        }
    }

    public void fullPyramid() {
        int rows = 5, k = 0;
        for (int i = 1; i <= rows; ++i, k = 0) {
            for (int spaces = 1; spaces <= rows - i; ++spaces) {
                System.out.print(" ");
            }
            while (k != 2 * i - 1) {
                System.out.print("* ");
                ++k;
            }
            System.out.println();
            //        *
            //      * * *
            //    * * * * *
            //  * * * * * * *
            //* * * * * * * * *
        }
    }

    public void fullPyramidWithNumbers() {
        int rows = 5, k = 0, count = 0, count1 = 0;
        for (int i = 1; i <= rows; ++i) {
            for (int spaces = 1; spaces <= rows - i; ++spaces) {
                System.out.print(" ");
                ++count;
            }
            while (k != 2 * i - 1) {
                if (count <= rows - 1) {
                    System.out.print((i + k) + " ");
                    ++count;
                } else{
                    ++count1;
                    System.out.print((i + k - 2 * count1)+" ");
                }
                ++k;
            }
            count1 = count = k = 0;
            System.out.println();
            //        1
            //      2 3 2
            //    3 4 5 4 3
            //  4 5 6 7 6 5 4
            //5 6 7 8 9 8 7 6 5
        }
    }


    public void fullPyramidInverted() {
        int rows = 5;
        for (int i = rows; i >= 1 ; --i) {
            for (int spaces = 1; spaces <= rows - i; ++spaces) {
                System.out.print(" ");
            }
            for (int j = i ; j <= 2 * i - 1; ++j) {
                System.out.print("* ");
            }
            for (int j = 0 ; j < i - 1; ++j) {
                System.out.print("* ");
            }
            System.out.println();
            //* * * * * * * * *
            //  * * * * * * *
            //    * * * * *
            //      * * *
            //        *
        }
    }

    public void pascalsTriangle() {
        int rows = 6, coef = 1;
        for (int i = 0; i < rows; i++) {
            for (int space = 1; space < rows - i; ++space) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == 0)
                    coef = 1;
                else
                    coef = coef * (i - j + 1) / j;
                System.out.printf("%4d", coef);
            }
            System.out.println();
            //           1
            //         1   1
            //       1   2   1
            //     1   3   3    1
            //   1   4   6   4   1
            // 1   5   10   10  5   1
        }
    }


    public void floydsTriangle() {
        int rows = 4, number = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number+ " ");
                ++number;
            }
            System.out.println();
            //1
            //2 3
            //4 5 6
            //7 8 9 10
        }
    }

    public void binaryToDecimal() {
        long n = 110110111;
        int decimal = convertBinaryToDecimal(n);
        System.out.println("Binary to decimal");
        System.out.println(n+" = "+decimal);//110110111 = 439
        //method-2
        String binary = "01011011";
        int dec = Integer.parseInt(binary, 2);
        System.out.println(binary+" in binary = "+dec+" in decimal");//01011011 in binary = 91 in decimal
    }
    public static int convertBinaryToDecimal(long n) {
        int decimalNum = 0, i = 0;
        long remainder;
        while (n != 0) {
            remainder = n % 10;
            n /= 10;
            decimalNum += remainder * Math.pow(2, i);
            ++i;
        }
        return decimalNum;
    }

    public void decimalToBinary() {
        int n = 19;
        System.out.println("Decimal to Binary");
        long binary = convertDecimalToBinary(n);
        System.out.println("\n"+n +" = "+binary);//19 = 10011
        //method-2
        int decimal = 91;
        String b = Integer.toBinaryString(decimal);
        System.out.println(decimal+" in decimal = "+b+" in binary");//91 in decimal = 1011011 in binary
    }
    public static long convertDecimalToBinary(int n) {
        long binaryNum = 0;
        int remainder, i = 1, step = 1;
        while (n != 0) {
            remainder = n % 2;
            System.out.println("Step "+step++ +" : "+n+ "/2");
            System.out.println("Quotient = "+n/2+", Remainder = "+remainder);
        // 2)91 = 1     //   Step 1 : 19/2
        // 2)45 = 1     //   Quotient = 9, Remainder = 1
        // 2)22 = 0     //   Step 2 : 9/2
        // 2)11 = 1     //   Quotient = 4, Remainder = 1
        // 2)5 = 1      //   Step 3 : 4/2
        // 2)2 = 0      //   Quotient = 2, Remainder = 0
        // 2)1 = 1      //   Step 4 : 2/2
        //              //   Quotient = 1, Remainder = 0
        //              //   Step 5 : 1/2
        //              //   Quotient = 0, Remainder = 1
            n /= 2;
            binaryNum += remainder * i;
            i *= 10;
        }
        return binaryNum;
    }

    public void decimalToOctal() {
        int decimal = 78;
        int octal = convertDecimalToOctal(decimal);
        System.out.printf("%d in decimal = %d in octal", decimal, octal);//78 in decimal = 116 in octal
        // 8| 78
        // 8| 9 -- 6
        // 8| 1 -- 1
        // 8| 0 -- 1 ==> 116
    }
    public static int convertDecimalToOctal(int n) {
        int octalNum = 0, i = 1;
        while (n != 0) {
            octalNum += (n % 8) * i;
            n /= 8;
            i *= 10;
        }
        return octalNum;
    }

    public void octalToDecimal() {
        int octal = 116;
        int decimal = convertOctalToDecimal(octal);
        System.out.printf("%d in octal = %d in decimal", octal, decimal);//116 in octal = 78 in decimal
        //1 * 8^2 + 1 * 8^1 + 1 * 8^0 = 78
    }
    public static int convertOctalToDecimal(int n){
        int decimalNum = 0, i = 0;
        while (n != 0) {
            decimalNum += (n % 10) * Math.pow(8, i);
            ++i;
            n /= 10;
        }
        return decimalNum;
    }

    public void binaryToOctal() {
        long binary = 101001;
        int octal = convertBinaryToOctal(binary);
        System.out.println(binary+" in binary = "+octal+" in octal");//101001 in binary = 51 in octal
    }
    public static int convertBinaryToOctal(long n) {
        int octalNum = 0, decimalNum = 0, i = 0;
        while (n != 0) {
            decimalNum += (n % 10) * Math.pow(2, i);// 1 * 25 + 0 * 24 + 1 * 23 + 0 * 22 + 0 * 21 + 1 * 20 = 41
            ++i;
            n /= 10;
        }
        i = 1;
        while (decimalNum != 0) {
            octalNum += (decimalNum % 8) * i;
            //8 | 41
            //8 | 5 -- 1
            //8 | 0 -- 5
            //(51)
            decimalNum /= 8;
            i *= 10;
        }
        return octalNum;
    }

    public void octalToBinary() {
        int octal = 67;
        long binary = convertOctalToBinary(octal);
        System.out.println(octal+ " in octal = "+binary+" in binary");//67 in octal = 110111 in binary
    }
    public static long convertOctalToBinary(int n) {
        int decimalNum = 0, i = 0;
        long binaryNum = 0;
        while (n != 0) {
            decimalNum += (n % 10) * Math.pow(8, i);//6 * 81 + 7 * 80 = 55
            ++i;
            n /= 10;
        }
        i = 1;
        while (decimalNum != 0) {
            binaryNum += (decimalNum % 2) * i;
            //2 | 55
            //2 | 27 -- 1
            //2 | 13 -- 1
            //2 | 6  -- 1
            //2 | 3  -- 0
            //2 | 1  -- 1
            //2 | 0  -- 1
            //(110111)
            decimalNum /= 2;
            i *= 10;
        }
        return binaryNum;
    }

    public void reverseASentence() {
        String sentence = "Go and work";
        String reversed = reverseString(sentence);
        System.out.println("The reversed string is "+reversed);//The reversed string is krow dna oG
    }
    public static String reverseString(String s) {
        if (s.isEmpty())
            return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }


}
