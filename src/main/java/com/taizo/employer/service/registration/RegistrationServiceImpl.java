package com.taizo.employer.service.registration;

import com.taizo.employer.model.CompanyRegistration;
import com.taizo.employer.model.company.CompanyIndustryContactModel;
import com.taizo.employer.model.company.CompanyIndustryModel;
import com.taizo.employer.model.company.CompanyModel;
import com.taizo.employer.model.industry.IndustryModel;
import com.taizo.employer.repository.industry.IndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    IndustryRepository industryRepository;

    @Override
    public boolean registerCompany(CompanyRegistration companyRegistration) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        CompanyModel companyModel = new CompanyModel();
        companyModel.setCompanyName(companyRegistration.getCompanyName());
        companyModel.setCompanyDesc(companyRegistration.getCompanyDesc());
        companyModel.setCompanyTurnOver(companyRegistration.getCompanyNetWorth());
        companyModel.setCompanyStartYear(companyRegistration.getCompanyStartYr());
        entityManager.persist(companyModel);

        IndustryModel industryModel = industryRepository
                .findById(Long.parseLong(companyRegistration.getCompanyIndDesc())).orElse(null);

        CompanyIndustryModel companyIndustryModel = new CompanyIndustryModel();
        companyIndustryModel.setCompany(companyModel);
        companyIndustryModel.setIndustry(industryModel);
        entityManager.persist(companyIndustryModel);

        CompanyIndustryContactModel companyIndConModel = new CompanyIndustryContactModel();
        companyIndConModel.setCompanyIndustryPincode(companyRegistration.getCompanyContactPincode());
        companyIndConModel.setCompanyIndustryLandline(companyRegistration.getCompanyContactLandline());
        companyIndConModel.setCompanyIndustryEmail(companyRegistration.getCompanyContactEmail());
        companyIndConModel.setCompanyIndustry(companyIndustryModel);
        companyIndConModel.setCompanyIndustryMobile(companyRegistration.getCompanyContactMobile());
        companyIndConModel.setCompanyIndustryAddress(companyRegistration.getCompanyContactAddress());
        entityManager.persist(companyIndConModel);

        entityManager.getTransaction().commit();
        entityManager.close();

        return true;
    }
}
