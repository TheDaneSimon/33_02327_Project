package daoimpl01917;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareDAO;
import dto01917.RaavareDTO;

public class MYSQLRaavareDAO implements RaavareDAO {

	public RaavareDTO getRaavare(int raavareId) throws DALException
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		String procedureCall = "CALL getRaavare(?);";
		
		try 
		{
			con = Connector.getConnection();
			ps = con.prepareStatement(procedureCall);
			ps.setInt(1, raavareId);
			
			//Execute procedure statement.
			ResultSet rs = ps.executeQuery();
			if(!rs.first()) {
				throw new DALException("Raavaren med id " + raavareId + " findes ikke");
			}
			return new RaavareDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		catch (SQLException e)
		{
			throw new DALException(e);
		}
		finally
		{
			if(ps != null)
			{
				try 
				{
					ps.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<RaavareDTO> getRaavareList() throws DALException
	{
		Connection con = null;
		PreparedStatement ps = null;
		List<RaavareDTO> raavareList = new ArrayList<RaavareDTO>();
		
		String viewCall = "SELECT * FROM getRaavareList;";
		
		try
		{
			con = Connector.getConnection();
			ps = con.prepareStatement(viewCall);
			ResultSet rs = ps.executeQuery();
			if (!rs.first())
			{
				throw new DALException("There exists no such view");
			}
			while(rs.next())
			{
				RaavareDTO raavare = new RaavareDTO(rs.getInt(1),rs.getString(2),rs.getString(3));
				raavareList.add(raavare);
			}
			return raavareList;
		}
		catch (SQLException e)
		{
			throw new DALException(e);
		}
		finally
		{
			if (ps != null)
			{
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void createRaavare(RaavareDTO raavare) throws DALException
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		String procedureCall = "CALL createRaavare(?,?,?);";
		
		try 
		{
			con = Connector.getConnection();
			ps = con.prepareStatement(procedureCall);
			
			ps.setInt(1, raavare.getRaavareId());
			ps.setString(2, raavare.getRaavareNavn());
			ps.setString(3, raavare.getLeverandoer());
			
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new DALException(e);
		}
		finally 
		{
			try
			{
			ps.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void updateRaavare(RaavareDTO raavare) throws DALException
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		String procedureCall = "CALL updateRaavare(?,?,?);";
		
		try
		{
			con = Connector.getConnection();
			ps = con.prepareStatement(procedureCall);
			
			ps.setInt(1, raavare.getRaavareId());
			ps.setString(2, raavare.getRaavareNavn());
			ps.setString(3, raavare.getLeverandoer());
			
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new DALException(e);
		}
		finally
		{
			try
			{
			ps.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
