package daointerfaces01917;

import java.util.List;

import dto01917.RolleDTO;

public interface RolleDAO {

	public List<RolleDTO> getOprRolleList(int opr_id);
	public List<RolleDTO> getRolleList();
	public List<RolleDTO> getOprRolleList(String rolle);
	public void createRolle(RolleDTO rolle);
	public void updateRolle(RolleDTO rolle);
	
}
