package in.mitransoftwares.ecommerce.controller.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.mitransoftwares.ecommerce.entity.customer.Customer;
import in.mitransoftwares.ecommerce.service.customer.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customers")
	public List<Customer> customerList(){
		List<Customer> cuslist=new ArrayList<>();
		Customer cus1=new Customer();
		cus1.setFirstName("Nikil");
		cus1.setLastName("Kumar");
		Customer cus2=new Customer();
		cus2.setFirstName("Arun");
		cus2.setLastName("Balaji");
		cuslist.add(cus1);
		cuslist.add(cus2);
		return cuslist;
		
	}
}
