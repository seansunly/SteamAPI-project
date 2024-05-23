package service;

import exception.UserNotFoundException;
import model.Course;

import java.net.UnknownServiceException;
import java.util.List;

public interface Service {

    List<Course> getAllList();
    Course findUserById(Integer id)throws UnknownServiceException, UserNotFoundException;
    Course findByName(String title);
    Course removeByID(Integer id);

}
