package com.example.minipojects.sampleFiles.practicej;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Practicing2 {

    public static void main(String[] args) {

        Practicing2 practicing2 = new Practicing2();


    }

    public void charASCIIValue() {
        char ch = 'a'; //97 & r -114
        int ascii = ch;
        int asciiCast = (int) ch;
        System.out.println("ascii "+ascii+ " ,asciiCast "+asciiCast);
    }

    public void quotientAndRemainder() {
        int dividend = 25, divisor = 4;
        int quotient = dividend / divisor;//6.5 as integer is 6
        int remainder = dividend % divisor; //1
        System.out.println("quotient "+quotient+" ,remainder "+remainder);//quotient 6 ,remainder 1
    }

    public void swapNumbers() {
        float first = 1.1f, second = 2.2f;
       //method-1
        float temp = first;
        first = second;
        second = temp;
        System.out.println("After swaping first "+first+ " , second "+second);//After swaping first 2.2 , second 1.1

        //method-2
        float first1= 11.11f, second1 = 22.22f;
        first1 = first1 - second1; //11.11f-22.22f
        second1 = first1 + second1; //(11.11f-22.22f)+22.22f = 11.11f
        first1 = second1 - first1; //11.11f-(11.11f-22.22f) = 22.22f
        System.out.println("After swaping 2 first1 "+first1+" , second1 "+second1);//After swaping 2 first1 22.22 , second1 11.11
    }

    public void evenOrOdd() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        //method-1
        if (num %2 ==0) {
            System.out.println(num +" is even");//10 is even
        } else {
            System.out.println(num+" is odd");//9 is odd
        }
        //method-2
        String evenOdd = (num % 2 == 0) ? "even" : "odd";
        System.out.println(num+ " is "+evenOdd);//9 is odd
    }

    public void vowelOrConsonant() {
        char ch = 'i';
        //method-1
        if (ch =='a' || ch=='e' || ch=='i' || ch =='o' || ch=='u') {
            System.out.println(ch+ " is vowel");
        } else {
            System.out.println(ch + " is consonant");
        }
        //method-2
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println(ch +" -vowel");
                break;
            default:
                System.out.println(ch +" -consonant");
                break;
        }
    }

    public void largestNumber() {
        double n1 = -4.5, n2 = 3.9, n3 = 2.5;
        //method-1
        if (n1 >= n2 && n1 >= n3) {
            System.out.println(n1 + " is largest");
        } else if (n2 >= n1 && n2 >= n3) {
            System.out.println(n2 + " is largest");//3.9 is largest
        } else {
            System.out.println(n3 + " is largest");
        }
        //method-2
        if (n1 >= n2) {
            if (n1 >= n3) {
                System.out.println(n1+" -largest");
            } else
                System.out.println(n3+" -largest");
        } else {
            if (n2 >= n3) {
                System.out.println(n2+" -largest");//3.9 -largest
            } else
                System.out.println(n3+" -largest");
        }
    }

