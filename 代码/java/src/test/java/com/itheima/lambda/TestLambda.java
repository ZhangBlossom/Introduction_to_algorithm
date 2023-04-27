package com.itheima.lambda;

import java.util.List;

public class TestLambda {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("郭靖", "男"),
                new Student("黄蓉", "女"),
                new Student("杨康", "男"),
                new Student("穆念慈", "女")
        );

        students.stream().filter(TestLambda::isMale)
                .forEach(student -> System.out.println(student.getName()));
    }

    static boolean isMale(Student student) {
        return "男".equals(student.getSex());
    }


    static class Student {
        private final String name;
        private final String sex;

        public Student(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public boolean isMale() {
            return "男".equals(sex);
        }
    }
}
