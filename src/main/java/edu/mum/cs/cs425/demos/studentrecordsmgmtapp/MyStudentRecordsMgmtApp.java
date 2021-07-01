package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.util.*;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

/**
 * Hello world!
 *
 */
public class MyStudentRecordsMgmtApp
{
    public static void main( String[] args )
    {
        int[] number={5,7,35,70,25,14,3};
        printHelloWorld(new int[]{5,7,35,70,25,14,3});
        findSecondBiggest(new int[]{5,7,35,70,100,25,14,3});
        Student[] students = {
                new Student(110001, "Dave", LocalDate.of(1951, 11,18)),
                new Student(110002, "Anna", LocalDate.of(1990,12,07)),
                new Student(110003, "Erica", LocalDate.of(1974,01,31)),
                new Student(110004, "Carlos", LocalDate.of(2009,8,22)),
                new Student(110005, "Bob", LocalDate.of(1990,03,05))
        };
        printListOfStudents(students);
        System.out.println("---------New List-------");
        getListOfPlatinumAlumniStudents(students);
    }

    public static void printListOfStudents(Student[] students) {
        System.out.println();
        List<Student> list=Arrays.asList(students);
        list.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);
    }
    public static void getListOfPlatinumAlumniStudents(Student[] students){
        List<Student> list=Arrays.asList(students);
        list.stream().filter(x->{
            return LocalDate.now().getYear()-x.getDateOfAdmission().getYear()>30;
        }).forEach(System.out::println);
    }
    public static void printHelloWorld(int[] numbers){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]%5==0&&numbers[i]%7==0){
                System.out.println("HelloWorld\t");
            }
            else if(numbers[i]%5==0&&numbers[i]%7!=0){
                System.out.println("Hello\t");
            }
            else if(numbers[i]%5!=0&&numbers[i]%7==0){
                System.out.println("World\t");
            }
            else {
                System.out.println("N/A\t");
            }
        }

    }
    public static void findSecondBiggest(int[] numbers){
        System.out.println("Our second Largest is");
        int max=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE+2;
        for (int i=0;i<numbers.length;i++){
            if(max<numbers[i]){
                max=numbers[i];
            }
        }
        for (int i=0;i<numbers.length;i++){
            if(max2<numbers[i]&&numbers[i]<max){
                max2=numbers[i];
            }
        }

        System.out.println(max2);

    }

}