/*
    ax2 + bx + c = 0
    x = (-b ± √(b2-4ac)) / (2a)
    b2-4ac is known as the determinant of a quadratic equation.
    if determinant > 0, roots are real and different
if determinant == 0, roots are real and equal
if determinant < 0, roots are complex complex and different
*/
    public void rootsOfQuadraticEquation() {
        double a = 2.3, b = 4, c = 5.6;
        double root1, root2;
        double determinant = b * b - 4 * a * c;
        if (determinant > 0){
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);
            System.out.format("root1 = %.2f and root2 = %.2f ", root1, root2);
        } else if (determinant == 0) {
            root1 = root2 = -b / (2 * a);
            System.out.format("root1 = root2 = %.2f", root1);
        } else {
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-determinant) / (2 * a);
            System.out.format("root1 = %.2f + %.2fi", real, imaginary);
            System.out.printf("\nroot1 = %.2f - %.2fi", real, imaginary);//root1 = -0.87 + 1.30iroot1 = -0.87 - 1.30i
        }
    }

    public void isALeapYear() {
        int year = 1900;
        boolean leap = false;
        if (year % 4 ==0) {
            if (year % 100 == 0) {
                if (year % 400 ==0)
                    leap = true;
                else
                    leap = false;
            } else
                leap = true;
        } else
            leap = false;
        if (leap)
            System.out.println(year + " is an leap year");
        else
            System.out.println(year + " is not an leap year");
    }

    public void numberIsPositiveOrNegative() {
        double num = 12.3;
        if (num < 0.0) {
            System.out.println(num + " is an negative number");
        }else if (num > 0.0) {
            System.out.println(num + " is an positive number");
        } else {
            System.out.println(num + " is 0");
        }
    }

    public void charIsAlphabetOrNot() {
        char c = '*';
        //method-1
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            System.out.println(c + " is an Alphabet");
        } else {
            System.out.println(c +" is not an Alphabet");
        }
        //method-2
        char ch = 'r';
        if (Character.isAlphabetic(ch)) {
            System.out.println(ch + " is an Alphabet");
        } else {
            System.out.println(ch + " is not an Alphabet");
        }
    }

    public void sumOfNaturalNumbers() {//1+2+3+....+n
        int n = 100, sum = 0;
        for (int i = 1; i <= n; i++) { //use while loop also
            sum += i;
        }
        System.out.println("sum = "+sum);//sum = 5050
        //method-2
        int n1 = 20;
        int res = addNumbers(n1);
        System.out.println("Result is "+res);//Result is 210
    }

    public static int addNumbers(int n) {
        if (n != 0)
            return n + addNumbers(n - 1);
        else
            return n;
    }

    public void frequencyOfCharInString() {
        String s = "Its an string with characters";
        char ch = 'e';
        int frequency = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                ++frequency;
            }
        }
        System.out.println("Frequnecy of "+ch +" is "+frequency);//Frequnecy of e is 1
    }

    public void removeWhiteSpacesFromString() {
        String s = "Remov   ing white space -s from    th  is str  ing";
        s = s.replaceAll("\\s","");
        System.out.println("After removing the white spaces "+s);//Removingwhitespace-sfromthisstring
    }

    public void roundingNumberToDecimalFormat() {
        double n = 1.234567;
        System.out.format("%.4f",n);//1.2346
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        System.out.println(decimalFormat.format(n));//1.235
    }

    public void isStringEmptyOrNull() {
        String s1 = null;
        String s2 = "";
        String s3 = " ";
        if (s1 == null)
            System.out.println(s1 + " is null");
        if (s2.isEmpty())
            System.out.println(s2 + " is empty");
        if (s3 != null && !s3.isEmpty())
            System.out.println(s3+" is neither null nor empty");
        if (s3.trim().isEmpty())
            System.out.println(s3+" is empty after trimmed");
    }

    public void methodsOfString() {
        String s = "hello string";
        s.split(" ");//Splits the string at the specified string (regex)
        s.compareTo("hi");//Compares two strings in the dictionary order
        s.compareToIgnoreCase("helLO"); //Compares two strings ignoring case differences
        s.length();//Returns the length of the string
        s.replace('e','o');//Replace all matching characters/text in the string
        s.replaceAll("l","i");//Replace all substrings matching the regex pattern
        s.substring(3);//Returns a substring from the given string
        s.equals("hi string");//Compares two strings
        s.equalsIgnoreCase("HI ");//Compares two strings ignoring case differences
        s.contains("s");//Checks whether the string contains a substring
        s.indexOf('e');//Returns the index of the character/substring
        s.trim();//Removes any leading and trailing whitespace
        s.charAt(2);//Returns the character at the given index
        s.toLowerCase();//Converts characters in the string to lower case
        s.concat("yeee");//Concatenates two strings and returns it
        s.valueOf(4);//Returns the string representation of a value
        s.matches("string");//checks whether the string matches the given regex
        s.startsWith("s");//Checks if the string begins with the given string
        s.endsWith("g");//Checks if the string ends with the given string
        s.isEmpty();//Checks whether a string is empty or not
        s.intern();//Returns a canonical representation of the string
        s.getBytes();//Encodes the string into a sequences of bytes
        s.contentEquals("ff");//Checks whether the string is equal to charSequence
        s.hashCode();//Returns a hash code for the string
        s.join("s","q");//Joins the given strings using the delimiter
        s.replaceFirst("o","k");//Replace the first matching substring
        s.subSequence(2,7);//Returns a subsequence from the string
        s.toCharArray();//Converts the string to a char array
        String.format("string %s", s);//Returns a formatted string
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void methodsOfArrayList() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("hi");//inserts the element to the arraylist
        stringArrayList.add("hello");
        ArrayList<String> stringArrayList1 = new ArrayList<>();
        stringArrayList1.addAll(stringArrayList);//adds all elements of a collection to arraylist
        stringArrayList1.clear();//removes all the elements from arraylist
        stringArrayList1.add("hello");

        stringArrayList.clone();//makes a copy of the array list
        stringArrayList.contains("bye");//checks if the element is present in the arraylist
        stringArrayList.get(1);//returns the element present in the specified index
        stringArrayList.indexOf("hello");//returns the position of the specified element
        stringArrayList.removeAll(stringArrayList);//removes multiple elements from the arraylist
        stringArrayList.remove(1);//removes the single element from the arraylist
        stringArrayList.size();//returns the length of an arraylist
        stringArrayList.isEmpty();//checks if the arraylist is empty
        stringArrayList.subList(0,1);//returns a portion of the arraylist
        stringArrayList.set(0, "welcome");//replace the single element from an arraylist
        stringArrayList.sort(Comparator.naturalOrder());//sorts the arraylist according to specified order

        String[] arr = new String[stringArrayList.size()];
        stringArrayList.toArray(arr);//converts an arraylist to an array
        for (String item: arr) {
            System.out.println(item+",");
        }

        stringArrayList.toString();//converts the arraylist into a String
        stringArrayList.ensureCapacity(4);//set the size of an arraylist
        stringArrayList.lastIndexOf("goodbye");//returns position of last occurrence of the element
        stringArrayList.retainAll(stringArrayList1);//retains only the common elements
        stringArrayList.containsAll(stringArrayList1);//checks if a collection is a subset of arraylist
        stringArrayList.trimToSize();//trims the capacity of arraylist equal to the size

        stringArrayList.subList(0,1).clear();//remove element between 0 to 1
        stringArrayList.replaceAll(e -> e.toUpperCase());//replace all elements from the arraylist
        stringArrayList.removeIf(e -> e.equalsIgnoreCase("hello"));//removes element that satisfy the condition

        stringArrayList.forEach((e)-> {//performs an action to all elements of arraylist
            e = e +"::";
            System.out.println(e+ "-");
        });

        Iterator<String> stringIterator = stringArrayList.iterator();//returns an iterate to loop through the ArrayList
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
            System.out.print(", ");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void methodsOfHashMap() {
        HashMap<String, Integer> numbers = new HashMap<>();
        numbers.put("one",1);
        numbers.clear();//remove all elements from HashMap
        numbers.put("two",2);//inserts the specified item to the hashmap
        HashMap<String, Integer> cloneNumbers = (HashMap<String, Integer>) numbers.clone();//makes the copy of the hashmap
        numbers.isEmpty();//checks if the HashMap is empty
        numbers.size();//returns the number of items in HashMap
        numbers.putAll(cloneNumbers);//inserts all items from a map to HashMap
        numbers.putIfAbsent("three",3);//inserts item if the key is not already present
        numbers.remove("two");//removes the mapping for the specified key
        numbers.containsKey("two");//checks if the specified key is present in HashMap
        numbers.containsValue(3);//checks if HashMap contains the specified value
        numbers.replace("three",3,4);//replaces the value for the specified key
        numbers.replaceAll((key, value) -> value*2);//replaces all values with
        numbers.get("three");//returns the value using the specified key
        numbers.getOrDefault("four",0);//returns specified default value if key not found
        numbers.forEach((key, value) ->{//performs the action to all entries of HashMap
            value = value * 100;
            System.out.println("key : "+key+" value = "+value);
        });
        numbers.entrySet();//returns a set view of all entries
        //HashMap: {Pant=150, Bag=300, Shoes=200}
        //Set View: [Pant=150, Bag=300, Shoes=200]
        numbers.keySet();//returns a set view of all the keys of HashMap
        numbers.values();//returns a view of all values present in HashMap
        numbers.merge("five", 5, (oldValue, newValue)-> oldValue + newValue);//merges the specified mapping to the HashMaps // five -> 5
        numbers.compute("three", (key, value) -> value - value * 10/100);//computes a new value for the specified key
        numbers.computeIfAbsent("six",key -> 6);//computes value if mapping for key is not present
        numbers.computeIfPresent("one",(key,value) -> value * 10);//computes a value for the mapping if key is present
    }

    public void methodsOfMath() {

        System.out.println(Math.abs(-9.87));//returns the absolute value of a number::::::9.87
        double a = 0.5;
        System.out.println(Math.acos(a));//returns the arc cosine of the specified value:::::::1.0471975511965979
        System.out.println(Math.asin(a));//returns the arc sine of the specified argument:::::::0.5235987755982989
        System.out.println(Math.atan(a));//returns the inverse tangent function of a value:::::::0.4636476090008061

        long b = 123456788;
        long c = 456789678;
        System.out.println(Math.addExact(b, c));//adds the specified numbers and returns it:::::::580246466

        double d = 45;
        d = Math.toRadians(d);//converts angle from degree to radians::::::0.7853981633974483
        System.out.println(Math.cos(d));//returns the cosine of the specified angle::::::0.7071067811865476
        System.out.println(Math.sin(d));//returns the sine of the specified angle in radians::::::0.7071067811865475
        System.out.println(Math.tan(d));//returns the tangent value of the specified angle::::::0.9999999999999999

        double e = 60.0;
        e = Math.toRadians(e);
        System.out.println(Math.sinh(e));//returns the hyperbolic sine of the specified value:::::::1.2493670505239751
        System.out.println(Math.cosh(e));//returns hyperbolic cosine of the specified value:::::::1.600286857702386
        System.out.println(Math.tanh(e));//returns hyperbolic tangent of the specified value:::::::0.7807144353592677

        System.out.println(Math.sqrt(49));//returns the square root of the specified number:::::::7.0
        System.out.println(Math.cbrt(-64));//returns the cube root of the specified number::::::::-4.0
        System.out.println(Math.pow(5,4));//returns first argument raised to power of second:::::::::625.0(5^4)

        System.out.println(Math.subtractExact(b,c));//subtracts the specified numbers and returns it:::::::-333332890

        long f = 7834L;
        long g = 1324L;
        System.out.println(Math.subtractExact(f,g));//multiplies the specified numbers and returns it:::::::6510
        System.out.println(Math.incrementExact(f));//adds 1 to the specified number and returns it::::::::7835
        System.out.println(Math.decrementExact(f));//subtracts 1 from specified number and returns it::::::::7833
        System.out.println(Math.negateExact(g));//negates the specified variable and returns it:::::::::-1324
        System.out.println(Math.toIntExact(g));//returns the int value from specified long argument:::::::1324


        System.out.println(Math.min(21, 43));//returns the smaller value among the arguments:::::::21
        System.out.println(Math.max(897, 573));//returns the maximum value among the arguments::::::897
        double h = 3.24;
        System.out.println(Math.ceil(h));//rounds the specified value upward:::::::::4.0
        System.out.println(Math.floor(h));//rounds the specified value downward and returns it::::::3.0
        System.out.println(Math.round(h));//rounds the specified argument and returns it:::::::::::3
        System.out.println(Math.toDegrees(h));//converts angle from radians to degrees::::::::185.63832562238673


        System.out.println(Math.atan2(e, h));//returns θ converting coordinates (x, y) to (r, θ):::::::::::1.5168487231527341
        float i = -4.5f;
        float j = 7.34f;
        System.out.println(Math.copySign(i,j));//copies the sign of second argument to the first::::::::::4.5
        System.out.println(Math.exp(h));//returns e raised to power of given value::::::::::::::25.533721747351528
        System.out.println(Math.expm1(h));//returns e raised to power of given value minus 1:::::::::::::24.533721747351528
        System.out.println(Math.getExponent(j));//returns the unbiased exponent of specified number::::::::::::2
        System.out.println(Math.hypot(d,e));//computes the hypotenuse of a right-angle triangle::::::::::::::75.0
        System.out.println(Math.IEEEremainder(d,e));//returns the remainder as per the IEEE 754 standard::::::::::-15.0


        System.out.println(Math.log(10.0));//returns the natural logarithm of specified value:::::::::::2.302585092994046
        System.out.println(Math.log10(9.0));//returns the base 10 logarithm of specified value:::::::::::0.9542425094393249
        System.out.println(Math.log1p(9.0));//returns natural logarithm of (specified value + 1)::::::::::2.302585092994046
        System.out.println(Math.nextAfter(i,j));//returns number adjacent to specified number:::::::::::::-4.4999995
        System.out.println(Math.nextUp(j));//returns number greater than and adjacent to value:::::::::::::7.3400006
        System.out.println(Math.nextDown(j));//returns number less than and adjacent to the value:::::::::::7.3399997
        System.out.println(Math.rint(1.878));//returns closest mathematical integer of the value::::::::::::::::2.0
        System.out.println(Math.random());//returns a random value between 0.0 and 1.0:::::::::::::0.7173383826266911

    }

    public void methodsOfObject() {
        Object obj1 = new Object();
        System.out.println("Class of obj1 : "+obj1.getClass());//returns the class name of the object::::::Class of obj1 : class java.lang.Object
        System.out.println(obj1.hashCode());//returns the hashcode value of the object::::::::::498931366
        System.out.println(obj1.toString());//converts an object into the string::::::::::java.lang.Object@1dbd16a6

/*
        Note: The hash code value is an integer value associated with each object. It is used to identify the location of objects in the hash table.
*/
        ArrayList<Integer> obj2 = new ArrayList<>();
        System.out.println("Class of obj2 : "+obj2.getClass());//:::::::::Class of obj2 : class java.util.ArrayList

        Object obj3 = obj1;
        System.out.println(obj1.equals(obj3));//checks if two objects are equal:::::::::::true

    }

}
