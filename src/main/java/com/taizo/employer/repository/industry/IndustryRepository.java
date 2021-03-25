package com.taizo.employer.repository.industry;

import com.taizo.employer.model.industry.IndustryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IndustryRepository extends CrudRepository<IndustryModel, Long> {

}
