package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);

        System.out.println("enter the number of new student you would ike to add");
        int num=scanner.nextInt();

        for (int i=0; i<num; i++){
            students.add(new Student());
            students.get(i).register();
        }



        for (Student i: students){
            System.out.println(i);
        }


//        Student auro=new Student();
//        auro.register();
//        auro.payTuition(700);
//        auro.getStatus();
    }
}
