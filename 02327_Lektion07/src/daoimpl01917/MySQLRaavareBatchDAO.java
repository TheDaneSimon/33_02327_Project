package daoimpl01917;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareBatchDAO;
import dto01917.RaavareBatchDTO;

public class MySQLRaavareBatchDAO implements RaavareBatchDAO {

	@Override
	public RaavareBatchDTO getRaavareBatch(int rbId) throws DALException {

		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		// Sends a query database.
		try {
			ps = conn.prepareStatement("CALL getRaavareBatch(?);");
			ps.setInt(1, rbId);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		try {
			if (!rs.first())
				throw new DALException("RaavareBatchen med id: " + rbId + " findes ikke");
			return new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde"));
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
	public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
		List<RaavareBatchDTO> raavareList = new ArrayList<RaavareBatchDTO>();
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		// Sends a query database.
		try {
			ps = conn.prepareStatement("SELECT * FROM getRaavareBatchList;");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		try {
			while (rs.next()) {
				raavareList
						.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde")));
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
		return raavareList;
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
		List<RaavareBatchDTO> raavareList = new ArrayList<RaavareBatchDTO>();
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		// Sends a query database.
		try {
			ps = conn.prepareStatement("CALL getRaavareBatchListByRaavare(?);");
			ps.setInt(1, raavareId);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		try {
			if (!rs.first())
				throw new DALException("RaavareBatchen med id: " + raavareId + " findes ikke");
			while (rs.next()) {
				raavareList
						.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde")));
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
		return raavareList;
	}

	@Override
	public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn
					.prepareStatement("CALL createRaavareBatch( ?,?,? );");

			ps.setInt(1, raavarebatch.getRbId());
			ps.setInt(2, raavarebatch.getRaavareId());
			ps.setDouble(3, raavarebatch.getMaengde());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			System.out.println("No changes where made.\n");
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
	public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn
					.prepareStatement("CALL updateRaavareBatch( ?,?,? );");

			ps.setInt(1, raavarebatch.getRbId());
			ps.setInt(2, raavarebatch.getRaavareId());
			ps.setDouble(3, raavarebatch.getMaengde());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			System.out.println("No changes where made.\n");
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
