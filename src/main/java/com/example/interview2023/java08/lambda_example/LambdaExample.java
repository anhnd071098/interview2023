package com.example.interview2023.java08.lambda_example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExample {
    public static void main(String[] args) {
        /* 1. FunctionalInterface */
        String vehicle = "ô tô";
        FunctionalInterfaceExample example = new FunctionalInterfaceExample() {
            @Override
            public void run() {
                System.out.println("Di chuyển bằng xe : " + vehicle + " ");
            }
        };

        FunctionalInterfaceExample functionalInterfaceExample = () -> {
            System.out.println("Di chuyển bằng xe : " + vehicle + " ");
        };
//        functionalInterfaceExample.run();

        /*2. Lambda*/

        /*Lambda foreach*/
        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("PHP");
        list.add("C++");
        list.add("Python");

        list.forEach((element) -> {
            if (element == "Java") {
                System.out.println("Java");
            }
        });

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Mendy", 16));
        students.add(new Student(6, "Mindy", 19));
        students.add(new Student(2, "Andy", 15));
        students.add(new Student(4, "kevin", 26));
        students.add(new Student(3, "Ya", 14));
        students.add(new Student(5, "Haaland", 26));

        Collections.sort(students, (o1, o2) -> {
            int i = (o1.getName().compareTo(o2.getName()) > 0) ? 1 : (o1.getName().compareTo(o2.getName()) < 0) ? -1 : 0;
            return i;
        });
        System.out.println("LIST STUDENT SORT BY NAME");
        students.forEach((element) -> {
            System.out.println(element.toString());
        });
        Collections.sort(students, (o1, o2) -> {
            int i = o1.getSeq() > o2.getSeq() ? 1 : o1.getSeq() < o2.getSeq() ? -1 : 0;
            return i;
        });
        System.out.println("LIST STUDENT SORT BY SEQ");
        students.forEach((element) -> {
            System.out.println(element.toString());
        });

        TreeSet<Integer> h =
                new TreeSet<Integer>();
        h.add(850);
        h.add(235);
        h.add(1080);
        h.add(15);
        h.add(5);
        System.out.println("Elements of the TreeSet : " + h);

        TreeSet<Student> h1 =
                new TreeSet<Student>((o1, o2) -> {
                    int i = (o1.getName().compareTo(o2.getName()) > 0) ? 1 : (o1.getName().compareTo(o2.getName()) < 0) ? -1 : 0;
                    return i;
                });
        h1.add(new Student(1, "Mendy", 16));
        h1.add(new Student(6, "Mindy", 19));
        h1.add(new Student(2, "Andy", 15));
        h1.add(new Student(4, "kevin", 26));
        h1.add(new Student(3, "Ya", 14));
        h1.add(new Student(5, "Haaland", 26));
        System.out.println("Elements of the TreeSet after" +
                " sorting by name are: " + h1);

        TreeSet<String> ts = new TreeSet<String>((aStr, bStr) -> bStr.compareTo(aStr));

        ts.add("A");
        ts.add("B");
        ts.add("C");
        ts.add("D");
        ts.add("E");
        ts.add("F");
        ts.add("G");

        ts.forEach((element) -> System.out.println(element));

        /*lamda thread*/
        Runnable r2 = () -> {
            System.out.println("Thread2 is running...");
        };
        Thread t2 = new Thread(r2);
        t2.start();

        /*3. Filter*/

        /*Filter Student*/
        System.out.println("FILTER LIST");
        Stream<Student> student_filter = students.stream().filter((student) -> student.getAge() > 16);
        student_filter.forEach((element) -> {
            System.out.println(element.toString());
        });
        System.out.println("FILTER MAP");
        Stream<Student> student_filter_map = h1.stream().filter((student) -> student.getAge() <= 16);
        student_filter_map.forEach((el) -> {
            System.out.println(el.toString());
        });
        /*stream : một luồng chỉ nên được sử dụng 1 lần(tức là khi trên 1 dòng lệnh gọi stream sau đó nếu gọi tiếp đến luồng đó ở 1 dòng khác sẽ lỗi).
        Việc triển khai luồng sẽ tạo ra lỗi. Biện pháp tạo ra luồng mới khi cần*/
        /*
            Stream.collect(Collectors.toList()): Since Java 8
            Stream.collect(Collectors.toUnmodifiableList()): Since Java 10
            Stream.toList(): Since Java 16
         */
        System.out.println("CONVERT STREAM TO LIST");
        List<Student> convertStreamToList = h1.stream().filter((student) -> student.getAge() == 26).collect(Collectors.toList());
        convertStreamToList.forEach((el) -> {
            System.out.println(el.toString());
        });

        /*Toán tử :: */


    }
}
