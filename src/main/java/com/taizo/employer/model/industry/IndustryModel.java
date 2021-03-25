package com.taizo.employer.model.industry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "industry", schema = "employer")
public class IndustryModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="i_id")
    private Long id;
    @Column(name="i_name")
    private String industryName;
    @Column(name="i_desc")
    private String industryDesc;
}
