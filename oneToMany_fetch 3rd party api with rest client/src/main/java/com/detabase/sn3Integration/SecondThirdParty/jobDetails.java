package com.detabase.sn3Integration.SecondThirdParty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class jobDetails {

    private String jobId;
    private String jodDescription;
    private String orderIdMagento;
    private String direction;
    private String zone;
    private String agreedDate;
    private String duration;
    private String contactNameCustomer;
    private String contactPhoneNumberCustomer;
    private String instructions;
    private String paymentMethodCashOnDelivery;
    private String typeOfService;
}
