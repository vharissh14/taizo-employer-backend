package com.taizo.employer.controller.registration;

import com.taizo.employer.controller.industry.IndustryController;
import com.taizo.employer.model.CompanyRegistration;
import com.taizo.employer.service.registration.RegistrationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    private static final Logger logger = LogManager.getLogger(RegistrationController.class);

    @PostMapping(value = "/v1/registerCompany", produces = { "application/json" })
    public String saveIndustry(CompanyRegistration companyRegistration) {
        logger.info(companyRegistration);
        registrationService.registerCompany(companyRegistration);
        return "success";
    }
}

