package com.example.beer2.dal;

import com.example.beer2.bo.Brasserie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class BrasserieDAOImpl implements BrasserieDAO {
    private static final String SELECT_QUERY = "SELECT * FROM BRASSERIE";

    private static final String INSERT_QUERY = "INSERT INTO BRASSERIE (nom,adresse,coord_gps,dt_ouverture) VALUES (:nom,:adresse,:coord_gps,:dt_ouverture)";



    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    RowMapper<Brasserie> rowMapper = (rs,rowNum) ->{
        Brasserie brasserie = new Brasserie();
        brasserie.setId_brasserie(rs.getInt("id_brasserie"));
        brasserie.setNom(rs.getString("nom"));
        brasserie.setAdresse(rs.getString("adresse"));
        brasserie.setCoord_gps(rs.getString("coord_gps"));
        brasserie.setDt_ouverture(LocalDate.parse(rs.getString("dt_ouverture")));

        return brasserie;
    };

    @Override
    public List<Brasserie> listerBrasserie() {
        return jdbcTemplate.query(SELECT_QUERY,rowMapper);
    }

    @Override
    public List<Brasserie> listerBrasserieIPA() {
        return null;
    }

    @Override
    public void ajouterBrasserie(Brasserie brasserie) {

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("nom",brasserie.getNom());
        namedParameters.addValue("adresse",brasserie.getAdresse());
        namedParameters.addValue("coord_gps",brasserie.getCoord_gps());
        namedParameters.addValue("dt_ouverture",brasserie.getDt_ouverture());

        jdbcTemplate.update(INSERT_QUERY,namedParameters);

    }
}
