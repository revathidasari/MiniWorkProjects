package com.example.minipojects.sampleFiles.practicej;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Practicing9 {
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public enum TextStyle {
        BOLD, ITALICS, UNDERLINE, STRIKETHROUGH
    }
    enum Size {
        SMALL, MEDIUM, LARGE, EXTRALARGE
    }
    public static void main(String[] args) {
        /*Lookup enum by String value*/
        String style = "Bold";
        TextStyle textStyle = TextStyle.valueOf(style.toUpperCase());
        System.out.println(textStyle);//BOLD

        /*Loop through enum*/
        System.out.println("Access each enum constants");//Access each enum constants
        for (Size size : Size.values()) {
            System.out.print(size+", ");//SMALL, MEDIUM, LARGE, EXTRALARGE,
        }
        //method-2
        EnumSet<Size> enumSet = EnumSet.allOf(Size.class);
        System.out.println("Elements of enum set");//Elements of enum set
        for (Size constant : enumSet) {
            System.out.print(constant+", ");//SMALL, MEDIUM, LARGE, EXTRALARGE,
        }

        /*call to private members of AccessVariablesTest class*/
        AccessVariablesTest accessVariablesTest = new AccessVariablesTest();
        accessVariablesTest.setAge(26);
        accessVariablesTest.setName("Revathi");
        System.out.println("Age : "+accessVariablesTest.getAge());//Age : 26
        System.out.println("Name : "+accessVariablesTest.getName());//Name : Revathi
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void getCurrentDateAndTime() {
        LocalDateTime current = LocalDateTime.now();
        System.out.println("Current Date and Time is : "+current);//Current Date and Time is : 2023-04-07T19:04:57.659629
        //method-2
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formated = current.format(formatter);
        System.out.println("Current Date and time by using DateTimeFormatter : "+formated);//Current Date and time by using DateTimeFormatter : 2023-04-07 19:04:57.659
        //method-3
        DateTimeFormatter formatterByISO = DateTimeFormatter.BASIC_ISO_DATE;
        String isoFormatter = current.format(formatterByISO);
        System.out.println("Current Date and Time by using DateTimeFormatter with BASIC-ISO : "+isoFormatter);//Current Date and Time by using DateTimeFormatter with BASIC-ISO : 20230407
        //method-4
        DateTimeFormatter localFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String mediumFormated = current.format(localFormatter);
        System.out.println("Current Date and Time by using localized "+mediumFormated);//Current Date and Time by using localized Apr 7, 2023, 7:04:57 PM
    }

    public void convertMilliSecsToMinsAndSecs() {
        long milliSeconds = 1000000;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliSeconds);
        System.out.println(milliSeconds+" Milliseconds = "+seconds+" Seconds");//1000000 Milliseconds = 1000 Seconds
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliSeconds);
        System.out.println(milliSeconds+" Milliseconds = "+minutes+" Minutes");////000000 Milliseconds = 16 Minutes
        //method-2
        long secs = (milliSeconds / 1000);
        long mins = (milliSeconds / 1000) /60;
        System.out.println(milliSeconds + " Milliseconds = "+secs+" in Seconds "+mins+" in Minutes");//1000000 Milliseconds = 1000 in Seconds 16 in Minutes
    }

    public void addTwoDates() {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Calendar cTotal = (Calendar) c1.clone();

        cTotal.add(Calendar.YEAR, c2.get(Calendar.YEAR));
        cTotal.add(Calendar.MONTH, c2.get(Calendar.MONTH) + 1);/*Zero based months*/
        cTotal.add(Calendar.DATE, c2.get(Calendar.DATE));
        cTotal.add(Calendar.HOUR_OF_DAY, c2.get(Calendar.HOUR_OF_DAY));
        cTotal.add(Calendar.MINUTE, c2.get(Calendar.MINUTE));
        cTotal.add(Calendar.SECOND, c2.get(Calendar.SECOND));
        cTotal.add(Calendar.MILLISECOND, c2.get(Calendar.MILLISECOND));
        System.out.format("%s + %s = %s", c1.getTime(), c2.getTime(), cTotal.getTime());//Fri Apr 07 18:59:20 UTC 2023 + Fri Apr 07 18:59:20 UTC 2023 = Wed Aug 15 13:58:41 UTC 4046
    }

    public void convertByteArrayToHexaDecimal(){
        byte[] bytes = {10, 2, 15, 11};
        for (byte b : bytes) {
            String s = String.format("%02X", b);
            System.out.print(s);//0A020F0B
        }
        //method-2
        String s1 = bytesToHex(bytes);
        System.out.println(s1);//0A020F0B
    }
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int k = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[k >>> 4];
            hexChars[j * 2 + 1] = hexArray[k & 0x0F];
        }
        return new String(hexChars);
    }

    public void calculateSimpleInterest() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the principal : ");//Enter the principal : 1000
        double principal = input.nextDouble();
        System.out.print("Enter the rate : ");//Enter the rate : 8
        double rate = input.nextDouble();
        System.out.print("Enter the time : ");//Enter the time : 2
        double time = input.nextDouble();
        double interest = (principal * time * rate) / 100;
        System.out.println("Principal : "+principal);//Principal : 1000.0
        System.out.println("Interest rate : "+rate);//Interest rate : 8.0
        System.out.println("Time Duration : "+time);//Time Duration : 2.0
        System.out.println("Simple Interest : "+interest);//Simple Interest : 160.0
        input.close();
    }

    public void calculateCompundInterest() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the principal : ");//Enter the principal : 1000
        double principal = input.nextDouble();
        System.out.print("Enter the rate : ");//Enter the rate : 10
        double rate = input.nextDouble();
        System.out.print("Enter the time : ");//Enter the time : 3
        double time = input.nextDouble();
        System.out.print("Enter number of times interest is compounded : ");//Enter number of times interest is compounded : 1
        int number = input.nextInt();

        double interest = principal * (Math.pow((1 + rate/100), (time * number))) - principal;
        System.out.println("Principal : "+principal);//Principal : 1000.0
        System.out.println("Interest rate : "+rate);//Interest rate : 10.0
        System.out.println("Time Duration : "+time);//Time Duration : 3.0
        System.out.println("Number of times interest is compounded : "+number);//Number of times interest is compounded : 1
        System.out.println("Compound Interest : "+interest);//Compound Interest : 331.00000000000045
        input.close();
    }

    public void nameAndVersionOfOperatingSystem() {
        String operatingSystem = System.getProperty("os.name");
        System.out.println(operatingSystem);//Linux
    }

    public void check2Or3BooleanVariablesAreTrue() {
        boolean first;
        boolean second;
        boolean third;
        boolean result;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first boolean value");//Enter first boolean value true
        first = input.nextBoolean();
        System.out.println("Enter second boolean value");//Enter second boolean value false|true
        second = input.nextBoolean();
        System.out.println("Enter third boolean value");//Enter third boolean value false
        third = input.nextBoolean();
        if (first) {
            result = second || third;
        } else {
            result = second && third;
        }
        if (result)
            System.out.println("Two boolean variables are true");//Two boolean variables are true
        else
            System.out.println("Two boolean variables are not true");//Two boolean variables are not true
        input.close();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void checkBirthdayAndPrintMsg() {
        int birthDate = 14;
        Month birthMonth = Month.OCTOBER;
        LocalDate currentDate = LocalDate.now();
        System.out.println("Todays date : "+currentDate);//Todays date : 2023-04-08
        int date = currentDate.getDayOfMonth();
        Month month = currentDate.getMonth();
        if (date == birthDate && month == birthMonth)
            System.out.println("Happy Birthday to you!!!");
        else
            System.out.println("Today is not my birthday.");//Today is not my birthday.
    }

}

//Implement multiple inheritance
interface Backend {
    public void connectServer();
}
class Frontend {
    public void responsive(String s) {
        System.out.println(s + "can also be used as frontend");
    }
}
class Language extends Frontend implements Backend {
    String language = "Java";
    public void connectServer() {
        System.out.println(language+" can be used as backend language");
    }

    public static void main(String[] args) {
        Language java = new Language();
        java.connectServer();//Java can be used as backend language.
        java.responsive(java.language);//Java can also be used as frontend.
    }
    /*
    * SuperInterface(Backend)           SuperClass(Frontend)
    *           ^                                 ^
    *           |                                 |
    *           ----------------------------------
    *                            |
    *                     SubClass(Language)
    * */
}

/*Access private members of a class*/
class AccessVariablesTest {
    private int age;
    private String name;
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}