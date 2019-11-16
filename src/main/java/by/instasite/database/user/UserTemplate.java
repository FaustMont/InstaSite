package by.instasite.database.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;


public class UserTemplate extends JdbcDaoSupport {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setData(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getUserByUsername(String username) {
        String SQL = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{username}, new UserMapper());
    }

    public void createUser(String username, String password, String email, String country) {
        String SQL = "INSERT INTO users (username, password, email, country) VALUES (?,?,?,?)";
        jdbcTemplate.update(SQL, username, password, email, country);
    }

}
