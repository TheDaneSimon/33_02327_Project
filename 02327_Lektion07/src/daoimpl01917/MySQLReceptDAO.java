package daoimpl01917;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptDAO;
import dto01917.ReceptDTO;

public class MySQLReceptDAO implements ReceptDAO {

	@Override
	public ReceptDTO getRecept(int receptId) throws DALException {
		Connection c = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		// Attempt to send a query database.
		try {
			ps = c.prepareStatement("CALL getRecept(?);");
			ps.setInt(1, receptId);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		try {
			if (!rs.first())
				throw new DALException("Recepten " + receptId + " findes ikke");
			return new ReceptDTO(rs.getInt("recept_id"), rs.getString("recept_navn"));
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

	@Override
	public List<ReceptDTO> getReceptList() throws DALException {
		List<ReceptDTO> receptList = new ArrayList<ReceptDTO>();
		Connection c = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = c.prepareStatement("SELECT * FROM recept;");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			while (rs.next()) {
				receptList.add(new ReceptDTO(rs.getInt("recept_Id"), rs.getString("recept_navn")));
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
		return receptList;
	}

	@Override
	public void createRecept(ReceptDTO recept) throws DALException {
		Connection c = Connector.getConnection();
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement("CALL createRecept( ?,? );");

			ps.setInt(1, recept.getReceptId());
			ps.setString(2, recept.getReceptNavn());
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

	@Override
	public void updateRecept(ReceptDTO recept) throws DALException {
		Connection c = Connector.getConnection();
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement("CALL updateRecept( ?,? );");

			ps.setInt(1, recept.getReceptId());
			ps.setString(2, recept.getReceptNavn());
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

}
