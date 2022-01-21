package com.example.parkingmanagementsystem.repository;

import java.util.List;
import javax.transaction.Transactional;

import com.example.parkingmanagementsystem.model.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
@Transactional  //framework will automatically inject code to execute its methods within JDBC transactions
public class CarRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  //jdbcTemplate auto created and injected
	
	public CarRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<CarEntity> list() {
	    String sql = "SELECT * FROM studentparking";
	    List<CarEntity> listCars = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CarEntity.class));
	    return listCars;
	}
	
	public void save(CarEntity car) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate).withTableName("studentparking").usingColumns("firstname", "lastname", "make", "model", "color", "platenumber");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(car);
		insertActor.execute(param);
    }
  
    public CarEntity get(int id) {
    	String sql = "SELECT * FROM studentparking WHERE id = ?";
    	Object[] args = {id};
    	CarEntity car = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(CarEntity.class));
		return car;
    }
  
    public void update(CarEntity car) {
    	String sql = "UPDATE studentparking SET firstname=:firstname, lastname=:lastname, make=:make, model=:model, color=:color, platenumber=:platenumber WHERE id=:id";
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(car);
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
    	template.update(sql, param);
    }
  
    public void delete(int id) {
    	String sql = "DELETE FROM studentparking WHERE id = ?";
    	jdbcTemplate.update(sql, id);
    	
    	
    }

}
