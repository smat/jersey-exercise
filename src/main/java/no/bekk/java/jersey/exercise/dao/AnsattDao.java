package no.bekk.java.jersey.exercise.dao;

import no.bekk.java.jersey.exercise.model.Ansatt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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
		return template.queryForObject("select * from ansatt where id = ?", new AnsattRowMapper(), id);
	}

	public boolean deleteById(final long id) {
		return template.update("delete from ansatt where id = ?", id) == 1;
	}

	public Ansatt insert(final Ansatt ansatt) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("FORNAVN", ansatt.getFornavn());
		map.put("ETTERNAVN", ansatt.getEtternavn());
		map.put("FAGGRUPPEID", ansatt.getFaggruppeId());

		Number key = insert.executeAndReturnKey(map);

		ansatt.setId(key.longValue());

		return ansatt;
	}

    public List<Ansatt> list() {
		return template.query("select * from ansatt", new AnsattRowMapper());
	}

	public boolean updateFaggruppe(long ansattId, long faggruppeId) {
        return template.update("UPDATE ansatt SET faggruppeId = ? WHERE id = ?", faggruppeId, ansattId) == 1;
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
