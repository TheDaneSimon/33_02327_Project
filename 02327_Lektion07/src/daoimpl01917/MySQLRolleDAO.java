package daoimpl01917;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RolleDAO;
import dto01917.RolleDTO;

public class MySQLRolleDAO implements RolleDAO{

	@Override
	public List<RolleDTO> getOprRolleList(int opr_id) throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call getOprRolleListById(?);");

			ps.setInt(1, opr_id);

			ResultSet rs = ps.executeQuery();
			
			if (!rs.first()) throw new DALException("Ingen elementer in Rolle tabel");

			List<RolleDTO> rolleList = new ArrayList<RolleDTO>();

			do{

				rolleList.add(
						new RolleDTO(
								rs.getInt("opr_id"),
								rs.getString("rolle")));
			}while(rs.next());

			return rolleList;
		}
		catch (SQLException e) {throw new DALException(e); 
		}finally{
			try{
				ps.close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}


	@Override
	public List<RolleDTO> getRolleList() throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("SELECT * FROM getRolleList;");

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) throw new DALException("Ingen elementer in Rolle tabel");
			
			List<RolleDTO> rolleList = new ArrayList<RolleDTO>();

			do {
				rolleList.add(
						new RolleDTO(
								rs.getInt("opr_id"),
								rs.getString("rolle")));
			}while(rs.next());

			return rolleList;
		}
		catch (SQLException e) {throw new DALException(e); 
		}finally{
			try{
				ps.close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}



	@Override
	public List<RolleDTO> getOprRolleList(String rolle) throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call getOprRolleList(?);");

			ps.setString(1, rolle);

			ResultSet rs = ps.executeQuery();
			
			if (!rs.first()) throw new DALException("Ingen elementer in Rolle tabel");

			List<RolleDTO> rolleList = new ArrayList<RolleDTO>();

			do{

				rolleList.add(
						new RolleDTO(
								rs.getInt("opr_id"),
								rs.getString("rolle")));
			}while(rs.next());
				
			return rolleList;
		}
		catch (SQLException e) {throw new DALException(e); 
		}finally{
			try{
				ps.close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}



	@Override
	public void createRolle(RolleDTO rolle) throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call createRolle(?,?);");

			ps.setInt(1, rolle.getOprId());
			ps.setString(2, rolle.getRolle());

			ps.executeQuery();

		}
		catch (SQLException e) {throw new DALException(e); 
		}finally{
			try{
				ps.close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}



	@Override
	public void updateRolle(RolleDTO rolle, RolleDTO nyRolle) throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call updateRolle(?,?,?);");

			ps.setInt(1, rolle.getOprId());
			ps.setString(2, rolle.getRolle());
			ps.setString(3, nyRolle.getRolle());

			ps.executeQuery();

		}
		catch (SQLException e) {throw new DALException(e); 
		}finally{
			try{
				ps.close();
			}catch(Exception e){
				System.out.println(e);
			}
		}

	}

}
