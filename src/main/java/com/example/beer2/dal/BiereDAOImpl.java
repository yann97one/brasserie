package com.example.beer2.dal;

import com.example.beer2.bo.Biere;
import com.example.beer2.bo.TypeBiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BiereDAOImpl implements BiereDAO{

    private static final String INSERT_QUERY = "INSERT INTO BIERE (nom,ty_biere,description,dg_alcool,note) VALUES (:nom,:ty_biere,:description,:dg_alcool,:note)";
    private static final String SELECT_BEER_OF_ONE_BREWERY_QUERY = "SELECT * FROM BIERE WHERE id_brasserie =:id_brasserie";
    private static final String SELECT_QUERY = "SELECT * FROM BIERE";


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    RowMapper<Biere> rowMapper = (rs,rowNum)->{
        Biere biere = new Biere();
        biere.setId_biere(rs.getInt("id_biere"));
        biere.setNom(rs.getString("nom"));
        biere.setTy_biere(rs.getObject("ty_biere", TypeBiere.class));
        biere.setDescription(rs.getString("description"));
        biere.setDg_alcool(rs.getDouble("dg_alcool"));
        biere.setNote(rs.getInt("note"));
        return biere;
    };

    @Override
    public void ajouterBiere(Biere biere) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("nom",biere.getNom());
        namedParameters.addValue("ty_biere",biere.getTy_biere());
        namedParameters.addValue("description",biere.getDescription());
        namedParameters.addValue("dg_alcool",biere.getDg_alcool());
        namedParameters.addValue("note",biere.getNote());

        jdbcTemplate.update(INSERT_QUERY,namedParameters);
    }

    @Override
    public List<Biere> listerBiereBrasserie(Integer idBrasserie) {
        MapSqlParameterSource np = new MapSqlParameterSource();
        np.addValue("id_brasserie",idBrasserie);

        return jdbcTemplate.query(SELECT_BEER_OF_ONE_BREWERY_QUERY,np,rowMapper);
    }

    @Override
    public List<Biere> listerBiere() {
        return jdbcTemplate.query(SELECT_QUERY,rowMapper);
    }
}
