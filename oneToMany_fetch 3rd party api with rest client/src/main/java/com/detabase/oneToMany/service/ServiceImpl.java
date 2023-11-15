package com.detabase.oneToMany.service;

import com.detabase.oneToMany.DAo.DepartmentDao;
import com.detabase.oneToMany.DAo.EmployeeDao;
import com.detabase.oneToMany.Response.Response;
import com.detabase.oneToMany.entity.Department;
import com.detabase.oneToMany.entity.Employee;
import com.detabase.sn3Integration.SecondThirdParty.ThirdPartySecondRseponse;
import com.detabase.sn3Integration.SecondThirdParty.closedJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements ServiceHelper{

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public Response getEmployees() {
        Response response = new Response();
        if(!(employeeDao == null)){
            Object b = employeeDao.findAll();
            response.setResponseCode("200");
            response.setResponseMsg("Employees fetched successfully");
            response.setResponseData(b);
        } else{
            response.setResponseCode("400");
            response.setResponseMsg("Employees does not exist!!!");
        }

        return  response;
    }

    @Override
    public Response getDepartments() {
        Response response = new Response();
        if(!(departmentDao == null)){
            Object b = departmentDao.findAll();
            response.setResponseCode("200");
            response.setResponseMsg("Department fetched successfully");
            response.setResponseData(b);
        } else{
            response.setResponseCode("400");
            response.setResponseMsg("Department does not exist!!!");
        }

        return  response;
    }

    @Override
    public Response getEmployee(int id) {
        Response response = new Response();

        Optional<Employee> employee = employeeDao.findById(id);

        if (!employee.isPresent()){
            response.setResponseCode("400");
            response.setResponseMsg("Employee does not exist!!!");
            return response;
        }else {

            response.setResponseCode("200");
            response.setResponseMsg("Employee fetched successfully");
            response.setResponseData(employee);
        }

        return response;
    }

    @Override
    public Response getDepartment(int id) {
        Response response = new Response();

        Optional<Department> department = departmentDao.findById(id);

        if (!department.isPresent()){
            response.setResponseCode("400");
            response.setResponseMsg("Department does not exist!!!");
            return response;
        }else {

            response.setResponseCode("200");
            response.setResponseMsg("Department fetched successfully");
            response.setResponseData(department);
        }

        return response;
    }

    @Override
    public Response getDepartmentByTitle(String name) {
        return null;
    }


    @Override
    public Employee getEmployeeByName(String name) {


        Employee employeeByTitle = employeeDao.findEmployeeByName(name);


        return employeeByTitle;
    }

    @Override
    public Response addEmployee(Employee employee) {
        Response response = new Response();

        if(!(employee == null)){
            Object b = employeeDao.save(employee);
            response.setResponseCode("200");
            response.setResponseMsg("Employee added successfully");
            response.setResponseData(b);
        } else{
            response.setResponseCode("400");
            response.setResponseMsg("Employee does not added!!!");
        }
        return response;
    }

    @Override
    public Response addDepartment(Department department) {
        Response response = new Response();
        if(!(department == null)){
            Object b = departmentDao.save(department);
            response.setResponseCode("200");
            response.setResponseMsg("Department added successfully");
            response.setResponseData(b);
        } else{
            response.setResponseCode("400");
            response.setResponseMsg("Department does not added!!!");
        }
        return response;
    }

    @Override
    public Response updateEmployee(Employee employee , int id) {
        Response response = new Response();
        if(!(employeeDao == null)){
            employee.setId(id);
            Object b = employeeDao.save(employee);
            response.setResponseCode("200");
            response.setResponseMsg("Employee updated successfully");
            response.setResponseData(b);
        } else{
            response.setResponseCode("400");
            response.setResponseMsg("Employee does not updated");
        }
        return response;
    }

    @Override
    public Response updateDepartment(Department department, int id) {
        Response response = new Response();
        if(!(departmentDao == null)){
            department.setId(id);
            Object b = departmentDao.save(department);
            response.setResponseCode("200");
            response.setResponseMsg("Department updated successfully");
            response.setResponseData(b);
        } else{
            response.setResponseCode("400");
            response.setResponseMsg("Department does not updated");
        }
        return response;
    }

    @Override
    public Response deleteDepartment(int id) {
        departmentDao.deleteById(id);
        Response response = new Response();
        response.setResponseCode("200");
        response.setResponseMsg("Department deleted successfully");

        return response;
    }

    @Override
    public Response deleteEmployee(int id) {
        employeeDao.deleteById(id);
        Response response = new Response();
        response.setResponseCode("200");
        response.setResponseMsg("Employee deleted successfully");

        return response;
    }




}
