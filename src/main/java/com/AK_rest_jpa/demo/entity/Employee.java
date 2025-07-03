package com.AK_rest_jpa.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    //creating data fields according to DB

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")  optional if columnName=fieldNam     Compulsary id columnName!=fieldName or need to provide Constraints eg nullable=false,length=100 etc
    private int id;
    //for db column first_name
    private String firstName;
    //for db column last_name
    private String lastName;
    //for db column email
    private String email;



    //creating 0-argumrnt constructor
    public Employee() {
    }

    //creating argumented constructor


    public Employee(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //defining getters

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    //defining setters


    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
