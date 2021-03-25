package com.taizo.employer.controller.industry;

import com.taizo.employer.config.DataSourceConfig;
import com.taizo.employer.service.industry.IndustryService;
import com.taizo.employer.service.industry.IndustryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class IndustryController {

    @Autowired
    IndustryService industryService;

    private static final Logger logger = LogManager.getLogger(IndustryController.class);

    @PostMapping(value = "/v1/saveIndustry", produces = { "application/json" })
    public String saveIndustry(@RequestParam(name="industryName") String industryName,
                                     @RequestParam(name="industryDesc") String industryDesc) {
        logger.info(industryName + " ----- " + industryDesc);
        industryService.storeIndustry(industryName, industryDesc);
        return "success";
    }

}
