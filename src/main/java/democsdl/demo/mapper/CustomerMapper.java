package democsdl.demo.mapper;

import democsdl.demo.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();

        customer.setCustomer_id(rs.getInt("customer_id"));
        customer.setCustomer_name(rs.getString("username"));
        customer.setPassword(rs.getString("password"));
        return customer;
    }

    public static final String BASE_SQL //
            = "Select c.customer_id, c.username, c.password From customer c ";

}