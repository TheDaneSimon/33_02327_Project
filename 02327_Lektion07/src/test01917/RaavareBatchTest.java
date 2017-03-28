package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLOperatoerDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daointerfaces01917.DALException;

public class RaavareBatchTest {
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
		MySQLRaavareBatchDAO rb = new MySQLRaavareBatchDAO();
		try {
			System.out.println(rb.getRaavareBatch(5));
			System.out.println(rb.getRaavareBatchList());
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

