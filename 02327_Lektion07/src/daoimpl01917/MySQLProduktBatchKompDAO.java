package daoimpl01917;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchKompDAO;
import dto01917.ProduktBatchKompDTO;

public class MySQLProduktBatchKompDAO implements ProduktBatchKompDAO {
	

	@Override
	public ProduktBatchKompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException {
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		// Sends a query database.
		try {
			ps = conn.prepareStatement("CALL getProduktBatchKomp(?, ?);");
			ps.setInt(1, pbId);
			ps.setInt(2, rbId);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		try {
			if (!rs.first())
				throw new DALException("ProduktBatchKomp med pb_id: " + pbId + " og rb_id: " + rbId + " findes ikke.");
			return new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"),
					rs.getDouble("netto"), rs.getInt("opr_id"));
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
	public List<ProduktBatchKompDTO> getProduktBatchKompList(int pbId) throws DALException {
		List<ProduktBatchKompDTO> produktBatchKompList = new ArrayList<ProduktBatchKompDTO>();
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		// Sends a query database.
		try {
			ps = conn.prepareStatement("CALL getProduktBatchKompList(?);");
			ps.setInt(1, pbId);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		try {
			if (!rs.first())
				throw new DALException("ProduktBatchKompList med pb_id: " + pbId + " findes ikke.");
			while(rs.next()) {
				produktBatchKompList.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
			return produktBatchKompList;
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
	public List<ProduktBatchKompDTO> getProduktBatchKompList() throws DALException {
		List<ProduktBatchKompDTO> produktBatchKompList = new ArrayList<ProduktBatchKompDTO>();
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		// Sends a query database.
		try {
			ps = conn.prepareStatement("SELECT * FROM getProduktBatchKompList;");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		try {
			if (!rs.first())
				throw new DALException("Der findes ingen ProduktBatchKomponent liste.");
			while(rs.next()) {
				produktBatchKompList.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
			return produktBatchKompList;
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
	public void createProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("CALL createProduktBatchKomp(?, ?, ?, ?, ?);");

			ps.setInt(1, produktbatchkomponent.getPbId());
			ps.setInt(2, produktbatchkomponent.getRbId());
			ps.setDouble(3, produktbatchkomponent.getTara());
			ps.setDouble(4, produktbatchkomponent.getNetto());
			ps.setInt(5, produktbatchkomponent.getOprId());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			System.out.println("No changes were made.\n");
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
	public void updateProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("CALL updateProduktBatchKomp(?, ?, ?, ?, ?);");

			ps.setInt(1, produktbatchkomponent.getPbId());
			ps.setInt(2, produktbatchkomponent.getRbId());
			ps.setDouble(3, produktbatchkomponent.getTara());
			ps.setDouble(4, produktbatchkomponent.getNetto());
			ps.setInt(5, produktbatchkomponent.getOprId());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			System.out.println("No changes were made.\n");
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