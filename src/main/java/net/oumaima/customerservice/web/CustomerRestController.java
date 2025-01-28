package net.oumaima.customerservice.web;

import net.oumaima.customerservice.entities.Customer;
import net.oumaima.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer getCustomerByid(@PathVariable(name = "id") Long id){
        return customerRepository.findById(id).get();
    }
    @PostMapping("/customers")
    public Customer save( @RequestBody Customer customer){
        return customerRepository.save(customer);
    }
    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable(name = "id") Long id){
         customerRepository.deleteById(id);
    }

    @PutMapping("/customers/{id}")
    public Customer save(@PathVariable Long id, @RequestBody Customer customerDto){
        Customer customer = customerRepository.findById(id).get();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        return customerRepository.save(customer);
    }
}
