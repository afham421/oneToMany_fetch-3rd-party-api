package com.detabase.oneToMany.controller;

import com.detabase.oneToMany.Response.Response;
import com.detabase.oneToMany.entity.Employee;
import com.detabase.oneToMany.service.ServiceImpl;
import com.detabase.sn3Integration.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/3rdApi")
@Slf4j
public class UserController {


    @Autowired
    private ServiceImpl service;
    @PostMapping("/callApi")
    public Response callApi(@RequestHeader Map<String,String> headers , @RequestBody String input ) throws JsonProcessingException {

        String url = headers.get("url");
        String name = headers.get("name");

        Employee employeeByName = service.getEmployeeByName(name);

        String response = RestClient.getResponse(url, input);

        LoginBussiness loginBussiness = JsonToJava.jsonToJavaObject(response);

//        ResponseOfBothDBand3rdParty responseOfBothDBand3rdParty = new ResponseOfBothDBand3rdParty();

        ThirdParty thirdParty = new ThirdParty();
        thirdParty.setName(employeeByName.getName());
        thirdParty.setEmail(employeeByName.getEmail());
        thirdParty.setPhoneNo(employeeByName.getPhoneNo());
        thirdParty.setDepartment(employeeByName.getDepartment());
        thirdParty.setAuthToken(loginBussiness.getData().getAuthToken());
        thirdParty.setTpName(loginBussiness.getData().getName());
        thirdParty.setWorkerStatus(loginBussiness.getData().getWorkerStatus());
//        thirdParty.setThirdPartyDetail(String.valueOf(loginBussiness));

        Response response1 = new Response();
        response1.setResponseCode(loginBussiness.getStatusCode());
        response1.setResponseMsg(loginBussiness.getDisplayMessage());
        response1.setResponseData(thirdParty);
        return response1;
    }

}
