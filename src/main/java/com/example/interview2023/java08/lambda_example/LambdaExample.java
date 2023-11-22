package com.example.interview2023.java08.lambda_example;

import java.util.*;
import java.util.function.Supplier;
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
        /* Là toán tử tham chiếu phương thức trong Java*/
        MyFuction func01 = MyUtils::add;
        LambdaExample lambdaExample = new LambdaExample();
        int result01 = lambdaExample.action(10, 2, func01);
        System.out.println("Tổng : "+result01);

        MyFuction func02 = MyUtils::minus;
        LambdaExample lambdaExample1 = new LambdaExample();
        int result02 = lambdaExample1.action(10,2, func02);
        System.out.println("Hiệu :"+result02);

        /*StringJoiner*/
        /*Được xây dựng bởi một dãy ký tự bằng dấu phân cách*/
        StringJoiner joiner = new StringJoiner("-");
        joiner.add(" TẾT ");
        joiner.add(" ĐOÀN ");
        joiner.add(" VIÊN ");
        joiner.add(" 2023! ");
        System.out.println(joiner);

        StringJoiner joiner01 = new StringJoiner("-","<<<",">>>");
        joiner01.add(" TẾT ");
        joiner01.add(" ĐOÀN ");
        joiner01.add(" VIÊN ");
        joiner01.add(" 2023! ");
        System.out.println(joiner01);

        StringJoiner joiner02 = new StringJoiner("-","<<<",">>>");
        joiner02.add(" NGUỜI ");
        joiner02.add(" LỚN ");
        StringJoiner joiner03 = new StringJoiner("-","<<<",">>>");
        joiner03.add(" KHÔNG ");
        joiner03.add(" THÍCH ");
        joiner03.add(" TẾT ");
        System.out.println(joiner02.merge(joiner03));
        /*Tiền tố hậu tố giống nhau thì mới ra*/

        /*Foreach*/
        List<String> ls = new ArrayList<String>();
        ls.add("Java");
        ls.add("PHP");
        ls.add("C++");
        ls.add("Python");

        ls.forEach(System.out::println);

        ls.stream().forEachOrdered(p-> System.out.println(p));
        /*Stream*/
        /*Stream(Luồng) là một đối tượng mới của Java . Giúp cho việc thao tác trên Collection và array trở nên dễ dàng và tối ưu hơn.
        * stream() : Trả về 1 stream xử lý theo tuần tự.
        * parallelStream() : Trả về 1 stream song song. Xử lý sau đó sẽ thưc hiện song song.
        * Stream là immutable (Không thay đổi về giá trị)
        * */

        /*Convert Stream to List, Array*/
        Stream<String> str = Stream.of("Anh","Bình","Cảnh","Duyên");
        List<String> lStr = str.collect(Collectors.toList());
        Stream<String> str1 = Stream.of("Anh","Bình","Cảnh","Duyên");
        String[] aStr = str1.toArray(String[]::new);
        Stream<String> str2 = Stream.of("Anh","Bình","Cảnh","Duyên");
        String[] aStr1 = str2.toArray(size -> new String[size]);
        /* String[]::new == size -> new String[size] */
        /*Convert List, Array to Stream*/
        String[] languages = { "Java", "C#", "C++", "PHP", "Javascript" };
        Stream<String> stringStream = Arrays.stream(languages);
        List<String> items = new ArrayList<>();
        items.add("Java");
        items.add("C#");
        items.add("C++");
        items.add("PHP");
        items.add("Javascript");
        Stream<String> listStream = items.stream();

        /*filter*/
        List<String> filterByLength = ls.stream().filter(item-> item.length() >3).collect(Collectors.toList());
        System.out.println("List Filter");
        filterByLength.forEach(System.out::println);

        /*skip(), limit()*/
        Stream<String> strSkipLimit = items.stream().skip(1).limit(2);
        /*map()*/
        System.out.println("UPPER ITEM");
        /*Upper case*/
        items.stream().map(element -> element.toUpperCase()).forEach(System.out::println);
        /*Sort*/
        List<String> data01 = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

        System.out.println("SORT");
        data01.stream() //
                .sorted() //
                .forEach(System.out::println);

        System.out.println("SORT BY REQUIRE");
        data01.stream() //
                .sorted((s1, s2) -> s1.length() - s2.length()) //
                .forEach(System.out::println);
        /*Cách để tạo Stream dùng lại được mà không bị đóng "stream has already been operated upon or closed"*/
        Supplier<Stream<String>> streamSupplier = ()->Stream.of("A", "B", "C", "D");
        streamSupplier.get().filter(el->el.equals("A")).forEach(System.out::println);
        /*anyMatch(), allMatch(), noneMatch() trả về true false*/
        List<String> data02 = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
        boolean result = data02.stream().anyMatch((s) -> s.equalsIgnoreCase("Java"));
        System.out.println(result);
    }

    public int action(int a, int b, MyFuction func) {
        return func.accept(a, b);
    }
}

