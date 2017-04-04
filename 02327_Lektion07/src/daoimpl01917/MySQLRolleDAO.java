package daoimpl01917;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptKompDAO;
import daointerfaces01917.RolleDAO;
import dto01917.ReceptKompDTO;
import dto01917.RolleDTO;

public class MySQLRolleDAO implements RolleDAO{

	@Override
	@Override
	public void createReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call createReceptKomp(?,?,?,?);");

			ps.setInt(1, receptkomponent.getReceptId());
			ps.setInt(2, receptkomponent.getRaavareId());
			ps.setDouble(3, receptkomponent.getNomNetto());
			ps.setDouble(4, receptkomponent.getTolerance());

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
	public void updateReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call updateReceptKomp(?,?,?,?);");

			ps.setInt(1, receptkomponent.getReceptId());
			ps.setInt(2, receptkomponent.getRaavareId());
			ps.setDouble(3, receptkomponent.getNomNetto());
			ps.setDouble(4, receptkomponent.getTolerance());

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
	public List<RolleDTO> getOprRolleList(int opr_id) throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call getOprRolleListById(?);");

			ps.setInt(1, opr_id);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) throw new DALException("Rolle: " + opr_id + " findes ikke");

			rs.next();

			List<RolleDTO> rolleList = new ArrayList<RolleDTO>();

			while(rs.next()){

				rolleList.add(
						new RolleDTO(
								rs.getInt("opr_id"),
								rs.getString("rolle")));
			}
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
	public List<RolleDTO> getRolleList() {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call getRolleList();");

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) throw new DALException("Ingen elementer in Rolle tabel");

			rs.next();

			List<RolleDTO> rolleList = new ArrayList<RolleDTO>();

			while(rs.next()){

				rolleList.add(
						new RolleDTO(
								rs.getInt("opr_id"),
								rs.getString("rolle")));
			}
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
	public List<RolleDTO> getOprRolleList(String rolle) {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call getOprRolleList(?);");

			ps.setString(1, rolle);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) throw new DALException("Rolle: " + rolle + " findes ikke");

			rs.next();

			List<RolleDTO> rolleList = new ArrayList<RolleDTO>();

			while(rs.next()){

				rolleList.add(
						new RolleDTO(
								rs.getInt("opr_id"),
								rs.getString("rolle")));
			}
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
}


@Override
public void createRolle(RolleDTO rolle) {
	// TODO Auto-generated method stub

}


@Override
public void updateRolle(RolleDTO rolle) {
	// TODO Auto-generated method stub

}

}
