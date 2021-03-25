package com.taizo.employer.service.industry;

import com.taizo.employer.model.industry.IndustryModel;
import com.taizo.employer.repository.industry.IndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndustryServiceImpl implements IndustryService{
    @Autowired
    IndustryRepository industryRepository;

    @Override
    public boolean storeIndustry(String industryName, String industryDesc) {
       IndustryModel industryModel = new IndustryModel();
       industryModel.setIndustryName(industryName);
       industryModel.setIndustryDesc(industryDesc);
       return (industryRepository.save(industryModel)!=null) ? true : false;
    }
}
