package com.example.minipojects.sampleFiles;

import java.util.LinkedList;

public class ProduceConsumeByThread {
 public static void main(String[] args) {
     final ProduceConsume produceConsume = new ProduceConsume();

     Thread produceThread = new Thread(new Runnable() {
         @Override
         public void run() {
             try {
                 produceConsume.produce();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     });

     Thread consumeThread = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
                produceConsume.consume();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
         }
     });

     try {
         produceThread.start();
         consumeThread.start();

         //produceThread finishes before consumeThread
         produceThread.join();
         consumeThread.join();
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

    public static class ProduceConsume {
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;

        public void produce() throws InterruptedException {
             int value = 0;
             while (true) {
             synchronized (this) {
                 while (list.size() == capacity)
                     wait();
                 System.out.println("production value " + value);
                 list.add(value++);
                 notify();
                 Thread.sleep(1000);
             }
             }
        }

        public void consume() throws InterruptedException {
             while (true){
             synchronized (this){
                 while (list.size()==0)
                     wait();
                 int val = list.removeFirst();
                 System.out.println("Consumption value "+val);
                 notify();
                 Thread.sleep(1000);
             }
             }
        }

    }
}


