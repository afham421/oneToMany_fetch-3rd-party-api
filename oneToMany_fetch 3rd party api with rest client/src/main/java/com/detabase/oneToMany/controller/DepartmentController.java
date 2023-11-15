package com.detabase.oneToMany.controller;

import com.detabase.oneToMany.Response.Response;
import com.detabase.oneToMany.entity.Department;

import com.detabase.oneToMany.service.ServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@Api(protocols = "http")
public class DepartmentController {

    @Autowired
    private ServiceImpl service;

    @ApiOperation(value = "To get all Data . . . " , response = Department.class)
    @GetMapping("/all")
    public ResponseEntity<Response> getDepartments(){
        Response employees = service.getDepartments();
        if (employees==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @ApiOperation(value = "To get data by id . . . " , response = Department.class)
    @GetMapping("/{id}")
    public ResponseEntity<Response> getDepartment(@PathVariable("id") int id){
        Response department = service.getDepartment(id);
        if (department==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(department);
    }
//    @ApiOperation(value = "To get data by id . . . " , response = Department.class)
//    @GetMapping("/{name}")
//    public ResponseEntity<Response> getDepartmentByName(@PathVariable("name") String name){
//        Response department = service.getDepartmentByTitle(name);
//        if (department==null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(department);
//    }

    @ApiOperation(value = "To add data . . . " , response = Department.class)
    @PostMapping("/add")
    public ResponseEntity<String> addDepartment(@RequestBody Department department) {
        try {
            service.addDepartment(department);
            return ResponseEntity.status(HttpStatus.CREATED).body("Department is successfully added");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @ApiOperation(value = "To update  data . . . " , response = Department.class)
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateDepartment(@RequestBody Department department, @PathVariable("id") int id) {
        try {
            service.updateDepartment(department, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "To delete data . . . " , response = Department.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteDepartment(@PathVariable("id") int id) {
        try {
            service.deleteDepartment(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
