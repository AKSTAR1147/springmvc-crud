package com.AK_rest_jpa.demo.controller;



import com.AK_rest_jpa.demo.entity.Employee;
import com.AK_rest_jpa.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private EmployeeService employeeSevice;


    @Autowired
    public EmployeeController(EmployeeService empSevice){
        employeeSevice=empSevice;
    }


    //endpoint for showing list of employees
    @GetMapping("/list")
    public String listEmployees(Model model){

        //get the emplyees from database
        List<Employee> employees = employeeSevice.findAll();

        //add the data to the model
        model.addAttribute("employees",employees);

        return "employeeList";
    }


    @GetMapping("/showFormForAdd")
    public String showForm(Model model){

        //create model attribute to bind form data
        Employee emp = new Employee();

        //add attribute to model
        model.addAttribute("employee",emp);

        return "employeeForm";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){

        //get the employee from service by id
        Employee emp = employeeSevice.findById(id);

        //add the employee to the model to pre-populate the form
        model.addAttribute("employee",emp);

        //send over to our form
        return "employeeForm";

    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        //save the employee
        employeeSevice.save(employee);

        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id){

        //delete the employee from service by id
        employeeSevice.deleteById(id);


        //send back over to our form
        return "redirect:/employees/list";

    }
}
