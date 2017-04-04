package daointerfaces01917;

import java.util.List;

import dto01917.RolleDTO;

public interface RolleDAO {

	public List<RolleDTO> getOprRolleList(int opr_id) throws DALException;
	public List<RolleDTO> getRolleList() throws DALException;
	public List<RolleDTO> getOprRolleList(String rolle) throws DALException;
	public void createRolle(RolleDTO rolle) throws DALException;
	public void updateRolle(RolleDTO rolle) throws DALException;
	
}
