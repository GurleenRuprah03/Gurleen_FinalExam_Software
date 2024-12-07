package com.example.gurleen300380981.web;


import jakarta.servlet.http.HttpSession;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import com.example.gurleen300380981.entities.Student;
import com.example.gurleen300380981.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@EntityScan
@Controller
@AllArgsConstructor
@SessionAttributes({"a","e"})
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    static int num=0;

    @GetMapping(path="/")
    public String students(Model model){
        List<Student> students = studentRepository.findAll();
        model.addAttribute("listStudents", students);
        return  "students";
    }
    @PostMapping(path="/")
    public String save(Model model, Student student, BindingResult bindingResult, HttpSession session) {
        // Check for form validation errors
        if (bindingResult.hasErrors()) {
            return "redirect:/";  // If there are validation errors, return the form
        } else {
            // Save the student to the database
            studentRepository.save(student);

            // Set session attributes based on the operation type
            if (num == 2) {
                session.setAttribute("e", 2);  // Record edited
                session.setAttribute("a", 0);  // Reset "added" status
            } else {
                session.setAttribute("a", 1);  // Record added
                session.setAttribute("e", 0);  // Reset "edited" status
            }

            // Redirect to the index page
            return "redirect:/";
        }
    }
    }







