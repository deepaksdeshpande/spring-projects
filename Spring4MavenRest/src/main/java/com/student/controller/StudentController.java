package com.student.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.student.bean.Student;

/*
 * this below code is used just to show spring form submit method using spring 4
 */


/*@Controller
public class StudentController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("studentForm", "command", new Student());
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb") Student student, ModelMap model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("studId", student.getStudId());
        return "studentDetail";
    }
}*/


/*
 *  below code is made using @restcontroller new feature of spring4
 *  
 *  In StudentController class, we have added @RestController annotation which removing the need to add @ResponseBody 
 *  to each of your @RequestMapping methods.
 *  @RequestMapping annotation is used for mapping web requests to corresponding handler classes and handler methods
 *  
 */


@RestController
public class StudentController {
	
	/**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/showMessage", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
                
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
         
        String formattedDate = dateFormat.format(date);
         
        model.addAttribute("serverTime", formattedDate );
         
        return "showMessage";
    }
   
    @RequestMapping(value = "/student" ,method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Student> getAllStudents() {
        List<Student> Students = new ArrayList<Student>();

        Student student = new Student();
        student.setStudId(1);
        student.setName("Rockey");
        student.setAge(12);
        Students.add(student);

        student = new Student();
        student.setStudId(2);
        student.setName("Jose");
        student.setAge(13);
        Students.add(student);

        return Students;
    }
   
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Student getStudentById(@PathVariable int id) {
        Student student = null;
        if (id == 1) {
            student = new Student();
            student.setStudId(2);
            student.setName("Jose");
            student.setAge(13);
        }else{
            student = new Student();
            student.setName("Invalid Student");
        }
        return student;
    }
    
    @RequestMapping(value = "/studentForm", method = RequestMethod.GET )
    public ModelAndView student() {
        return new ModelAndView("studentForm", "command", new Student());
    }
    
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addStudent(@ModelAttribute("StudentDetail") Student student, ModelMap model) {
    	
    	model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("studId", student.getStudId());
        return new ModelAndView("studentDetail");
    }
}