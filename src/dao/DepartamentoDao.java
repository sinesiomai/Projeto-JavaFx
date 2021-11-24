package dao;

import java.util.List;

import entities.Departamento;

public interface DepartamentoDao {

	void insert(Departamento obj);

	void update(Departamento obj);

	void deleteById(Integer id);

	Departamento findById(Integer id);

	List<Departamento> findAll();

}
