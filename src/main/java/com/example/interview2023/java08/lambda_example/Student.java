package com.example.interview2023.java08.lambda_example;

import lombok.Data;

@Data
public class Student {
    private int seq;
    private String name;
    private int age;

    public Student(int seq, String name, int age) {
        this.seq = seq;
        this.name = name;
        this.age = age;
    }
}
