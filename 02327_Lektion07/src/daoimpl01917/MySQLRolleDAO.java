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
	public ReceptKompDTO getReceptKomp(int receptId, int raavareId) throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call getReceptKomp(?,?);");

			ps.setInt(1, receptId);
			ps.setInt(2, raavareId);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) throw new DALException("ReceptKomp: " + receptId + " + " + raavareId + " findes ikke");

			rs.next();

			return 
					new ReceptKompDTO(
							rs.getInt("recept_id"), 
							rs.getInt("raavare_id"), 
							rs.getDouble("nom_netto"), 
							rs.getDouble("tolerance"));

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
	public List<ReceptKompDTO> getReceptKompList(int receptId) throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call getReceptKompListByID(?);");

			ps.setInt(1, receptId);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) throw new DALException("ReceptKomp: " + receptId + " findes ikke");

			List<ReceptKompDTO> receptkompList = new ArrayList<ReceptKompDTO>();

			while(rs.next()){

				receptkompList.add(
						new ReceptKompDTO(
								rs.getInt("recept_id"),
								rs.getInt("raavare_id"), 
								rs.getDouble("nom_netto"), 
								rs.getDouble("tolerance")));
			}
			return receptkompList;

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
	public List<ReceptKompDTO> getReceptKompList() throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("SELECT * FROM getReceptKompList;");

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) throw new DALException("ReceptKomp findes ikke");

			List<ReceptKompDTO> receptkompList = new ArrayList<ReceptKompDTO>();

			while(rs.next()){

				receptkompList.add(
						new ReceptKompDTO(
								rs.getInt("recept_id"),
								rs.getInt("raavare_id"), 
								rs.getDouble("nom_netto"), 
								rs.getDouble("tolerance")));
			}
			return receptkompList;

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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RolleDTO> getOprRolleList(String rolle) {
		// TODO Auto-generated method stub
		return null;
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
