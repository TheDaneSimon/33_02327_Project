package daoimpl01917;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;
import dto01917.RaavareBatchDTO;

public class MySQLProduktBatchDAO implements ProduktBatchDAO{
	
	
	@Override
	public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;


		try {
			ps = conn.prepareStatement("CALL getProduktBatch(?);");
			ps.setInt(1, pbId);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		try {
			if (!rs.first())
				throw new DALException("Operatoeren " + pbId + " findes ikke");
			return new ProduktBatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id"));
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
	public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
		
		List<ProduktBatchDTO> produktBatchList = new ArrayList<ProduktBatchDTO>();
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM getproduktbatchList;");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		try {
			while (rs.next()) {
				produktBatchList.add(new ProduktBatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id")));
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
		return produktBatchList;
	}

	
	@Override
	public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		Connection conn=Connector.getConnection();
		java.sql.PreparedStatement ps=null;
		try
		{
			ps = conn.prepareStatement("CALL createproduktbatch( ?,?,? );");
			ps.setInt(1, produktbatch.getPbId());
			ps.setInt(2, produktbatch.getStatus());
			ps.setInt(3, produktbatch.getReceptId());
			ps.execute();
			
		}
		catch(SQLException e)
		{
			throw new DALException(e);
		}
		finally
		{
			try
			{
				ps.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	}

	
	public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("CALL updateproduktbatch( ?,?,? );");
			ps.setInt(1, produktbatch.getPbId());
			ps.setInt(2, produktbatch.getStatus());
			ps.setDouble(3, produktbatch.getReceptId());
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
