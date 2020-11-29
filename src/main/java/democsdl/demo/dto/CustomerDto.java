package democsdl.demo.dto;

import democsdl.demo.mapper.CustomerMapper;
import democsdl.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
@Transactional
public class CustomerDto extends JdbcDaoSupport {

    @Autowired
    public CustomerDto(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public Customer findCustomerAccount(String userName) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = CustomerMapper.BASE_SQL + " where c.username = ? ";

        Object[] params = new Object[] { userName };
        CustomerMapper mapper = new CustomerMapper();
        try {
            Customer userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
