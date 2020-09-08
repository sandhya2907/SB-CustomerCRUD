package in.nit.service;

import java.util.List;
import java.util.Optional;

import in.nit.model.Customer;

public interface ICustomerService {
	Integer saveCustomer(Customer c);

	List<Customer> getAllCustomers();

	void deleteCustomer(Integer id);

	boolean isExist(Integer id);
	
	public Optional<Customer> getOne(Integer id);
	
	void updateCustomer(Customer c);

}
