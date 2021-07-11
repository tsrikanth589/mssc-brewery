package guru.springframework.msscbrewery.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.dto.CustomerDto;
import guru.springframework.msscbrewery.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID customerId) {
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<CustomerDto> saveNewCustomer(@RequestBody CustomerDto customerDto) {
		CustomerDto savedDto = customerService.saveNewCustomer(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		//to do add project url
		headers.add("Location", "/api/v1/customer/" + savedDto.getId().toString());
		
		return new ResponseEntity<CustomerDto>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto) {
		customerService.udpateCustomer(customerId, customerDto);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomerById(@PathVariable UUID customerId) {
		customerService.deleteCustomerById(customerId);
	}
}
