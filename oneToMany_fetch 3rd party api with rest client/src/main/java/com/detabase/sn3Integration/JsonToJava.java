package com.detabase.sn3Integration;

import com.detabase.sn3Integration.SecondThirdParty.ThirdPartySecondRseponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJava {

    public static LoginBussiness jsonToJavaObject(String jsonStr) throws JsonProcessingException {
//        String jsonStr="{\"statusCode\":\"200\",\"reporting\":null,\"exception\":null,\"displayMessage\":\"Your request has been processes successfully.\"" +
//                ",\"data\":{\"authToken\":\"3985cc95-37c5-43f8-b380-d70cdf575b9c\"" +
//                ",\"integrationToken\":\"\",\"id\":\"126003\",\"name\":\"c-heba\",\"resourceType\":\"cleaner\",\"workerStatus\":\"working\",\"posPollingTime\":\"60\"}}\n";

//        String jsonStr = RestClient.getResponse("https://esbtest.sn3.com.sa:443/cxf/loginwfmroute/wfm/login" , "{\"loginWfmEsbRequest\":{\"username\":\"126003\",\"password\":\"aaa\",\"lang\":\"en\",\"channel\":\"wfm\"}}");

        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(jsonStr);

        LoginBussiness loginBussiness = objectMapper.readValue(jsonStr, LoginBussiness.class);

//        System.out.println("statusCode = " +loginBussiness.getStatusCode() + "reporting = " + loginBussiness.getReporting() + "exception = "+ loginBussiness.getException() + "displayMessage = "+loginBussiness.getDisplayMessage()
//                + "data = " + loginBussiness.getData());
        return loginBussiness;
    }
    public static ThirdPartySecondRseponse jsonToJavaObject1(String jsonStr) throws JsonProcessingException {
//        String jsonStr="{\"statusCode\":\"200\",\"reporting\":null,\"exception\":null,\"displayMessage\":\"Your request has been processes successfully.\"" +
//                ",\"data\":{\"authToken\":\"3985cc95-37c5-43f8-b380-d70cdf575b9c\"" +
//                ",\"integrationToken\":\"\",\"id\":\"126003\",\"name\":\"c-heba\",\"resourceType\":\"cleaner\",\"workerStatus\":\"working\",\"posPollingTime\":\"60\"}}\n";

//        String jsonStr = RestClient.getResponse("https://esbtest.sn3.com.sa:443/cxf/loginwfmroute/wfm/login" , "{\"loginWfmEsbRequest\":{\"username\":\"126003\",\"password\":\"aaa\",\"lang\":\"en\",\"channel\":\"wfm\"}}");

        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(jsonStr);

        ThirdPartySecondRseponse thirdPartySecondRseponse = objectMapper.readValue(jsonStr, ThirdPartySecondRseponse.class);

//        System.out.println("statusCode = " +loginBussiness.getStatusCode() + "reporting = " + loginBussiness.getReporting() + "exception = "+ loginBussiness.getException() + "displayMessage = "+loginBussiness.getDisplayMessage()
//                + "data = " + loginBussiness.getData());
        return thirdPartySecondRseponse;
    }
}
