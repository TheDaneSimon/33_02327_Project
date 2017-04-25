package daoimpl01917;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptKompDAO;
import dto01917.ReceptKompDTO;

public class MySQLReceptKompDAO implements ReceptKompDAO {

	@Override
	public ReceptKompDTO getReceptKomp(int receptId, int raavareId) throws DALException {
		PreparedStatement ps = null;

		try {
			ps = Connector.getConnection().prepareStatement("call getReceptKomp(?,?);");

			ps.setInt(1, receptId);
			ps.setInt(2, raavareId);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) throw new DALException("ReceptKomp: " + receptId + " + " + raavareId + " findes ikke");

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

			do{

				receptkompList.add(
						new ReceptKompDTO(
								rs.getInt("recept_id"),
								rs.getInt("raavare_id"), 
								rs.getDouble("nom_netto"), 
								rs.getDouble("tolerance")));
			}while(rs.next());
			
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

			do{

				receptkompList.add(
						new ReceptKompDTO(
								rs.getInt("recept_id"),
								rs.getInt("raavare_id"), 
								rs.getDouble("nom_netto"), 
								rs.getDouble("tolerance")));
			}while(rs.next());
			
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
		catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e); 
		}finally{
			try{
				ps.close();
			}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}

}
