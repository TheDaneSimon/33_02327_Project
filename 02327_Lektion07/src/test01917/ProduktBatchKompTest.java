package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchKompDTO;

public class ProduktBatchKompTest {

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
		
		MySQLProduktBatchKompDAO pbk = new MySQLProduktBatchKompDAO();
		
		System.out.println("ProduktBatchKomp med pb_id: 1 og rb_id: 2");
		try { 
			System.out.println(pbk.getProduktBatchKomp(1, 2)); 
		}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
		}
		
		System.out.println("ProduktBatchKompList med pb_id: 1");
		try {
			System.out.println(pbk.getProduktBatchKompList(1));
		}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
		}
		
		System.out.println("ProduktBatchKompList");
		try {
			System.out.println(pbk.getProduktBatchKompList());
		}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
		}
		
		System.out.println("Create af ProduktBatchKomp med pb_id 4");
		try {
			System.out.println(pbk.getProduktBatchKompList(4));
			pbk.createProduktBatchKomp(new ProduktBatchKompDTO(4, 2, 0.4, 10.4, 1));
			System.out.println(pbk.getProduktBatchKompList(4));
		}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
		}
		
		System.out.println("Update af ProduktBatchKomp med pb_id 4 og rb_id 2");
		try {
			System.out.println(pbk.getProduktBatchKomp(4, 2));
			pbk.updateProduktBatchKomp(new ProduktBatchKompDTO(4, 2, 0.2, 10.2, 2));
			System.out.println(pbk.getProduktBatchKomp(4, 2));
		}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
		}
		
	}

}
