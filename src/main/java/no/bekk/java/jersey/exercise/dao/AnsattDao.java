package no.bekk.java.jersey.exercise.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import no.bekk.java.jersey.exercise.model.Ansatt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AnsattDao {

	private final SimpleJdbcTemplate template;
	private final SimpleJdbcInsert insert;

	@Autowired
	public AnsattDao(final DataSource dataSource) {
		template = new SimpleJdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource).withTableName("ansatt").usingGeneratedKeyColumns("id");
	}

	public Ansatt getById(final long id) {
		try {
			return template.queryForObject("select * from ansatt where id = ?", new AnsattRowMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).build());
		}
	}

	public boolean deleteById(final long id) {
		return template.update("delete from ansatt where id = ?", id) == 1;
	}

	public Ansatt insert(final Ansatt ansatt) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("FORNAVN", ansatt.getFornavn());
		map.put("ETTERNAVN", ansatt.getEtternavn());

		Number key = insert.executeAndReturnKey(map);

		ansatt.setId(key.longValue());

		return ansatt;
	}

	public List<Ansatt> list() {
		return template.query("select * from ansatt", new AnsattRowMapper());
	}

	public class AnsattRowMapper implements RowMapper<Ansatt> {
		public Ansatt mapRow(final ResultSet rs, final int rowNum) throws SQLException {
			Ansatt ansatt = new Ansatt();
			ansatt.setId(rs.getLong("ID"));
			ansatt.setFornavn(rs.getString("FORNAVN"));
			ansatt.setEtternavn(rs.getString("ETTERNAVN"));
            ansatt.setFaggruppeId(rs.getLong("FAGGRUPPEID"));
			return ansatt;
		}
	}

}
