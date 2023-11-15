package com.detabase.oneToMany.service;

import com.detabase.oneToMany.Response.Response;
import com.detabase.oneToMany.entity.Department;
import com.detabase.oneToMany.entity.Employee;
import com.detabase.sn3Integration.SecondThirdParty.ThirdPartySecondRseponse;
import com.detabase.sn3Integration.SecondThirdParty.closedJobs;

import java.text.ParseException;
import java.util.List;

public interface ServiceHelper {

    public Response getEmployees();
    public Response getDepartments();
    public Response getEmployee(int id);
    public Response getDepartment(int id);
    public Response getDepartmentByTitle(String name);
    public Employee getEmployeeByName(String name);

    public Response addEmployee(Employee employee);
    public Response addDepartment(Department department);

    public Response updateEmployee(Employee employee , int id);
    public Response updateDepartment(Department department , int id);
    public Response deleteDepartment(int id);
    public Response deleteEmployee(int id);


//    public List<closedJobs> getByDate() throws ParseException;

}
