package in.nit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import in.nit.model.Customer;
import in.nit.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@RequestMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("customer", new Customer());
		return "CustomerRegisterPage";

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute Customer c, Model model) {
		Integer id = service.saveCustomer(c);
		String message = "Customer record saved id: " + id;
		model.addAttribute("msg", message);
		// form backing object
		model.addAttribute("customer", new Customer());
		return "CustomerRegisterPage";

	}

	@RequestMapping("/all")
	public String accessAllCustomerData(Model model) {
		List<Customer> list = service.getAllCustomers();
		model.addAttribute("list", list);
		return "CustomerData";

	}

	@RequestMapping("/delete/{id}")
	public String removeCustomer(@PathVariable Integer id, Model model) {
		String msg = null;
		if (service.isExist(id)) {
			service.deleteCustomer(id);
			msg = "Delete Records " + id;

		} else {
			msg = "Records not Found";
		}
		model.addAttribute("msg", msg);
		List<Customer> list = service.getAllCustomers();
		model.addAttribute("list", list);
		return "CustomerData";

	}

	@RequestMapping("/edit/{id}")
	public String editCustomer(@PathVariable Integer id, Model model) {
		String page=null;
		Optional<Customer> opt = service.getOne(id);
		if (opt.isPresent()) {
			Customer c = opt.get();
			//form backing object
			model.addAttribute("customer",c);
			page="EditCustomerPage";
		}else {
			
			page="redirect.../all";
		}
		return page;

	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute Customer c,Model model) {
		service.updateCustomer(c);
		String message="Update record:"+c.getCid();
		model.addAttribute("msg",message);
		//form backing object
		List<Customer> list = service.getAllCustomers();
		model.addAttribute("list", list);
		return "CustomerData";
		
	}

}
