package com.example.minipojects.sampleFiles.practicej;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructorCallsSample {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {

        ConstructorCallsSample constructorCallsSample = new ConstructorCallsSample();
        //passing method as argument
        constructorCallsSample.square(constructorCallsSample.add(15,9));
        //calculate method execution time
        long start = System.nanoTime();
        constructorCallsSample.display();
        long end = System.nanoTime();
        long executionTime = end - start;
        System.out.println("Execution time: "+executionTime+ " nanoseconds");//Execution time: 64309 nanoseconds


        ArrayList<String> languages = new ArrayList<>();
        languages.add("c");
        languages.add("java");
        languages.add("python");
        System.out.println("Arraylist : "+languages);//ArrayList: [java, swift, python]
        //lambda expression as method parameter
        languages.replaceAll(e -> e.toUpperCase());
        System.out.println("Updated arraylist : "+languages);//Updated arrayList: [JAVA, SWIFT, PYTHON]

        ArrayList<String> subjects = new ArrayList<>(Arrays.asList("english", "maths","science"));
        System.out.println("Arraylist : "+subjects);//ArrayList: [english, maths, science]
        //pass multiline lambda body as function arguments
        System.out.println("Reversed arraylist : ");
        subjects.forEach((e) ->{
            String res = "";
            for (int i = e.length()-1; i >= 0; i--) {
                res += e.charAt(i);
            }
            System.out.print(res);//hsilgne,shtam,ecneics,
        });
    }


    public int add(int a, int b) {
        return a+b;
    }
    public void square(int n) {
        int res = n * n;
        System.out.println(res);//576
    }
    public void display() {
        System.out.println("calculating method execution time:");
    }
}

//call from constructor 2 to constructor 1
class Main {
    int sum;
    Main() {
        this(1,11);
    }
    Main(int a, int b) {
        this.sum = a + b;
    }
    void display() {
        System.out.println("Sum is "+sum);//Sum is: 7
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.display();
    }
}

//call from constructor 2 to constructor 1
class Languages {
    Languages(int version1, int version2){
        if (version1 > version2)
            System.out.println("Latest version is "+version1);
        else
            System.out.println("Latest version is "+version2);
    }
}
class LanguageVersion extends Languages {
    LanguageVersion() {
        super(14, 7);
    }

    public static void main(String[] args) {
        LanguageVersion languageVersion = new LanguageVersion();//The latest version is: 14
    }
}

//private constructor
class Test{
    private Test() {
        System.out.println("This is a private constructor");
    }
    public static void instanceMethod() {
       Test test = new Test();
    }
}
class TestMain {
    public static void main(String[] args) {
        Test.instanceMethod();//This is a private constructor.
    }
}

//singleton design using a private constructor
class Subject {
    private static Subject subject;
    private Subject() {
        System.out.println("Inside private constructor");
    }
    public static Subject getInstance() {
        if (subject == null)
            subject = new Subject();
        return subject;
    }
    public void display() {
        System.out.println("Singleton pattern is achieved");
    }
}
class SubjectMain {
    public static void main(String[] args) {
        Subject db;
        db = Subject.getInstance();
        db.display();//Inside Private Constructor Singleton Pattern is achieved
    }
}

/*Java Object clone()
creates a copy of the object*/
class MainClone implements Cloneable {
    String name;
    int version;

    public static void main(String[] args) {
        MainClone obj1 = new MainClone();
        obj1.name = "Java";
        obj1.version = 14;
        System.out.println(obj1.name+"---"+obj1.version);//Java---14
        try {
            MainClone obj2 = (MainClone) obj1.clone();
            System.out.println("cloned : "+obj2.name+"----"+obj2.version);//cloned : Java----14
            obj2.name = "python";
            System.out.println("obj2 name : "+obj2.name);//obj2 name : python
            System.out.println("obj1 name : "+obj1.name);//obj1 name : Java
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}