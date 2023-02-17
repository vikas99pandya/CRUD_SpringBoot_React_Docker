package nl.docker.backend.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import nl.docker.backend.model.Customer;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/version_1/")
public class CustomerController {

	private final Map<Long, Customer> custMap= new HashMap();

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return new ArrayList(custMap.values()) ;
    }    
    
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return custMap.put(customer.getId(), customer);
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer ret = custMap.get(id);
		return ResponseEntity.ok(ret);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
		Customer ret = custMap.get(id);

		ret.setAddress(customer.getAddress());
		ret.setName(customer.getName());
		ret.setEmail(customer.getEmail());

		return ResponseEntity.ok(ret);
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		Customer ret = custMap.remove(id);
		return ResponseEntity.ok(Boolean.TRUE);
	}
}
