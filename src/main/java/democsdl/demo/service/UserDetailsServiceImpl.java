package democsdl.demo.service;

import java.util.ArrayList;
import java.util.List;
import democsdl.demo.dto.CustomerDto;
import democsdl.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerDto customerDto;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Customer customer = this.customerDto.findCustomerAccount(userName);

        if (customer == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + customer);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        UserDetails userDetails = (UserDetails) new User(customer.getUsername(), //
                customer.getPassword(), grantList);
        return userDetails;
    }

}