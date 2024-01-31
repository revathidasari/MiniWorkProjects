package com.example.minipojects.sampleFiles.practicej;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Practicing5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");//Enter the string: SAI
        String data = input.nextLine();
        System.out.println("Permutation of "+data+" : \n"+permutationOfAString(data));
        //Permutation of SAI :
        //[ISA, ASI, SAI, SIA, IAS, AIS]
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void stringToTime() {
        String s = "2023-03-28";
        LocalDate date = LocalDate.parse(s, DateTimeFormatter.ISO_DATE);
        System.out.println(date);//2023-03-28
        //method-2
        String s1 = "March 28, 2023";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate localDate = LocalDate.parse(s1, dateTimeFormatter);
        System.out.println(localDate);//2023-03-28
    }

    public void printStackTraceAsAString() {
        try {
            int division = 0 / 0;
        } catch (ArithmeticException e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            System.out.println(exceptionAsString);
            //java.lang.ArithmeticException: / by zero
            //at HelloWorld.main(HelloWorld.java:15)
        }
    }

    public void compareStrings() {
        String s1 = "Bold";
        String s2 = "Bold";
        if (s1 == s2)
            System.out.println("s1 & s2 are =");//s1 & s2 are =
        else
            System.out.println("s1 & s2 are =/=");

        //method-2
        String s3 = new String("Bold");
        String s4 = new String("Bold");
        if (s3.equals(s4))
            System.out.println("s3 & s4 are equal");//s3 & s4 are equal
        else
            System.out.println("s3 & s4 are not equal");
        if (s3 == s4)
            System.out.println("s3 & s4 are =");
        else
            System.out.println("s3 & s4 are =/=");//s3 & s4 are =/=

        boolean result = s3.equals("Bold");
        System.out.println(result);//true

        result = s4 == "Bold";
        System.out.println(result);//false

        result = s3 == s4;
        System.out.println(result);//false

        result = "Bold" == "Bold";
        System.out.println(result);//true
    }

    public void isStringANumeric() {
        String s = "12345.45";
        boolean numeric = true;
        try{
            Double num = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        if (numeric)
            System.out.println(s + " is a number");//12345.45 is a number
        else
            System.out.println(s + " is not a number");

        //method-2
        String s1 = "-13245.4";
        boolean number = true;
        number = s.matches("-?\\d+(\\.\\d+)?");
        if (number)
            System.out.println(s1 +" is a number");//-13245.4 is a number
        else
            System.out.println(s1 +" is not an number");
    }

    public void anagram() {
        //use scanner to get strings
        Scanner scn = new Scanner(System.in);
        String s1 = "Race";//scn.nextLine();
        String s2 = "Care";//scn.nextLine();
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if (s1.length() == s2.length()) {
            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            boolean result = Arrays.equals(ch1, ch2);
            if (result)
                System.out.println(s1+" and "+s2+" are anagram");//race and care are anagram
            else
                System.out.println(s1+" and "+s2+" are not anagram");
        } else {
            System.out.println(s1+" and "+s2+" are not anagram");
        }
        scn.close();
    }

    public static Set<String> permutationOfAString(String s) {
        Set<String> permutations = new HashSet<String>();
        if (s == null)
            return null;
        else if (s.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char first = s.charAt(0);
        String sub = s.substring(1);
        Set<String> words = permutationOfAString(sub);
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++) {
                permutations.add(strNew.substring(0, i) + first + strNew.substring(i));
            }
        }
        return permutations;
    }

    public void randomStringGeneration() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        System.out.println("Random String is "+randomString);//Random String is EKFMSXM
        //method-2
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers ="0123456789";
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
        StringBuilder stringBuilder = new StringBuilder();
        Random random1 = new Random();
        int len = 10;
        for (int i = 0; i < len; i++) {
            int index1 = random1.nextInt(alphaNumeric.length());
            char randomCh = alphaNumeric.charAt(index1);
            stringBuilder.append(randomCh);
        }
        String stringRandom = stringBuilder.toString();
        System.out.println("String on random generation is "+stringRandom);//String on random generation is iHpfBEXxbz
    }

    public void clearStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Java");
        stringBuffer.append(" is ");
        stringBuffer.append("popular.");
        System.out.println("StringBuffer : "+stringBuffer);//StringBuffer : Java is popular.
        stringBuffer.delete(0, stringBuffer.length());
        System.out.println("Updated stringBuffer : " + stringBuffer);//Updated stringBuffer :
        //method-2
        stringBuffer.append("method2");
        System.out.println("Method-2 -> StringBuffer :"+stringBuffer);//Method-2 -> StringBuffer :method2
        stringBuffer.setLength(0);
        System.out.println("Method-2 -> updated stringbuffer : "+stringBuffer);//Method-2 -> updated stringbuffer :
        //method-3
        stringBuffer.append("method3");
        System.out.println("Method-3 -> StringBuffer :"+stringBuffer);//Method-3 -> StringBuffer :method3
        stringBuffer = new StringBuffer();
        System.out.println("Method-3 -> updated stringbuffer : "+stringBuffer);//Method-3 -> updated stringbuffer :
    }

    public void capitalizeFirstLetterOfAString() {
        String name = "revathi";
        String firstLetter = name.substring(0,1);
        String remainingLetters = name.substring(1, name.length());
        firstLetter = firstLetter.toUpperCase();
        name = firstLetter + remainingLetters;
        System.out.println("Name : "+name);//Name : Revathi
        //method-2
        String fullName = "dasari revathi reddy";
        char[] ch = fullName.toCharArray();
        boolean foundSpace = true;
        for (int i = 0; i < ch.length; i++) {
            if (Character.isLetter(ch[i])) {
                if (foundSpace) {
                    ch[i] = Character.toUpperCase(ch[i]);
                    foundSpace = false;
                }
            } else {
                foundSpace = true;
            }
        }
        fullName = String.valueOf(ch);
        System.out.println("Full name is "+fullName);//Full name is Dasari Revathi Reddy
    }

    public void loopEachCharacterOfAString() {
        String name = "revathi";
        System.out.println("Characters in "+ name+" by using FOR loop are : ");//Characters in revathi by using FOR loop are : r,e,v,a,t,h,i,
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            System.out.print(ch+",");
        }
        //method-2
        System.out.println("Characters in string \""+name+" \"by using FOR-EACH loop are : ");//Characters in string "revathi "by using FOR-EACH loop are :r,e,v,a,t,h,i,
        for (char c : name.toCharArray()) {
            System.out.print(c+",");
        }
    }

    public void equalsAndDoubleEquals() {
        String name1 = new String("dasari");
        String name2 = new String("dasari");
        System.out.println("Check if 2 strings are equal");//Check if 2 strings are equal
        boolean result1 = (name1 == name2);
        System.out.println("Using == operator is "+result1);//Using == operator is false
        boolean result2 = name1.equals(name2);
        System.out.println("Using equals() is "+result2);//Using equals() is true

        String name3 = name1;
        boolean result3 = (name1 == name3);
        System.out.println("Using == operator is "+result3);//Using == operator is true
        boolean result4 = name1.equals(name3);
        System.out.println("Using equals() is "+result4);//Using equals() is true
    }

    public void checkStringWithSwitch() {
        String language = "Java";
        switch (language) {
            case "Kotlin":
                System.out.println(language+" is used for android applications");
                break;
            case "Java":
                System.out.println(language+" is famous for enterprise applications");
                break;
            case "JavaScript":
                System.out.println(language+" is famous for frontend and backend");
                break;
            case "Python":
                System.out.println(language+" is famous for ML and AI");
                break;
            default:
                System.out.println(language+" is not found on record");
                break;
        }//Java is famous for enterprise applications.
    }

    public void subStringExistence() {
        String line = "This is a whole string";
        String s1 = "whole";
        String s2 = "substring";
        boolean res = line.contains(s1);
        if (res)
            System.out.println(s1 +" is present in the string");//whole is present in the string
        else
            System.out.println(s1 +" is not present in the string");
        res = line.contains(s2);
        if (res)
            System.out.println(s2 +" is present in the string");
        else
            System.out.println(s2 +" is not present in the string");//substring is not present in the string

        //method-2
        int len = line.indexOf(s1);
        if (len == -1)
            System.out.println(s1 +" is not present in the string");
        else
            System.out.println(s1 +" is present in the string");//whole is present in the string
        len = line.indexOf(s2);
        if (len == -1)
            System.out.println(s2 +" is not present in the string");//substring is not present in the string
        else
            System.out.println(s2 +" is present in the string");
    }

    public void isStringAValidShuffleOf2Strings() {
        String first = "RS";
        String second = "43";
        String[] results = {"4RS3", "S4R3", "S34RR"};
        for (String res : results) {
            if (checkLength(first, second, res) == true && shuffleCheck(first, second, res) == true) {
                System.out.println(res+" is a valid shuffle of "+first+" and "+second);
            } else {
                System.out.println(res+" is not a valid shuffle of "+first+" and "+second);
            }
        }
        //4RS3 is a valid shuffle of RS and 43
        //S4R3 is a valid shuffle of RS and 43
        //S34RR is not a valid shuffle of RS and 43
    }

    static boolean checkLength(String first, String second, String result) {
        return first.length() + second.length() == result.length();
    }
    static String sortString(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        s = String.valueOf(ch);
        return s;
    }
    static boolean shuffleCheck(String first, String second, String result) {
        first = sortString(first);
        second = sortString(second);
        result = sortString(result);
        int i = 0, j = 0, k = 0;
        while (k != result.length()) {
            if (i < first.length() && first.charAt(i) == result.charAt(k))
                i++;
            else if (j < second.length() && second.charAt(j) == result.charAt(k))
                j++;
            else
                return false;

            k++;
        }
        if (i < first.length() || j < second.length())
            return false;
        return true;
    }
}
