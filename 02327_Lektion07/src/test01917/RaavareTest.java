package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MYSQLRaavareDAO;

import daointerfaces01917.DALException;

import dto01917.RaavareDTO;

public class RaavareTest {
	public static void main(String[] args) {
		try {
			new Connector();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MYSQLRaavareDAO r = new MYSQLRaavareDAO();
		try {
			
			r.createRaavare(new RaavareDTO(69,"Hvidløg","Garlic Italia"));
			System.out.println(r.getRaavare(69));
			System.out.println(r.getRaavareList());
			r.updateRaavare(new RaavareDTO(69,"Hvidløg","Italian Garlic"));
			System.out.println(r.getRaavare(69));
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
