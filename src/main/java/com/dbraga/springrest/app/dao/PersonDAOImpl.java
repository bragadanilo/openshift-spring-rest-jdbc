package com.dbraga.springrest.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dbraga.springrest.app.domain.Person;

@Repository("personDAO")
public class PersonDAOImpl implements PersonDAO {

	private JdbcTemplate jdbcTemplate;

	public PersonDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveOrUpdate(Person person) {
		if (person.getId() > 0) {
			// update
			String sql = "UPDATE person SET name=?, email=?, address=?, telephone=? WHERE id=?";
			jdbcTemplate.update(sql, person.getName(), person.getEmail(), person.getId());
		} else {
			// insert
			String sql = "INSERT INTO person (name, email, address, telephone) VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, person.getName(), person.getEmail());
		}

	}

	public void delete(int personId) {
		String sql = "DELETE FROM person WHERE id=?";
		jdbcTemplate.update(sql, personId);
	}

	@Override
	public List<Person> list() {
		String sql = "SELECT * FROM person";
		List<Person> listContact = jdbcTemplate.query(sql, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person aContact = new Person();
				aContact.setId(rs.getInt("id"));
				aContact.setName(rs.getString("name"));
				aContact.setEmail(rs.getString("email"));
				return aContact;
			}
		});

		return listContact;
	}

	public Person get(int personId) {
		String sql = "SELECT * FROM person WHERE id=" + personId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Person>() {

			@Override
			public Person extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Person person = new Person();
					person.setId(rs.getInt("id"));
					person.setName(rs.getString("name"));
					person.setEmail(rs.getString("email"));
					return person;
				}
				return null;
			}

		});
	}

}
