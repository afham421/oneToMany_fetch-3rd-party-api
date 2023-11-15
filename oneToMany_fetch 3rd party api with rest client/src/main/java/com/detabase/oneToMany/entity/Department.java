package com.detabase.oneToMany.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data

@RequiredArgsConstructor
@Entity
@Table(name = "Department")
public class Department {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;


    private String title;

//    @OneToMany(targetEntity = Employee.class , cascade = CascadeType.ALL)  //first method
//    @JoinColumn(name = "dp_fk" ,nullable = false)
//    private List<Employee> employees;

    @OneToMany(cascade = CascadeType.ALL)  //second method
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private List<Employee> employees;


}
