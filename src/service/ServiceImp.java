package service;

import exception.UserNotFoundException;
import model.Course;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import repository.Repository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import static repository.Repository.courses;

public class ServiceImp implements Service{
    @Override
    public List<Course> getAllList() {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);

        table.addCell("ID");
        table.addCell("TITLE");
        table.addCell("INSTRUCTOR NAME");
        table.addCell("REQUIREMENT");
        table.addCell("DATE");
        courses.forEach(course -> {
            table.addCell(String.valueOf(course.getId()));
            table.addCell(course.getTitle());
            table.addCell(Arrays.toString(course.getInstructor()));
            table.addCell(Arrays.toString(course.getRequirement()));
            table.addCell(course.getDate().toString());
        });
        System.out.println(table.render());
        return null;
    }

    @Override
    public Course findUserById(Integer id) {

        List<Course> courses = Repository.courses;
        Table table = new Table(1, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
        table.addCell("Course");
        System.out.print("input id:");

        Integer ids=new Scanner(System.in).nextInt();

        try {
            Course course = courses.stream()
                    .filter(c -> c.getId().equals(ids))
                    .findFirst()
                    .orElseThrow(() -> new UserNotFoundException("Course not found with ID: " + ids));

            table.addCell(String.valueOf(course));
            System.out.println(table.render());
            return null;
        } catch (UserNotFoundException e) {

            System.out.println(">>>>>>>>>>>>>>>> Course not found with ID: " + ids);
        }

        return null;
    }

    @Override
    public Course findByName(String title) {
        List<Course>cour=Repository.courses;
        Table table = new Table(1, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
        table.addCell("Course");
        System.out.print("input by title :");
        String titles=new Scanner(System.in).nextLine();
        try {
            Course course = courses.stream()
                    .filter(c -> c.getTitle().equals(titles))
                    .findFirst()
                    .orElseThrow(() -> new UserNotFoundException("Course not found with titles : " + titles));

            table.addCell(String.valueOf(course));
            System.out.println(table.render());
            return null;
        } catch (UserNotFoundException e) {

            System.out.println(">>>>>>>>>>>>>>>> Course not found with titles : " + titles);
        }


        return null;
    }

    @Override
    public Course removeByID(Integer id) {
        List<Course> courses = Repository.courses;
        System.out.print("input id:");
        Integer ids=new Scanner(System.in).nextInt();
        try {
            Optional<Course> courseToRemove = Optional.ofNullable(courses.stream()

                    .filter(c -> c.getId().equals(ids))

                    .findFirst()
                    .orElseThrow(() -> new UserNotFoundException("Course not found with titles : " + ids)));
            courseToRemove.ifPresent(courses::remove);
            return courseToRemove.orElse(null);
        }catch (UserNotFoundException e){
            System.out.println(">>>>>>>>>>>>>>>> Course not found with ID : " + ids);
        }

        return null;
    }
}
