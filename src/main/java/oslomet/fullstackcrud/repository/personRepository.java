package oslomet.fullstackcrud.repository;

import oslomet.fullstackcrud.models.Person;
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

    public void insertPerson(Person person) {
        String sql = "INSERT INTO person (name, year, description) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, person.getName(), person.getYear(), person.getDescription());
    }

    public void updatePerson(Person person){
        String sql = "UPDATE person SET name = ?, year = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(sql, person.getName(), person.getYear(), person.getDescription(), person.getId());
    }

    public void deletePerson(Person person){
        String sql = "DELETE FROM person WHERE id = ?";
        jdbcTemplate.update(sql, person.getId());
    }

    public List<Person> getAllPeople(){
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, personRowMapper);
    }
}
