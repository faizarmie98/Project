package faiz.assessment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;

import faiz.assessment.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import faiz.assessment.exception.ResourceNotFoundException;
import faiz.assessment.repository.CustomersRepository;

@RestController
@RequestMapping("/api/v1")
public class CustomersController {
	@Autowired
	private CustomersRepository customersRepository;

	@GetMapping("/customers")
	public List<Customers> getAllCustomers() {
		return customersRepository.findAll();
	}

    @GetMapping("/customers/{id}")
	public ResponseEntity<Customers> getCustomersById(@PathVariable(value = "id") Long customerId)
        throws ResourceNotFoundException {
            Objects.requireNonNull(customerId, "Customer ID must not be null");
            Customers customers = customersRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        return ResponseEntity.ok().body(customers);
	}

	@PostMapping("/customers")
	public Customers createCustomers(@Valid @RequestBody Customers customers) {
        Objects.requireNonNull(customers, "Customer must not be null");
		return customersRepository.save(customers);
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customers> updateCustomers(@PathVariable(value = "id") Long customerId,
		@Valid @RequestBody Customers customersDetails) throws ResourceNotFoundException {
            Objects.requireNonNull(customerId, "Customer ID must not be null");
            Customers customers = customersRepository.findById(customerId)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

            customers.setFirstName(customersDetails.getFirstName());
            customers.setLastName(customersDetails.getLastName());
            customers.setGender(customersDetails.getGender());
            customers.setAge(customersDetails.getAge());
            customers.setPhoneNum(customersDetails.getPhoneNum());
            customers.setPersonalEmailId(customersDetails.getPersonalEmailId());
            customers.setOfficeEmailId(customersDetails.getOfficeEmailId());
            customers.setFamilyMembers(customersDetails.getFamilyMembers());
		    final Customers updatedCustomers = customersRepository.save(customers);
		    return ResponseEntity.ok(updatedCustomers);
	}

	@DeleteMapping("/customers/{id}")
	public Map<String, Boolean> deleteCustomers(@PathVariable(value = "id") Long customerId)
		throws ResourceNotFoundException {
            Objects.requireNonNull(customerId, "Customer ID must not be null");
            Customers customers = customersRepository.findById(customerId)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

            Objects.requireNonNull(customers, "Customer ID must not be null");
            customersRepository.delete(customers);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
	}
}