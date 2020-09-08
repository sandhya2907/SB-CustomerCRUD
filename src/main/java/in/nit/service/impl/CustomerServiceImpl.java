package in.nit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import in.nit.model.Customer;
import in.nit.repo.ICustomerRepository;
import in.nit.service.ICustomerService;

@Service
public class CustomerServiceImpl  implements ICustomerService{
	
	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public Integer saveCustomer(Customer c) {
		// TODO Auto-generated method stub
		return repo.save(c).getCid();
	}

	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	@Override
	public void deleteCustomer(Integer id) {
		repo.deleteById(id);
		
	}
	
	
	@Override
	public boolean isExist(Integer id) {
		boolean exist=repo.existsById(id);
		return exist;
	}
	
	@Override
	public Optional<Customer> getOne(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	
	
	@Override
	public void updateCustomer(Customer c) {
		repo.save(c);
		
	}
}

