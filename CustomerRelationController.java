package com.management.customerrelation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.management.customerrelation.entity.CustomerRelation;
import com.management.customerrelation.service.CustomerRelationService;

@Controller
@RequestMapping("/customers")
public class CustomerRelationController {

	@Autowired
	private CustomerRelationService customerRelation;

	@RequestMapping("/list")
	public String listCustomer(Model theModel) {

		List<CustomerRelation> theCustomerRelations = customerRelation.findAll();

		theModel.addAttribute("CustomerRelations", theCustomerRelations);

		return "customerlist";
	}

	@RequestMapping("/Add")
	public String addCustomer(Model theModel) {

		CustomerRelation theCustomerRelation = new CustomerRelation();

		theModel.addAttribute("CustomerRelations", theCustomerRelation);

		return "customerform";
	}

	@RequestMapping("/Update")
	public String updateCustomer(@RequestParam("custId") int theId, Model theModel) {

		CustomerRelation theCustomerRelation = customerRelation.findById(theId);

		theModel.addAttribute("CustomerRelation", theCustomerRelation);

		return "customerform";
	}

	@PostMapping("/Save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("emailid") String emailid) {

		System.out.println(id);
		CustomerRelation theCustomerRelation;
		if (id != 0) {
			theCustomerRelation = customerRelation.findById(id);
			theCustomerRelation.setFirstname(firstname);
			theCustomerRelation.setLastname(lastname);
			theCustomerRelation.setEmailid(emailid);
		} else
			theCustomerRelation = new CustomerRelation(firstname, lastname, emailid);

		customerRelation.save(theCustomerRelation);

		return "redirect:/customers/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("custId") int theId) {

		customerRelation.deleteById(theId);

		return "redirect:/customers/list";

	}

}
