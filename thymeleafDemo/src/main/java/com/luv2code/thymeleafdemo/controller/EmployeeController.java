package com.luv2code.thymeleafdemo.controller;

import com.luv2code.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    // load employee data
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData(){
        //create employees
        Employee emp1 = new Employee(1,
                "Leslie", "Andrews", "leslie@icloud.com");
        Employee emp2 = new Employee(2,
                "Emma", "Baum", "emma@icloud.com");
        Employee emp3 = new Employee(3,
                "Avani", "Gupta", "avani@icloud.com");

        theEmployees = new ArrayList<>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

    //add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
