package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLOperatoerDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daointerfaces01917.DALException;
import dto01917.RaavareBatchDTO;

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
			
			rb.createRaavareBatch(new RaavareBatchDTO(123,4,100));
			System.out.println(rb.getRaavareBatch(123));
			System.out.println(rb.getRaavareBatchList());
			rb.updateRaavareBatch(new RaavareBatchDTO(123,5,2320));
			System.out.println(rb.getRaavareBatchList(5));
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

