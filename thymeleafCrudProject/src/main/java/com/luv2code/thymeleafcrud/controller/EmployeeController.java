package com.luv2code.thymeleafcrud.controller;

import com.luv2code.thymeleafcrud.entity.Employee;
import com.luv2code.thymeleafcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        //create model attribute to bind form data
        Employee theEmployee = new Employee();
        model.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {
        //get the employee from the service
        Employee theEmployee = employeeService.findById(theId);
        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", theEmployee);
        //send over to our form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);

        //use a redirect to prevent dublicate submission
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("employeeId") int theId) {
        //delete the employee
        employeeService.deleteById(theId);
        //redirect to /employees/list
        return "redirect:/employees/list";
    }
}
