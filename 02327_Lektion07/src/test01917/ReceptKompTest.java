package test01917;

import java.sql.SQLException;

import connector01917.Connector;

import daoimpl01917.MySQLReceptKompDAO;
import daointerfaces01917.DALException;

import dto01917.ReceptKompDTO;

public class ReceptKompTest {
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
		
		MySQLReceptKompDAO rk = new MySQLReceptKompDAO();
		
		System.out.println("Get ReceptKomp 1,2");
		try { 
			System.out.println(rk.getReceptKomp(1, 4)); 
		}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
		}
		
		System.out.println("Get ReceptKomp 1");
		try {
			System.out.println(rk.getReceptKompList(1));
		}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
		}
		
		System.out.println("Recept list");
		try {
			System.out.println(rk.getReceptKompList());
		}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
		}
		
		System.out.println("Create  ReceptKomp list");
		try {
			System.out.println(rk.getReceptKompList());
			rk.createReceptKomp(new ReceptKompDTO(3, 2, 0.4, 10.4));
			System.out.println(rk.getReceptKompList());
		}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
		}
		
		System.out.println("Update af ReceptKomp med pb_id 4 og rb_id 2");
		try {
			System.out.println(rk.getReceptKomp(3, 2));
			rk.updateReceptKomp(new ReceptKompDTO(3, 2, 0.4, 1000.4));
			
			System.out.println(rk.getReceptKomp(3, 2));
		}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
		}
		
	}

}
