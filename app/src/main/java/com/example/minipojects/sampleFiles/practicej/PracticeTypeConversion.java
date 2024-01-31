package com.example.minipojects.sampleFiles.practicej;

import java.util.Arrays;

public class PracticeTypeConversion {
    public static void main(String[] args) {
        PracticeTypeConversion practiceTypeConversion = new PracticeTypeConversion();

        practiceTypeConversion.charToString('r');
    }


    public void charToString(char ch) {
        String s = Character.toString(ch);
        System.out.println("Char to string is "+s+ " alternatively "+String.valueOf(ch));
    }

    public void charArrayToString() {
        char[] ch = {'a','r','r','a','y'};
        System.out.println(String.valueOf(ch)+" alternatively "+new String(ch));//array alternatively array
    }

    public void stringToCharArray() {
        String s = "String to char array";
        char[] ch = s.toCharArray();
        System.out.println(Arrays.toString(ch));//[S, t, r, i, n, g,  , t, o,  , c, h, a, r,  , a, r, r, a, y]
    }

    public void charToInt() {
        char a = '2';
        char b = 'd';
        int n1= a;
        int n2 = b;
        System.out.println("n1 :"+n1+" n2: "+n2);//n1 :50 n2: 100
        System.out.println("value of a : "+Character.valueOf(a)+" b : "+Character.valueOf(b));//value of a : 2 b : d
        System.out.println("a: "+Integer.parseInt(String.valueOf(a)));//a: 2
        System.out.println(" b: "+Integer.parseInt(String.valueOf(b)));//Exception in thread "main" java.lang.NumberFormatException: For input string: "d"
        int k1 = a -'0';
        int k2 = b -'0';
        System.out.println("k1: "+k1+" k2: "+k2);//k1: 2 k2: 52
    }

    public void intToChar() {
        int n1 = 77;
        int n2 = 22;
        char a = (char) n1;
        char b = (char) n2;
        System.out.println("a: "+a+" b: "+b);//a: M b: . //44-> ,
        int num1 = 1;
        int num2 = 14;
        char numA = Character.forDigit(num1, 10); //radix = 10 if num1 is in b/n 0 to 9
        char numB = Character.forDigit(num2, 16); //radix = 16 if num1 is in b/n 0 to 15
        System.out.println("numA : "+numA+" numB : "+numB);//numA : 1 numB : e
        System.out.println("values "+(char)(num1+'0')+ " -- "+(char)(num2+'0'));//values 1 -- >
    }

    public void longToInt() {
        long a = 232222L;
        int b = (int) a;
        System.out.println("long to int "+b);//long to int 232222
        long c = -4456677L;
        int d = Math.toIntExact(c);
        System.out.println(d);//-4456677
        Long e = 24234687L;
        int f = e.intValue();
        System.out.println("long object value "+f);//long object value 24234687
    }

    public void intToLong() {
        int a = 25, b = 244;
        long c = a;
        Long obj = Long.valueOf(b);
        System.out.println("c: "+c +" obj: "+obj);//c: 25 obj: 244
    }

    public void booleanToString() {
        boolean b = true, b2 = false;
        String bs = String.valueOf(b);
        String bb2 = Boolean.toString(b2);
        System.out.println("using - string "+bs+" boolean "+bb2);//using - string true boolean false
    }

    public void stringToBoolean() {
        String s1 = "true", s2 = "false";
        boolean b1 = Boolean.parseBoolean(s1);
        boolean b2 = Boolean.valueOf(s2);// ~= boolean b2 = Boolean obj = Boolean.valueOf(s2);
        System.out.println("Str to boolean "+b1 +"=="+b2);//Str to boolean true==false
    }

    public void stringToInt() {//int a = Integer i = Integer.valueOf("jj");
        String s1 = "23", s2 = "hello";
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);//Exception in thread "main" java.lang.NumberFormatException: For input string: "hello"
        System.out.println(n1+"---"+Integer.valueOf(s1));//23---23
        System.out.println("---"+Integer.valueOf(s2));//Exception in thread "main" java.lang.NumberFormatException: For input string: "hello"
    }

    public void intToString() {
        int n1 = 44, n2 = 88, n3 = 6758, n4 = 9999;
        String s1 = String.valueOf(n1);
        String s2 = Integer.toString(n2);
        String s3 = " "+n3;
        String s4 = String.format("%d", n4);
        System.out.println(s1+"---"+s2+"---"+s3+"---"+s4);//44---88--- 6758---9999
    }

    public void intToDouble() {
        int a = 55, b = 112;
        double d1 = a;
        Double obj = Double.valueOf(b);
        System.out.println(d1+"---"+obj);//55.0---112.0
    }

    public void doubleToInt() {
        double d1 = 23.34D, d2 = 78.33D;
        Double obj = 86.1;
        int n1 = (int) d1;
        int n2 = (int) Math.round(d2);
        int n3 = obj.intValue();
        System.out.println(n1+"---"+n2+"---"+n3);//23---78---86
    }

    public void stringToDouble() { //double a = Double d = Double.valueOf("11");
        String s1 = "89", s2 = "bye", s3 = "251435", s4 = "679,54";
        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);//Exception in thread "main" java.lang.NumberFormatException: For input string: "bye"
        double d3 = Double.valueOf(s3);
        s4 = s4.replace(",",".");
        double d4 = Double.parseDouble(s4);
        System.out.println(d1+"---"+d3+"---"+d4);//89.0---251435.0---679.54
    }

    public void doubleToString() {
        double d1 = 55.66, d2 = 999.99, d3 = 546.89D;
        String s1 = String.valueOf(d1);
        String s2 = Double.toString(d2);
        String s3 = ""+d3;
        String s4 = String.format("%f", d1);
        System.out.println(s1+"---"+s2+"---"+s3+"---"+s4);//55.66---999.99---546.89---55.660000
    }

    public void primitiveToObjects() {
        int i = 10;
        double d = 7.95;
        boolean b = true;
        //converts into wrapper objects
        Integer i1 = Integer.valueOf(i);
        Double d1 = Double.valueOf(d);
        Boolean b1 = Boolean.valueOf(b);

        if (i1 instanceof Integer) {
            System.out.println("An object of integer is created");//An object of integer is created
        }
        if (d1 instanceof Double) {
            System.out.println("An object of double is created");//An object of double is created
        }
        if (b1 instanceof Boolean) {
            System.out.println("An object of boolean is created");//An object of boolean is created
        }

        //method-2
        Integer i2 = Integer.valueOf(77);
        Double d2 = Double.valueOf(9.99);
        Boolean b2 = Boolean.valueOf(false);
        int val1 = i2.intValue();
        double val2 = d2.doubleValue();
        boolean val3 = b2.booleanValue();
        System.out.println("val1 :"+val1+" val2:"+val2+" val3:"+val3);//val1 :77 val2:9.99 val3:false
    }
}
