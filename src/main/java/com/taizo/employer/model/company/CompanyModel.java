package com.taizo.employer.model.company;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "company", schema = "employer")
public class CompanyModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="com_id")
    private Long id;
    @Column(name="com_name")
    private String companyName;
    @Column(name="com_desc")
    private String companyDesc;
    @Column(name="com_ind_start_yr")
    private Integer companyStartYear;
    @Column(name="com_ind_fund")
    private String companyTurnOver;
}
