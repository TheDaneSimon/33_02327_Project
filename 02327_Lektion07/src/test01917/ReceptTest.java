package test01917;

import java.sql.SQLException;

import connector01917.Connector;

import daoimpl01917.MySQLReceptDAO;
import daointerfaces01917.DALException;
import dto01917.ReceptDTO;

public class ReceptTest {
	public static void main(String[] args){
		try {
			new Connector();
		} catch (InstantiationException e){
			e.printStackTrace();
		} catch (IllegalAccessException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		MySQLReceptDAO rc = new MySQLReceptDAO();
		try{
			rc.createRecept(new ReceptDTO(5, "Spaghetti"));
			System.out.println(rc.getRecept(5));
			System.out.println(rc.getReceptList());
			
			rc.updateRecept(new ReceptDTO(1, "margherita"));
			System.out.println(rc.getReceptList());
		} catch (DALException e){
			e.printStackTrace();
		}
	}
}
