package com.taizo.employer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
@ToString
public class CompanyRegistration {
    private String companyName;
    private String companyDesc;
    private Integer companyStartYr;
    private String companyNetWorth;
    private String companyIndDesc;
    private String companyContactEmail;
    private String companyContactMobile;
    private String companyContactAddress;
    private String companyContactLandline;
    private String companyContactPincode;
}