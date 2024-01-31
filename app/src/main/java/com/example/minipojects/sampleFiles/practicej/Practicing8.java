package com.example.minipojects.sampleFiles.practicej;

import android.os.Build;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Files and I/OStream
public class Practicing8 {
    public static void main(String[] args) {


    }

    public void getCurrentDirectory() {
        //get current directory
        String path = System.getProperty("user.dir");
        System.out.println("Working directory : "+path);//Working directory : /run
        //method-2
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String currentPath = Paths.get("").toAbsolutePath().toString();
            System.out.println("Current path directory : "+currentPath);//Current path directory : /run
        }
    }

    public String getFilePath() {
        String path = System.getProperty("user.dir")+"\\src\\test.txt";
        return path;
    }
    public void createStringFromFile() {
        String path = getFilePath();
        Charset encoding = Charset.defaultCharset();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(path), encoding);
                System.out.println(lines);//[This is a, Test file.]
                //method-2
                byte[] encoded = Files.readAllBytes(Paths.get(path));
                String encodedLines = new String(encoded, encoding);
                System.out.println(encodedLines);//This is a Test file.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void appendTextToFile() {
        String path = getFilePath();
        String text = "Added text";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                Files.write(Paths.get(path),text.getBytes(), StandardOpenOption.APPEND);
                //This is a
                //Test file.Added text
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //method-2
        try {
            FileWriter fw = new FileWriter(path, true);
            fw.write(text);
            fw.close();
            //This is a
            //Test file.Added text
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convertFileToByteArray() {
        String path = getFilePath();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                byte[] encoded = Files.readAllBytes(Paths.get(path));
                System.out.println(Arrays.toString(encoded));//[84, 104, 105, 115, 32, 105, 115, 32, 97, 13, 10, 84, 101, 115, 116, 32, 102, 105, 108, 101, 46]
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void convertByteArrayToFile() {
        String path = getFilePath();
        String finalPath = System.getProperty("user.dir")+"\\src\\final.txt";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                byte[] encoded = Files.readAllBytes(Paths.get(path));
                Files.write(Paths.get(finalPath), encoded);//This is a \nTest file.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createFile() {
        File file = new File("JavaFile.java");
        try {
            boolean value = file.createNewFile();
            if(value) {
                System.out.println("New java file is created");
            } else {
                System.out.println("The file already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeContentToFile() {
        String program = "class JavaFile { " +
                "public static void main(String[] args) { " +
                "System.out.println(\"This is file\");" +
                "}" +
                "}";
        try {
            FileWriter output = new FileWriter("JavaFile.java");
            output.write(program);
            System.out.println("Data is written to the File");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            //method-1 : UsingBufferedInputStream
            FileInputStream fileInputStream = new FileInputStream("input.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            int i = bufferedInputStream.read();
            while (i != 1) {
                System.out.print((char) i);
                //First Line
                //Second Line
                //Third Line
                //Fourth Line
                //Fifth Line
                i = bufferedInputStream.read();
            }
            bufferedInputStream.close();
            //method-2 : UsingBufferedReader
                char[] array = new char[100];
                FileReader fileReader = new FileReader("input.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                bufferedReader.read(array);
                System.out.println("Data in the file:");
                System.out.println(array);
                bufferedReader.close();
                //Data in the file:
                //First Line
                //Second Line
                //Third Line
                //Fourth Line
                //Fifth Line
            //method-3 : Using Scanner
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            System.out.println("reading file using scanner");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
            //Reading File Using Scanner:
            //First Line
            //Second Line
            //Third Line
            //Fourth Line
            //Fifth Line
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile() {
        File file = new File("JavaFile.java");
        boolean value = file.delete();
        boolean isFileDeleted = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Path path = Paths.get("JavaFile.java");
            try {
                isFileDeleted = Files.deleteIfExists(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (value || isFileDeleted)
            System.out.println("JavaFile.java is successfully deleted");
        else
            System.out.println("File doesn't exist");
    }

    public void deleteDirectory() {
        File directory = new File("Directory");
        boolean result = directory.delete();
        //method-2
        File directory1 = new File("Directory1");
        File[] files = directory1.listFiles();
        for (File file : files) {
            System.out.println(file + "deleted");
            file.delete();
        }
        //method-3
        File directory2 = new File("Directory2");
        deleteDir(directory2);
        if (result || directory1.delete())
            System.out.println("Directory deleted");
        else
            System.out.println("Directory not found");
    }

    public static void deleteDir(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file: files) {
                    //if sub directory is non-empty
                    deleteDir(file);
                }
            }
        }
        //Directory\file1.txt is deleted
        //Directory\file2.txt is deleted
        //Directory\Subdirectory\file11.txt is deleted
        //Directory\Subdirectory is deleted
        //Directory is deleted
        if (directory.delete())
            System.out.println(directory+" is deleted");
        else
            System.out.println("directory is not deleted");
    }

    public void getFileExtension() {
        File file = new File("Test.java");
        String fileName = file.toString();
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            String extension = fileName.substring(index + 1);
            System.out.println("File extension is "+extension);
        }
        //method-2
        File directory = new File("Directory");
        File[] files = directory.listFiles();
        System.out.println("Files\t\t\tExtension");
        for (File f : files) {
            String fName = f.toString();
            int i = fName.lastIndexOf('.');
            if (i > 0) {
                String exe = fName.substring(i + 1);
                System.out.println(fName+"\t"+exe);
            }
        }
        //Files                   Extension
        //Directory\file1.txt     txt
        //Directory\file2.svg     svg
        //Directory\file3.java    java
        //Directory\file4.py      py
        //Directory\file5.html    html
    }

    public void getFileName() {
        File file = new File("C:\\Users\\A\\Desktop\\Programs\\Java\\Test.class");
        String fileName = file.getName();
        System.out.println("File name : "+fileName);//File Name: Test.class
        //method-2
        String name = file.toString();
        int index = name.lastIndexOf('\\');
        if (index > 0) {
            String s = name.substring(index + 1);
            System.out.println("File name : "+s);//File Name: Test.class
        }
    }

    public void getRelativePathFrom2AbsolutePaths() {
        File file1 = new File("C:\\Users\\A\\Desktop\\Programs\\Java\\Test.java");
        System.out.println("Absolute path 1 "+file1);//Absolute Path1: C:\Users\A\Desktop\Programs\Java\Time.java
        File file2 = new File("C:\\Users\\A\\Desktop");
        System.out.println("Absolute path 2 "+file2);//Absolute Path2: C:\Users\A\Desktop
        URI uripath1 = file1.toURI();
        URI uripath2 = file2.toURI();
        URI relativePath = uripath2.relativize(uripath1);
        String path = relativePath.getPath();
        System.out.println("Relative path : "+path);//Relative Path: Programs/Java/Time.java
        //method-2
        String stringPath1 = file1.toString();
        System.out.println("Absolute path 1 : "+stringPath1);//Absolute Path1: C:\Users\A\Desktop\Programs\Java\Time.java
        String stringPath2 = file2.toString();
        System.out.println("Absolute path 2 : "+stringPath2);//Absolute Path2: C:\Users\A\Desktop
        String relative = stringPath1.substring(stringPath2.length());
        System.out.println("Absolute path : "+relative);//Absolute path : \Programs\Java\Time.java
        //method-3
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Path p1 = Paths.get("C:\\Users\\A\\Desktop\\Programs\\Java\\Test.java");
            Path p2 = Paths.get("C:\\Users\\A\\Desktop");
            Path p = p2.relativize(p1);
            System.out.println("Relativize : "+p);//Relativize : Programs\Java\Time.java
        }
    }

    public void numberOfLinesInFile() {
        int count = 0;
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            System.out.println("Total  number of lines : " + count);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void convertInputStreamToString() {
        InputStream inputStream = new ByteArrayInputStream("Hello Revathi!".getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder);//Hello Revathi!
    }

    public void convertOutputStreamToString() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        String line = "Hi Revathi";
        try {
            stream.write(line.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String string = new String(stream.toByteArray());
        System.out.println(string);//Hi Revathi
    }

    public void convertStringToInputStream() {
        String name = "revathi";
        System.out.println("String is "+name);//String is revathi
        try {
            InputStream inputStream = new ByteArrayInputStream(name.getBytes(StandardCharsets.UTF_8));
            System.out.println("InputStream : "+inputStream);//InputStream : java.io.ByteArrayInputStream@19469ea2
            System.out.println("Available bytes at the beginning : "+inputStream.available());//Available bytes at the beginning : 7
            inputStream.read();
            inputStream.read();
            inputStream.read();
            System.out.println("Available bytes at the end : "+inputStream.available());//Available bytes at the end : 4
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convertInputStreamToByteArray() {
        try {
        byte[] input = {1, 2, 3, 4};
        InputStream stream = new ByteArrayInputStream(input);
        System.out.println("Input Stream : " + stream);//Input Stream : java.io.ByteArrayInputStream@19469ea2

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] array = new byte[4];
        int i;
        while ((i = stream.read(array, 0, array.length)) != -1) {
            outputStream.write(array, 0, i);
        }
        byte[] data = outputStream.toByteArray();
        System.out.println("Byte array : "+Arrays.toString(data));//Byte array : [1, 2, 3, 4]
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFileAsInputStream() {
        try {
            InputStream inputStream = new FileInputStream("input.txt");/*TestFileRead.java*/
            System.out.println("Data in the file : ");//Data in the file:
            int i = inputStream.read();
            while (i != 1) {
                System.out.print((char) i);//This is a content of the file input.txt.
                i = inputStream.read();
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();//java.io.FileNotFoundException: input.txt (No such file or directory)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class TestFileRead {
    public static void main(String[] args) {
        System.out.println("This is a java file");
    }
    //Data in the file:
    //class Test {
    //  public static void main(String[] args) {
    //    System.out.println("This is Java File");
    //  }
    //}
}