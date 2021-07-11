package guru.springframework.msscbrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		
		return CustomerDto.builder()
							.id(customerId)
							.name("John")
							.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		
		return CustomerDto.builder()
							.id(UUID.randomUUID())
							.name(customerDto.getName())
							.build();
	}

	@Override
	public void udpateCustomer(UUID id, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		log.debug("updating the customer...");
	}

	@Override
	public void deleteCustomerById(UUID customerId) {
		// TODO Auto-generated method stub
		log.debug("Deleting the customer");
	}
	
	

	
}
