package repository;

import model.Course;


import java.util.*;

public class Repository {

    public static List<Course> courses=new ArrayList<>();

    public static List<Course> input(){

        Integer id= (int)(Math.random() * 2000) + 1000;
        System.out.print("[+] Insert Course Title :");

       String  title=new Scanner(System.in).nextLine();

        System.out.print("[+] Insert Instructor name :");
       String [] instructor= new String[]{Arrays.toString(new Scanner(System.in).nextLine().replaceAll("\\s*,\\s*", ",").split(","))};

        System.out.print("[+] Insert Course requirement  :");
       String [] requirement = new String[]{Arrays.toString(new Scanner(System.in).nextLine().replaceAll("\\s*,\\s*", ",").split(","))};

        courses.add(new Course(id,title,instructor,requirement, new Date()));
        return courses;
    }

    public static List<Course> showList(){
        courses.forEach(System.out::println);

        return courses;

    }
}
