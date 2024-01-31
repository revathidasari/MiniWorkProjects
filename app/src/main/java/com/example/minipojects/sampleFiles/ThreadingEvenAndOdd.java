package com.example.minipojects.sampleFiles;

import androidx.annotation.NonNull;

import java.util.LinkedList;

public class ThreadingEvenAndOdd {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello, World!");

        final EvenAndOdd evenOdd = new EvenAndOdd();
        MyThread evenMyThread = new MyThread(evenOdd, "even");
        MyThread oddMyThread = new MyThread(evenOdd,"odd");
        evenMyThread.start();
        oddMyThread.start();
        evenMyThread.join();
        oddMyThread.join();

        ProductionConsumption productionConsumption = new ProductionConsumption();

        //Production thread
        Thread productionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    productionConsumption.production();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        //Consumption thread
        Thread consumptionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    productionConsumption.consumption();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        productionThread.start();
        consumptionThread.start();

        productionThread.join();
        consumptionThread.join();

    }


    public static class ProductionConsumption {
        LinkedList<Integer> list = new LinkedList<>();
        int totalCapacity = 5;

        public void production() throws InterruptedException {
            int currentValue = 0;
            while(currentValue <= totalCapacity){ //executes till reaches total capacity
                synchronized(this) {
                    while(list.size() == 1) //executes only one item at a time so given 1
                        wait();
                    System.out.println("Production value "+currentValue);
                    list.add(currentValue++);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

        public void consumption() throws InterruptedException {
            while(true){
                synchronized(this) {
                    while(list.size() == 0)
                        wait();
                    int removeValue = list.removeFirst();
                    System.out.println("Consumption value "+removeValue);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }

    public static class EvenAndOdd {
        int N = 10;
        int counter = 0;
        void even() throws InterruptedException {
            synchronized (this) {
                while (counter < N) {
                    while (counter%2 ==1)
                        wait();
                    System.out.println("Even "+counter);
                    counter++;
                    notify();
                }
            }
        }
        void odd() throws InterruptedException {
            synchronized (this){
                while (counter < N) {
                    while (counter%2 ==0)
                        wait();
                    System.out.println("odd"+counter);
                    counter++;
                    notify();
                }
            }
        }
    }
}

class MyThread extends Thread {
    String name;
    ThreadingEvenAndOdd.EvenAndOdd evenAndOdd;

    public String getThreadName() {
        return name;
    }
    public MyThread(ThreadingEvenAndOdd.EvenAndOdd evenAndOdd, String name) {
        this.evenAndOdd = evenAndOdd;
        this.name = name;
    }

    @Override
    public void run() {
        if (this.getThreadName().equals("even")) {
            try {
                this.evenAndOdd.even();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        } else {
            try {
                this.evenAndOdd.odd();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

/////////////////////////////////////////////////
/*output -
Hello, World!
Production value 0
Consumption value 0
Production value 1
Consumption value 1
Production value 2
Consumption value 2
Production value 3
Consumption value 3
Production value 4
Consumption value 4
Production value 5
Consumption value 5*/