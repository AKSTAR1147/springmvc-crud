package com.AK_rest_jpa.demo.dao;


import com.AK_rest_jpa.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //no need to write additional code for basic crud operation except you need to specify the query

    //add a method to sort by last name


    List<Employee> findAllByOrderByLastNameAsc();
    //spring JPA will parse the method name and create a query according to name i.e.
    //FROM employee ORDER BY lastName;
}
