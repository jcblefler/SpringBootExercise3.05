package com.example.springbootexercise3_05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/")
    public String index(Model model){

        Student student = new Student();
        student.setName("Henry Little");
        student.setAge(21);

        Course course = new Course();
        course.setTitle("Intro to Programming");
        course.setDescription("Learn the basics of coding");
        course.setCredits(3);

        Set<Course> courses = new HashSet<Course>();
        courses.add(course);

        student.setCourses(courses);

        studentRepository.save(student);

        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

}
