package democsdl.demo.controller;

import democsdl.demo.dto.CustomerDto;
import democsdl.demo.mapper.CustomerMapper;
import democsdl.demo.model.Customer;
import democsdl.demo.service.AuthService;
import democsdl.demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    CustomerDto customerDto;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AuthService authService;

    @GetMapping("api/login")
    public Customer login(@RequestParam  String username) {
        Customer customer = customerDto.findCustomerAccount(username);

        if (customer == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("Found User: " + customer);
        return customer;
    }

    @GetMapping("/get")
    public Customer getList() {
        String query = "SELECT * FROM CUSTOMER WHERE customer_id = 1";
        Customer customer = jdbcTemplate.queryForObject(
                query, new CustomerMapper());
        return customer;
    }


    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
