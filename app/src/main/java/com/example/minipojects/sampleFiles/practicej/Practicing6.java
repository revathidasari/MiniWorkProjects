package com.example.minipojects.sampleFiles.practicej;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Collections
public class Practicing6 {


    public static void main(String[] args) {

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void join2Lists() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        List<String> list2 = new ArrayList<>();
        list2.add("b");
        List<String> join = new ArrayList<>();
        join.addAll(list1);
        join.addAll(list2);
        System.out.println("list1 : "+list1+" list2 : "+list2+" join : "+join);//list1 : [a] list2 : [b] join : [a, b]

        //method-2
        List<String> join1 = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println("list1 : "+list1+" list2 : "+list2+" join1 : "+join1);//list1 : [a] list2 : [b] join1 : [a, b]
    }

    public void convertListToArray() {
        ArrayList languages = new ArrayList<>();
        languages.add("c");
        languages.add("c++");
        languages.add("java");
        languages.add("python");
        System.out.println("languages : "+languages);//languages : [c, c++, java, python]
        String[] arr = new String[languages.size()];
        languages.toArray(arr);
        System.out.print("Array : ");
        for (String item : arr) {
            System.out.print(item+",");//Array : c,c++,java,python,
        }
    }

    public void convertArrayToList() {
        String[] arr = {"c", "c++","java","python"};
        System.out.println("Array : "+ Arrays.toString(arr));//Array : [c, c++, java, python]
        List languages = new ArrayList<>(Arrays.asList(arr));
        System.out.println("list : "+languages);//list : [c, c++, java, python]
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void convertMapToList() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        List<Integer> keyList = new ArrayList(map.keySet());
        List<String> valueList = new ArrayList(map.values());
        System.out.println("List of keys : "+keyList+" values : "+valueList);//List of keys : [1, 2, 3, 4] values : [a, b, c, d]
        //method-2
        List<Integer> keyStreamList = map.keySet().stream().collect(Collectors.toList());
        List<String > valueStreamList = map.values().stream().collect(Collectors.toList());
        System.out.println("STreamed list of keys : "+keyStreamList+" values : "+valueStreamList);//STreamed list of keys : [1, 2, 3, 4] values : [a, b, c, d]
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void convertArrayToSet() {
        String[] arr = {"a", "b", "c"};
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        System.out.println("Set : "+set);//Set : [a, b, c]
        //method-2
        Set<String> setStream = new HashSet<>(Arrays.stream(arr).collect(Collectors.toSet()));
        System.out.println("Streamed Set : "+setStream);//Streamed Set : [a, b, c]
    }

    public void convertSetToArray() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        String[] arr = new String[set.size()];
        set.toArray(arr);
        System.out.println("Array : "+Arrays.toString(arr));//Array : [a, b, c]
    }

    public void sortMapByValues() {
        LinkedHashMap<String, String> capitals = new LinkedHashMap<>();
        capitals.put("Nepal","Kathmandu");
        capitals.put("India","New Delhi");
        capitals.put("United States","Washington");
        capitals.put("Australia","Canberra");
        capitals.put("England","London");

        Map<String, String> result = sortMap(capitals);
        for (Map.Entry entry: result.entrySet()) {
            System.out.print("Key: "+entry.getKey());
            System.out.println(" Value: "+entry.getValue());
            //Key: Australia Value: Canberra
            //Key: Nepal Value: Kathmandu
            //Key: England Value: London
            //Key: India Value: New Delhi
            //Key: United States Value: Washington
        }
    }
    static LinkedHashMap sortMap(LinkedHashMap map) {
        List<Map.Entry<String, String>> capitalList = new LinkedList<>(map.entrySet());
        Collections.sort(capitalList, (l1, l2) -> l1.getValue().compareTo(l2.getValue()));
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : capitalList) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public void implementLinkedListUsingLinkedListClass() {
        LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.addFirst("CAT");
        animals.addLast("Monkey");
        System.out.println("LinkedList : "+animals);//LinkedList : [CAT, Dog, Monkey]
        System.out.println("First element "+animals.getFirst());//First element CAT
        System.out.println("Last element "+animals.getLast());//Last element Monkey
        String middleElement = animals.get(animals.size()/2);
        System.out.println("Middle Element : "+middleElement);//Middle Element : Dog
    }

