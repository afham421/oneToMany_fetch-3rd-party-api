package com.detabase.oneToMany.controller;

import com.detabase.oneToMany.Response.Response;
import com.detabase.oneToMany.service.ServiceImpl;
import com.detabase.sn3Integration.JsonToJava;
import com.detabase.sn3Integration.RestClient;
import com.detabase.sn3Integration.SecondThirdParty.ThirdPartySecondRseponse;
import com.detabase.sn3Integration.SecondThirdParty.closedJobs;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/3rdpartySecond")
@Slf4j
public class ThirdPartyByDateController {

    @Autowired
    ServiceImpl service;
    @PostMapping("/callApi")
    public Response callApi(@RequestHeader Map<String, String> headers, @RequestBody String input) throws JsonProcessingException, ParseException {

        String url = headers.get("url");

        String response = RestClient.getResponse(url, input);
        ThirdPartySecondRseponse thirdPartySecondRseponse = JsonToJava.jsonToJavaObject1(response);

        Response response1 = new Response();
        List<closedJobs> list = new ArrayList<>();
        String startInput = "01/03/2022 00:00:00";


        DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd/MM/yyyy HH:mm:ss" );

        LocalDateTime start = LocalDateTime.parse( startInput , f ) ;
        LocalDate localDate1 = start.toLocalDate();

        thirdPartySecondRseponse.getData().getClosedJobs().forEach(e-> {
            String stringtime = e.getTime();
//            log.info("timedate        "+stringtime);
            LocalDateTime in = LocalDateTime.parse( stringtime , f ) ;
//            log.info("timedate        "+in);
            LocalDate localDate = in.toLocalDate();
            if (localDate.isAfter(localDate1) ){
                list.add(e);
            }
        });

        response1.setResponseData(list);
        response1.setResponseMsg(thirdPartySecondRseponse.getDisplayMessage());
        response1.setResponseCode(thirdPartySecondRseponse.getStatusCode());

        return response1;
    }
}
