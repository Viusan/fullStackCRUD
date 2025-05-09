package repository;

import models.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class personRepository {
    private final JdbcTemplate jdbcTemplate;//this will handle the connection between database and server

    public personRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected static final RowMapper<Person> personRowMapper = (rs, rowNum) ->
            new Person(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("year"),
                    rs.getString("description")
            );

    public List<Person> getAllPerson(){
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, personRowMapper);
    }
}
