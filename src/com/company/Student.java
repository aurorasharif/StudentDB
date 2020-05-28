package com.company;

import java.util.*;

public class Student {
    Scanner scanner = new Scanner(System.in);

    static int x = 1000;

    private String name;
    private String gradeYear;
    private String id;
    private int balance;
    private Set<String> courses;
    private int costPerCourse = 600;


    public Student() {
        System.out.println("enter student name:");
        name = scanner.nextLine();
        System.out.println("Enter student's grade year: freshmen or sophomore or junior or senior");
        gradeYear = scanner.nextLine();
        id = generateId();
        courses = new HashSet<>();
        x++;
    }

    private String generateId() {
        return String.valueOf(gradeYear.charAt(0)) + x;
    }

    public void register() {
        while(true) {
            String input;
            System.out.println("type the class names u wish to register:\n" +
                    "History101 \n" +
                    "Math101 \n" +
                    "Chem101 \n" +
                    "CompSci101 \n" +
                    "q to quit");
            input = scanner.nextLine().toUpperCase();

            //if(input!="Q")-->
            // this doesnt work here because it compares if the input
            // and the String "Q" point to the same memory location
            // rather than comparing the actual values

            if(!input.equals("Q")) {
                courses.add(input);
                this.balance = balance();
            } else break;
        }
        if(this.courses.size()!=0) {
            System.out.println("would you like to payoff any balance? Y/N");
            char i = scanner.nextLine().charAt(0);
            if (i == 'y') {
                System.out.println("how much would yout like to pay?");
                int amount = scanner.nextInt();
                payTuition(amount);
            }
        }
    }


    private int balance() {
        return this.balance = courses.size() * costPerCourse;
    }

    public int getBalance() {
        return balance;
    }

    public void payTuition(int amount){
        System.out.println("here: " + this.balance);
        if(this.balance>=amount) {
            this.balance -= amount;
            System.out.println("amount left to pay: "+ this.balance);
        }else
        System.out.println("oops");
    }

    @Override
    public String toString() {
        return "Student " +
                "name='" + name + '\'' +
                ", gradeYear='" + gradeYear + '\'' +
                ", id='" + id + '\'' +
                ", balance=" + balance;
    }

    public void getStatus(){
        System.out.println(this);
        System.out.println("courses taken");
        for (String x: courses){
            System.out.println(x);
        }
    }
}