    public void implementingStackUsingStackClass() {
        Stack<String> animals = new Stack<>();
        animals.push("CAT");
        animals.push("DOG");
        animals.push("BAT");
        System.out.println("stack : "+animals);//stack : [CAT, DOG, BAT]
        animals.pop();
        System.out.println("Stack after pop : "+animals);//Stack after pop : [CAT, DOG]
    }

    public void implementingStackUsingQueueInterface() {
        Queue<Integer> numbers = new LinkedList<>();
        numbers.offer(1);
        numbers.offer(2);
        numbers.offer(3);
        System.out.println("Queue : "+numbers);//Queue : [1, 2, 3]
        int removeNumber = numbers.poll();
        System.out.println("Removed element "+removeNumber);//Removed element 1
        System.out.println("Queue after deletion "+numbers);//Queue after deletion [2, 3]
    }

    public LinkedList<String> sampleLinkedList() {
        LinkedList<String> languages = new LinkedList<>();
        languages.add("a");
        languages.add("b");
        languages.add("c");
        System.out.println("languages : "+languages);//languages : [a, b, c]
        return languages;
    }
    public void getAndRemoveElementFromLinkedList() {
        LinkedList<String> languages = sampleLinkedList();//languages : [a, b, c]
        String s = languages.get(1);
        System.out.println("Element at index 1 : "+s);//Element at index 1 : b
        String rmv = languages.remove(2);
        System.out.println("removed element "+rmv);//removed element c
        System.out.println("updated linked list "+languages);//updated linked list [a, b]
        //method-2
        ListIterator<String> listIterate = languages.listIterator();
        listIterate.next();
        listIterate.remove();
        System.out.println("new linkedlist : "+languages);//new linkedlist : [b]
        //method -3
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            languages.removeIf((String i) -> i == "b");
        }
        languages.add("d");
        System.out.println("removed if present "+languages);//]removed if present [d]
        //method-4
        languages.clear();
        System.out.println("linked list after clear () "+languages);//linked list after clear () []
    }
    public LinkedList<String> addElementAtPosition() {
        LinkedList<String> languages = sampleLinkedList();//languages : [a, b, c]
        languages.add(0,"d");
        System.out.println("updated linked list "+languages);//updated linked list [d, a, b, c]
        return languages;
    }
    public LinkedList<String> addElementsFromCollectionForLinkedList() {
        LinkedList<String> animals = new LinkedList<>();
        animals.add("cat");
        animals.add("dog");
        animals.add("goat");
        LinkedList<String> mammals = new LinkedList<>();
        mammals.add("Crocodile");
        animals.addAll(mammals);
        System.out.println("Animals "+animals);//Animals [cat, dog, goat, Crocodile]
        return animals;
    }
    public void iterateLinkedList() {
        LinkedList<String> languages = sampleLinkedList();//languages : [a, b, c]
        Iterator<String> iterator = languages.iterator();
        System.out.println("Linkedlist : ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+", ");//Linkedlist : a, b, c,
        }
        LinkedList<String> animals = addElementsFromCollectionForLinkedList();
        ListIterator<String> listIterator = animals.listIterator();
        //adding element to list iterator
        listIterator.add("horse");
        System.out.println("\n List - Linkedlist : ");// List - Linkedlist :
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next()+", ");//cat, dog, goat, Crocodile,
        }
        System.out.println("\n list - Reverse Linkedlist : ");// list - Reverse Linkedlist :
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous()+", ");//Crocodile, goat, dog, cat, horse,
        }
    }
    public void linkedListToArray() {
        LinkedList<String> languages = sampleLinkedList();//languages : [a, b, c]
        String[] arr = new String[languages.size()];
        languages.toArray(arr);
        System.out.print("Array:");//Array:a,b,c,
        for (String item : arr ){
            System.out.print(item+",");
        }
        //method-2
        String[] array = {"q", "w", "e"};
        System.out.println("Array:"+Arrays.toString(array));//Array:[q, w, e]
        LinkedList<String> ll = new LinkedList<>(Arrays.asList(array));
        System.out.println("Linked list : "+ll);//Linked list : [q, w, e]
    }

    public ArrayList<String> sampleArrayList() {
        ArrayList<String> languages = new ArrayList<>();
        languages.add("c");
        languages.add("c++");
        languages.add("java");
        languages.add("python");
        System.out.println("languages : "+languages);//languages : [c, c++, java, python]
        return languages;
    }
    public void arrayListIteration() {
        ArrayList<String> sampleArrayList = sampleArrayList();//languages : [c, c++, java, python]
        for (int i = 0; i <sampleArrayList.size(); i++) {
            System.out.print(sampleArrayList.get(i));
            System.out.print(", ");//c, c++, java, python,
        }
        //mehod-2
        for (String lan : sampleArrayList) {
            System.out.print(lan);
            System.out.print(", ");// c, c++, java, python,
        }
        //method-3
        ListIterator<String> iterate = sampleArrayList.listIterator();
        while (iterate.hasNext()) {
            System.out.print(iterate.next()+", ");//c, c++, java, python,
        }
    }

    public HashMap<String, String> sampleHashMap() {
        HashMap<String, String> lan = new HashMap<>();
        lan.put("Java", "Enterprise");
        lan.put("Python", "ML/AI");
        lan.put("JavaScript", "FrontEnd");
        System.out.println("HashMap : "+lan);//HashMap : {Java=Enterprise, JavaScript=FrontEnd, Python=ML/AI}
        return lan;
    }
    public HashMap<String, Integer> sampleHashMapWithStringInt() {
        HashMap<String, Integer> num = new HashMap<>();
        num.put("First", 1);
        num.put("Second", 2);
        num.put("Third", 3);
        System.out.println("HashMap : "+num);//HashMap : {Second=2, Third=3, First=1}
        return num;
    }

    public void getHashMapKeyByValue() {
        HashMap<String, Integer> map = sampleHashMapWithStringInt();//HashMap : {Second=2, Third=3, First=1}
        Integer v = 2;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == v) {
                System.out.println("Key of the value "+v + " is "+entry.getKey());//Key of the value 2 is Second
            }
        }
    }
    public void hashMapIteration() {
        HashMap<String, String> map = sampleHashMap();//HashMap : {Java=Enterprise, JavaScript=FrontEnd, Python=ML/AI}
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.print(entry+", ");//Java=Enterprise, JavaScript=FrontEnd, Python=ML/AI,
        }
        System.out.print("\nKeys : ");
        for (String key : map.keySet()) {
            System.out.print(key+", ");//Keys : Java, JavaScript, Python,
        }
        System.out.print("\nValues");
        for (String value : map.values()) {
            System.out.print(value+", ");//Values : Enterprise, FrontEnd, ML/AI, Entries :
        }
        //method-2
        Iterator<Map.Entry<String, String>> iterateEntries = map.entrySet().iterator();
        System.out.println("Entries : ");
        while (iterateEntries.hasNext()) {
            System.out.print(iterateEntries.next()+", ");//Java=Enterprise, JavaScript=FrontEnd, Python=ML/AI, Keys :
        }
        Iterator<String> iterateKeys = map.keySet().iterator();
        System.out.println("Keys : ");
        while (iterateKeys.hasNext()) {
            System.out.print(iterateKeys.next()+", ");//Keys : Java, JavaScript, Python,
        }
        Iterator<String> iterateValues = map.values().iterator();
        System.out.println("Values : ");
        while (iterateValues.hasNext()) {
            System.out.print(iterateValues.next()+", ");//Values : Enterprise, FrontEnd, ML/AI,
        }

    }

    public void arrayListToString() {
        ArrayList<String> sampleArrayList = sampleArrayList();//languages : [c, c++, java, python]
        String arrayList = sampleArrayList.toString();
        System.out.println("String : "+arrayList);//String : [c, c++, java, python]
        //method-2
        String arrayList1 = String.join(",", sampleArrayList);
        System.out.println("String1 : "+arrayList1);//String1 : c,c++,java,python
    }

    public void stringToArrayList() {
        String s = "A, B, CDFJK";
        System.out.println("String is "+s);//String is A, B, CDFJK
        String[] a = s.split(",");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(a));
        System.out.println("Arraylist : "+arrayList);//Arraylist : [A,  B,  CDFJK]
    }

    public Set<String> sampleHashSet() {
        Set<String> languages = new HashSet<>();
        languages.add("C");
        languages.add("C++");
        languages.add("JAVA");
        System.out.println("Set : "+languages);//Set : [JAVA, C++, C]
        return languages;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setIteration() {
        Set<String> languages = sampleHashSet();//Set : [JAVA, C++, C]
        System.out.println("Iterating over set");//Iterating over set
        for (String lan : languages) {
            System.out.print(lan+", ");//JAVA, C++, C,
        }
        //method-2
        Iterator<String> iterator = languages.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+", ");//JAVA, C++, C,
        }
        //method-3
        languages.forEach((e)->{
            System.out.print(e+", ");//JAVA, C++, C,
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void merge2Lists() {
        List<Integer> prime = new ArrayList<>();
        prime.add(2);
        prime.add(3);
        prime.add(5);
        System.out.println("First list : "+prime);//First list : [2, 3, 5]
        List<Integer> even = new ArrayList<>(Arrays.asList(4,6));
        System.out.println("second list : "+even);//second list : [4, 6]
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(prime);
        numbers.addAll(even);
        System.out.println("merged list : "+numbers);//merged list : [2, 3, 5, 4, 6]
        //method-2
        Stream<Integer> list1 = prime.stream();
        Stream<Integer> list2 = even.stream();
        Stream<Integer> merged = Stream.concat(list1, list2);
        List<Integer> integers = merged.collect(Collectors.toList());
        System.out.println("Mergedlist : "+integers);//Mergedlist : [2, 3, 5, 4, 6]
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void updateValueOfHashMap() {
        HashMap<String, Integer>  map = sampleHashMapWithStringInt();//HashMap : {Second=2, Third=3, First=1}
        int value = map.get("Second");
        value = value * value;
        map.put("Second", value);
        System.out.println("HashMap - updated value : "+map);//HashMap - updated value : {Second=4, Third=3, First=1}
        //method-2
        map.computeIfPresent("Second", (key, oldValue) -> oldValue * 3);
        System.out.println("compute if present : "+map);//compute if present : {Second=12, Third=3, First=1}
        //method-3
        map.merge("First",4, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("merged : "+map);//merged : {Second=12, Third=3, First=5}
    }
    public Set<Integer> evenSet() {
        Set<Integer> even = new HashSet<>();
        even.add(2);
        even.add(4);
        System.out.println("Even : "+even);//Even : [2, 4]
        return even;
    }
    public Set<Integer> primeSet() {
        Set<Integer> prime = new HashSet<>();
        prime.add(2);
        prime.add(3);
        System.out.println("Prime : "+prime);//Prime : [2, 3]
        return prime;
    }
    public Set<Integer> numbersSet() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        System.out.println("Numbers : "+numbers);//Numbers : [1, 2, 3, 4]
        return numbers;
    }
    public void unionOfSets() {
        Set<Integer> even = evenSet();//Even : [2, 4]
        Set<Integer> num = new HashSet<>();
        num.add(1);
        num.add(3);
        System.out.println("Set2 : "+num);//Set2 : [1, 3]
        num.addAll(even);
        System.out.println("Union is : "+num);//Union is : [1, 2, 3, 4]
    }
    public void intersectionOfSets() {
        Set<Integer> even = evenSet();//Even : [2, 4]
        Set<Integer> prime = primeSet();//Prime : [2, 3]
        even.retainAll(prime);
        System.out.println("Intersection : "+even);//Intersection : [2]
    }
    public void differenceIn2Sets() {
        Set<Integer> numbers = numbersSet();//Numbers : [1, 2, 3, 4]
        Set<Integer> prime = primeSet();//Prime : [2, 3]
        numbers.removeAll(prime);
        System.out.println("Numbers without prime numbers : "+numbers);//Numbers without prime numbers : [1, 4]
    }
    public void subSetOfASet() {
        Set<Integer> numbers = numbersSet();//Numbers : [1, 2, 3, 4]
        Set<Integer> prime = primeSet();//Prime : [2, 3]
        boolean result = numbers.containsAll(prime);
        System.out.println("Is Prime Numbers subset of numbers? "+result);//Is Prime Numbers subset of numbers? true
    }

    public void sortMapByKeysUsingTreeMap() {
        Map<String, String> languages = new HashMap<>();
        languages.put("pos3", "JS");
        languages.put("pos1", "Java");
        languages.put("pos2", "Python");
        TreeMap<String, String> sortedNumbers = new TreeMap<>(languages);
        System.out.println("Map with sorted key "+sortedNumbers);//Map with sorted key {pos1=Java, pos2=Python, pos3=JS}
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Integer[] convertingArrayListToArray(ArrayList<Integer> arrayList) {
        //to iterate arraylist by using lambda function
        arrayList.forEach((e) ->{
            System.out.print(e+",");
        });
        Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
        return array;
    }
}


//Sort ArrayList of Custom Objects By Property
class CustomObject {

    private String customProperty;
    public CustomObject(String property) {
        this.customProperty = property;
    }
    public String getCustomProperty() {
        return this.customProperty;
    }

    public static void main(String[] args) {
        ArrayList<CustomObject> list = new ArrayList<>();
        list.add(new CustomObject("q"));
        list.add(new CustomObject("AI"));
        list.add(new CustomObject("PO"));
        list.add(new CustomObject("F"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            list.sort((l1, l2) -> l1.getCustomProperty().compareTo(l2.customProperty));
        }
        for (CustomObject obj : list) {
            System.out.println(obj.getCustomProperty());//AI F PO q
        }
    }
}

//Java program to implement LinkedList
class LinkedList1 {
    Node head;
    static class Node {
        int value;
        Node next;
        Node(int d) {
            value = d;
            next = null;
        }
    }
    public boolean checkLoop() {
        Node first = head;
        Node second = head;
        while (first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        LinkedList1 linkedList1 = new LinkedList1();
        linkedList1.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        linkedList1.head.next = second;
        second.next = third;
        System.out.print("Linked list1 : ");
        while (linkedList1.head != null) {
            System.out.println(linkedList1.head.value+" ");//Linked list1 : 1 2 3
            linkedList1.head = linkedList1.head.next;
        }
        //find the middle element
        Node ptr1 = linkedList1.head;
        Node ptr2 = linkedList1.head;
        while (ptr1.next != null) {
            ptr1 = ptr1.next;
            if (ptr1.next != null) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        System.out.println("Middle element : "+ptr2.value);//Middle element : 2
        //make loop in linkedlist
        Node fourth = new Node(4);
        third.next = fourth;
        //as
        fourth.next = second;
        System.out.print("Linked list : ");//LinkedList: 1 2 3 4
        int i = 1;
        while (i <= 4) {
            System.out.print(linkedList1.head.value+" ");
            linkedList1.head = linkedList1.head.next;
            i++;
        }
        boolean loop = linkedList1.checkLoop();
        if (loop) {
            System.out.println("\n There is a loop in the linkedlist1");//There is a loop in linkedList1
        } else {
            System.out.println("\n There is no loop in the linkedlist1");
        }
    }
}

class Stack1 {
    private int arr[];
    private int top;
    private int capacity;
    Stack1(int size){
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack overflow");
            System.exit(1);/*terminates the program*/
        }
        System.out.println("Inserting "+x);//Inserting 1 Inserting 2 Inserting 3
        arr[++top] = x;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return arr[top--];
    }
    public int getSize() { return top + 1; }
    public Boolean isEmpty() {  return top == -1;  }
    public Boolean isFull() { return top == capacity - 1; }
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i]+",");
        }
    }

    public static void main(String[] args) {
        Stack1 stack1 = new Stack1(5);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.print("stack: ");
        stack1.printStack();//stack: 1,2,3,
        stack1.pop();
        System.out.println("After popping out");
        stack1.printStack();//1,2,
    }
}

class Queue1 {
    int SIZE = 5;
    int items[] = new int[SIZE];
    int front, rear;
    Queue1() {
        front = -1;
        rear = -1;
    }
    boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        return false;
    }
    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }
    void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");//Queue is full
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = element;
            System.out.println("Insert "+element);//Insert 1Insert 2 Insert 3 Insert 4 Insert 5
        }
    }
    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");//Queue is empty
            return(-1);
        } else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println(element+" deleted");
            return element;
        }
    }
    void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("\n Front index -> "+front);
            System.out.println("Items -> ");
            for (i = front; i <= rear; i++) {
                System.out.print(items[i]+" ");
            }
            System.out.println("\n Rear index -> "+rear);
        }
    }

    public static void main(String[] args) {
        Queue1 q = new Queue1();
        q.deQueue();
        for (int i = 1; i < 6; i++) {
            q.enqueue(i);
        }
        q.enqueue(6);
        q.display();//Front index -> 0
        //Items -> 1 2 3 4 5
        //Rear index -> 4
        //1 deleted
        q.deQueue();
        q.display();
        // Front index -> 1
        //Items ->
        //        2 3 4 5
        //Rear index -> 4
    }
}

