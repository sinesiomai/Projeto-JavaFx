package service;

import java.util.List;

import dao.DaoFactory;
import dao.DepartamentoDao;
import entities.Departamento;

public class DepartamentoService {
	
	private DepartamentoDao dao = DaoFactory.createDepartamentoDao();

	public List<Departamento> findAll() {
		return dao.findAll();

		
	}
}
