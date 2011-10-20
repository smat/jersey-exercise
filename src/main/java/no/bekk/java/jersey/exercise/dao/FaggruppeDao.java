package no.bekk.java.jersey.exercise.dao;

import no.bekk.java.jersey.exercise.model.Faggruppe;
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
public class FaggruppeDao {

    private final SimpleJdbcTemplate template;
    private final SimpleJdbcInsert insert;

    @Autowired
    public FaggruppeDao(final DataSource dataSource) {
        template = new SimpleJdbcTemplate(dataSource);
        insert = new SimpleJdbcInsert(dataSource).withTableName("faggruppe").usingGeneratedKeyColumns("id");
    }

    public Faggruppe getById(long id) {
        return template.queryForObject("SELECT * FROM faggruppe WHERE id = ?", new FaggruppeRowMapper(), id);
    }

    public Faggruppe insert(Faggruppe faggruppe) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("NAVN", faggruppe.getNavn());
        map.put("FAGGRUPPESJEFID", faggruppe.getFagruppesjefId());

        Number key = insert.executeAndReturnKey(map);

        faggruppe.setId(key.longValue());

        return faggruppe;
    }

    public List<Faggruppe> list() {
        return template.query("SELECT * FROM faggruppe", new FaggruppeRowMapper());
    }

    public boolean delete(long id) {
        return template.update("DELETE FROM faggruppe where id = ?", id) == 1;
    }

    public class FaggruppeRowMapper implements RowMapper<Faggruppe> {
        public Faggruppe mapRow(ResultSet rs, int rowNum) throws SQLException {
            Faggruppe faggruppe = new Faggruppe();

            faggruppe.setId(rs.getLong("ID"));
            faggruppe.setNavn(rs.getString("NAVN"));
            faggruppe.setFagruppesjefId(rs.getLong("FAGGRUPPESJEFID"));

            return faggruppe;
        }
    }

}