class BinaryTree {
    Node root;
    static class Node {
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    public void traverseTree(Node node) {
        if (node != null) {
            traverseTree(node.left);
            System.out.print(" "+node.key);
            traverseTree(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        System.out.print("\n Binary tree : ");//Binary tree : 4 2 1 3
        binaryTree.traverseTree(binaryTree.root);

        //preorder tree traversal
        BinaryTree preOrder = new BinaryTree();
        preOrder.root = new Node(1);
        preOrder.root.left = new Node(12);
        preOrder.root.right = new Node(9);
        preOrder.root.left.left = new Node(5);
        preOrder.root.left.right = new Node(6);
        System.out.print("\n Preorder traversal : ");// Preorder traversal : 1->12->5->6->9->
        preOrder.preorder(preOrder.root);

        //postorder tree traversal
        BinaryTree postOrder = new BinaryTree();
        postOrder.root = new Node(1);
        postOrder.root.left = new Node(12);
        postOrder.root.right = new Node(9);
        postOrder.root.left.left = new Node(5);
        postOrder.root.left.right = new Node(6);
        System.out.print("\n postOrder traversal : ");//  postOrder traversal : 5->6->12->9->1->
        postOrder.postorder(postOrder.root);

        //inorder tree traversal
        BinaryTree inOrder = new BinaryTree();
        inOrder.root = new Node(1);
        inOrder.root.left = new Node(12);
        inOrder.root.right = new Node(9);
        inOrder.root.left.left = new Node(5);
        inOrder.root.left.right = new Node(6);
        System.out.print("\n inOrder traversal : ");// inOrder traversal : 5->12->6->1->9->
        inOrder.inorder(inOrder.root);


        //count leaf nodes in a tree
        BinaryTree countLeafNodes = new BinaryTree();
        countLeafNodes.root = new Node(5);
        countLeafNodes.root.left = new Node(3);
        countLeafNodes.root.right = new Node(8);
        //create child nodes of left child
        countLeafNodes.root.left.left = new Node(2);
        countLeafNodes.root.left.right = new Node(4);
        //create child nodes of right child
        countLeafNodes.root.right.left = new Node(7);
        countLeafNodes.root.right.right = new Node(9);
        int leafNodes = countLeaf(countLeafNodes.root);
        System.out.print("\n countLeafNodes of a tree : "+leafNodes);//countLeafNodes of a tree : 4
    }

    //preorder tree traversal
    void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.key+"->");
        preorder(node.left);
        preorder(node.right);
    }

