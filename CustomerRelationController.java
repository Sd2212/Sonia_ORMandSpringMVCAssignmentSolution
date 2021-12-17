package com.management.customer.relation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.management.customer.relation.entity.CustomerRelation;
import com.management.customer.relation.service.CustomerRelationService;

@Controller
@RequestMapping("/customer")
public class CustomerRelationController {

	@Autowired
	private CustomerRelationService customerService;

	@RequestMapping("/List")
	public String listCustomers(Model theModel) {

		List<CustomerRelation> theCustomerRelations = customerService.findAll();

		// add to the spring model
		theModel.addAttribute("CustomerRelations", theCustomerRelations);

		return "CustomerList";
	}

	@RequestMapping("/Add")
	public String addCustomer(Model theModel) {

		CustomerRelation theCustomerRelation = new CustomerRelation();

		theModel.addAttribute("CustomerRelation", theCustomerRelation);

		return "CustomerForm";
	}

	@RequestMapping("/Update")
	public String updateCustomer(@RequestParam("custId") int id, Model theModel) {

		CustomerRelation theCustomerRelation = customerService.findById(id);

		theModel.addAttribute("CustomerRelation", theCustomerRelation);

		return "CustomerForm";
	}

	@PostMapping("/Save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("emailid") String emailid) {

		System.out.println(id);
		CustomerRelation theCustomerRelation;
		if (id != 0) {
			theCustomerRelation = customerService.findById(id);
			theCustomerRelation.setFirstname(firstname);
			theCustomerRelation.setLastname(lastname);
			theCustomerRelation.setEmailid(emailid);
		} else
			theCustomerRelation = new CustomerRelation(firstname, lastname, emailid);

		customerService.save(theCustomerRelation);

		return "redirect:/customer/List";

	}

	@RequestMapping("/Delete")
	public String delete(@RequestParam("custId") int id) {

		customerService.deleteById(id);

		return "redirect:/customer/List";

	}

}
