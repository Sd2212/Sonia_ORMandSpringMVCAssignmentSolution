package com.management.customerrelation.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.management.customerrelation.entity.CustomerRelation;

@Service
public interface CustomerRelationService {

	public List<CustomerRelation> findAll();

	public CustomerRelation findById(int theId);

	public void save(CustomerRelation theCustomerRelation);

	public void deleteById(int theId);

}
