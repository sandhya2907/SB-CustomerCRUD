package in.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	

}
