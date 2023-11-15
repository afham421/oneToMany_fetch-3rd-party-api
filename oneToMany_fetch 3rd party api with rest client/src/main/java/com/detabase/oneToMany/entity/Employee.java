package com.detabase.oneToMany.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;


    private String name;
    private String email;
    private String phoneNo;
    @ManyToOne  // yeh annotation jidhar bhi use krin gy tu us table main faron key generate ho jay gi
    @JoinColumn(name = "department_id") // or is ko agr use krin gy tu is table main generate ni ho gi or yeh dosry table ko refer kry ga
     Department  department;
}