    //postorder tree traversal
    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key+"->");
    }

    //inorder tree traversal
    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.key+"->");
        inorder(node.right);
    }

    //count leaf nodes in a tree
    static int countLeaf(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeaf(node.left) + countLeaf(node.right);
        }
    }
}

//grap data structure
class Graph {
    class Edge {
        int src, dest;
    }
    int vertices, edges;
    Edge[] edge;
    Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        edge = new Edge[edges];
        for (int i = 0; i < edges; i++) {
            edge[i] = new Edge();
        }
    }

    public static void main(String[] args) {
        int noVertices = 5;
        int noEdges = 8;
        Graph g = new Graph(noVertices, noEdges);
        g.edge[0].src = 1;  //   edge 1 -- 2
        g.edge[0].dest = 2;
        g.edge[1].src = 1;
        g.edge[1].dest = 3;
        g.edge[2].src = 1;
        g.edge[2].dest = 4;
        g.edge[3].src = 2;
        g.edge[3].dest = 4;
        g.edge[4].src = 2;
        g.edge[4].dest = 5;
        g.edge[5].src = 3;
        g.edge[5].dest = 4;
        g.edge[6].src = 3;
        g.edge[6].dest = 5;
        g.edge[7].src = 4;
        g.edge[7].dest = 5;
        for (int i = 0; i < noEdges; i++) {
            System.out.println(g.edge[i].src+" - "+g.edge[i].dest);
            //1 - 2
            //1 - 3
            //1 - 4
            //2 - 4
            //2 - 5
            //3 - 4
            //3 - 5
            //4 - 5
        }
    }
}