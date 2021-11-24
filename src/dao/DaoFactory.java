 package dao;

import dao.impl.DepartamentoDaoJDBC;
import dao.impl.VendedorDaoJDBC;
import db.DB;

public class DaoFactory {

	public static DepartamentoDao createDepartamentoDao() {

		return new DepartamentoDaoJDBC(DB.getConnection());

	}

	public static VendedorDao createVendedorDao() {

		return new VendedorDaoJDBC(DB.getConnection());

	}
	
}
