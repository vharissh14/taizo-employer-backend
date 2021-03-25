package com.taizo.employer.model.company;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "company_industry_contact_det", schema = "employer")
public class CompanyIndustryContactModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="com_ind_con_id")
    private Long id;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="com_ind_id", nullable=false)
    private CompanyIndustryModel companyIndustry;
    @Column(name="com_ind_email")
    private String companyIndustryEmail;
    @Column(name="com_ind_mobile")
    private String companyIndustryMobile;
    @Column(name="com_ind_address")
    private String companyIndustryAddress;
    @Column(name="com_ind_landline")
    private String companyIndustryLandline;
    @Column(name="com_ind_pincode")
    private String companyIndustryPincode;
}