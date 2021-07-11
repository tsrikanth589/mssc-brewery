package guru.springframework.msscbrewery.service;

import java.util.UUID;

import guru.springframework.msscbrewery.dto.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID customerId);
	
	CustomerDto saveNewCustomer(CustomerDto customerDto);
	
	void udpateCustomer(UUID id, CustomerDto customerDto);
	
	void deleteCustomerById(UUID customerId);
}
