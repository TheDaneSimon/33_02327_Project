package daoimpl01917;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.OperatoerDAO;
import dto01917.OperatoerDTO;

public class MySQLOperatoerDAO implements OperatoerDAO {

	// New method calls - not yet tested
	public OperatoerDTO getOperatoer(int oprId) throws DALException {
		Connection c = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = c.prepareStatement("CALL getOperatoer(?);");
			ps.setInt(1, oprId);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		try {
			if (!rs.first()) {
				throw new DALException("Operatoeren " + oprId + " findes ikke");
			}
			return new OperatoerDTO(rs.getInt("opr_Id"), rs.getString("opr_navn"), rs.getString("ini"),
					rs.getString("cpr"), rs.getString("password"));
		} catch (SQLException e) {
			throw new DALException(e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new DALException(e);
			}
		}
	}

	// New method calls - not yet tested
	public void createOperatoer(OperatoerDTO opr) throws DALException {
		Connection c = Connector.getConnection();
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement("CALL createOperatoer( ?, ?, ?, ?, ?);");
			ps.setInt(1, opr.getOprId());
			ps.setString(2, opr.getOprNavn());
			ps.setString(3, opr.getIni());
			ps.setString(4, opr.getCpr());
			ps.setString(5, opr.getPassword());
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No changes were made. \n");
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void updateOperatoer(OperatoerDTO opr) throws DALException {
		Connection c = Connector.getConnection();
		PreparedStatement ps = null;

		try {
			ps = c.prepareStatement("CALL updateOperatoer(?, ?, ?, ?, ?);");

			ps.setInt(1, opr.getOprId());
			ps.setString(2, opr.getOprNavn());
			ps.setString(3, opr.getIni());
			ps.setString(4, opr.getCpr());
			ps.setString(5, opr.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No changes were made. \n");
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public List<OperatoerDTO> getOperatoerList() throws DALException {
		List<OperatoerDTO> operatoerList = new ArrayList<OperatoerDTO>();
		Connection c = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = c.prepareStatement("SELECT * FROM operatoerlist;");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		try {
			while (rs.next()) {
				operatoerList.add(new OperatoerDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"),
						rs.getString("cpr"), rs.getString("password")));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new DALException(e);
			}
		}
		return operatoerList;
	}

}
