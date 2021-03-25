package com.taizo.employer.model.company;

import com.taizo.employer.model.industry.IndustryModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "company_industry_rel", schema = "employer")
public class CompanyIndustryModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="com_ind_id")
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="com_id", nullable=false)
    private CompanyModel company;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="i_id", nullable=false)
    private IndustryModel industry;
    @Column(name="com_ind_desc")
    private String companyIndustryDesc;
}