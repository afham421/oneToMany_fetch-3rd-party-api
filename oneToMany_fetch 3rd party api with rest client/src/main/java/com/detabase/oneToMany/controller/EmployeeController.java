package com.detabase.oneToMany.controller;

import com.detabase.oneToMany.DAo.EmployeeDao;
import com.detabase.oneToMany.Response.Response;
import com.detabase.oneToMany.entity.Employee;
import com.detabase.oneToMany.service.ServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Api(protocols = "http")
public class EmployeeController {


    @Autowired
    private ServiceImpl service;

    @ApiOperation(value = "To get all Employees . . . " , response = Employee.class)
    @GetMapping("/all")
    public ResponseEntity<Response> getEmployees(){
        Response employees = service.getEmployees();
        if (employees==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @ApiOperation(value = "To get Employee by id . . . " , response = Employee.class)
    @GetMapping("/{id}")
    public ResponseEntity<Response> getEmployee(@PathVariable("id") int id){
        Response employee = service.getEmployee(id);
        if (employee==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }
//    @ApiOperation(value = "To get data by id . . . " , response = Employee.class)
//    @GetMapping("/{name}")
//    public ResponseEntity<Response> getEmployeeByName(@PathVariable("name") String name){
//        Response employeeByTitle = service.getEmployeeByTitle(name);
//        if (employeeByTitle==null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(employeeByTitle);
//    }

    @ApiOperation(value = "To add Employees . . . " , response = Employee.class)
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        try {
            service.addEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee is successfully added");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @ApiOperation(value = "To update  Employee . . . " , response = Employee.class)
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
        try {
            service.updateEmployee(employee, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "To delete Employee . . . " , response = Employee.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteEmployee(@PathVariable("id") int id) {
        try {
            service.deleteEmployee(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
