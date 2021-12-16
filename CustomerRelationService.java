package com.management.customer.relation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.management.customer.relation.entity.CustomerRelation;

@Service
public interface CustomerRelationService {

	public List<CustomerRelation> findAll();

	public CustomerRelation findById(int id);

	public void save(CustomerRelation theCustomerRelation);

	public void deleteById(int id);

}
