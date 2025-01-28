package net.oumaima.customerservice;

import net.oumaima.customerservice.entities.Customer;
import net.oumaima.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer customer= Customer.builder()
                    .name("Oumaima")
                    .email("ouma@gmail.com")
                    .build();
            customerRepository.save(customer);
            customerRepository.save(Customer.builder()
                            .name("Oussama")
                            .email("ous@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Meryam")
                    .email("mery@gmail.com")
                    .build());
            customerRepository.findAll().forEach(c->{
                System.out.println(c.getName());
            });
        };
    }

}
