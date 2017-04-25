package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLRolleDAO;
import daointerfaces01917.DALException;
import dto01917.RaavareBatchDTO;
import dto01917.RolleDTO;

public class RolleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		MySQLRolleDAO rolle = new MySQLRolleDAO();

		try {
			rolle.createRolle(new RolleDTO(1, "Admin"));
			rolle.createRolle(new RolleDTO(1, "Admin"));
			rolle.createRolle(new RolleDTO(1, "JK"));
			rolle.createRolle(new RolleDTO(2, "Pharmacist"));
			rolle.createRolle(new RolleDTO(1, "Operator"));
			System.out.println("Testing getRolleList:");
			System.out.println(rolle.getRolleList());
			
			System.out.println("Testing updateRolle:");
			rolle.updateRolle(new RolleDTO(2, "Admin"), new RolleDTO(2, "Operator"));
			System.out.println(rolle.getRolleList());
			
			System.out.println("Testing getOprRolleListById");
			System.out.println(rolle.getOprRolleList(2));
			
			System.out.println("Testing getOprRolleList");
			System.out.println(rolle.getOprRolleList("Operator"));
			

		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
