package com.idea.tips.debug;


import com.idea.tips.debug.bean.Student;
import com.idea.tips.debug.service.FunServiceImpl1;
import com.idea.tips.debug.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DebugDemo {

    private static List<Student> students = new ArrayList<>();

    private static Service service = new FunServiceImpl1();

    static {
        for (int i = 0; i < 10; i++) {
            Student student = new Student(i, "zdx" + i, i + 10);
            students.add(student);
        }
    }

    public static void main(String[] args) {
//        //普通断点 + 普通方法断点 + 条件判断
//        checkData(students);
//
//        //接口方法断点
//        service.test();
//
//        //异常断点
//        excetionTest();
//
//        //字段断点
//        Student student = new Student();
//        student.getId();
//
//        //实时计算变量值 + 赋值
//        evaluate(students);

        // stream debug
        List<Integer> collect = students.stream().map(t -> t.getAge() + 1).filter(t -> t % 2 == 0).collect(Collectors.toList());


    }

    private static void excetionTest() {
        Student student = null;
        student.getId();
    }

    private static void evaluate(List<Student> students) {

        Boolean flag = students.size() > 10 ? true : false;
        if (flag) {
            //各种处理
            System.out.println("something");
            //....
        }
    }

    private static void checkData(List<Student> students) {
        System.out.println("DebugDemo.checkData");


        for (Student student : students) {
            System.out.println(student);
            //其他处理。。。。
            student.setName("张三");
        }
        System.out.println(students.size());
    }

}
