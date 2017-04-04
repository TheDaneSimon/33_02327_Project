package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;

import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;


public class ProduktBatchTest {
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

		MySQLProduktBatchDAO pb = new MySQLProduktBatchDAO();

		System.out.println("ProduktBatch med pb_id: 1");
		try {
			System.out.println(pb.getProduktBatch(1));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("ProduktBatchList");
		try {
			System.out.println(pb.getProduktBatchList());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Create af ProduktBatch med pb_id 4");
		try {
			System.out.println(pb.getProduktBatchList());
			pb.createProduktBatch(new ProduktBatchDTO(6, 1, 1));
			System.out.println(pb.getProduktBatchList());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Update af ProduktBatch med pb_id 4");
		try {
			System.out.println(pb.getProduktBatchList());
			pb.updateProduktBatch(new ProduktBatchDTO(4, 2, 3));
			System.out.println(pb.getProduktBatchList());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

	}
}
