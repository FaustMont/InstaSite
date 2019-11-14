package by.instasite.database.user;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class UserTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
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
