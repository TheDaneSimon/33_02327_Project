package dto01917;

public class RolleDTO {

	private int opr_id;
	private String rolle;

	public RolleDTO(int opr_id, String rolle){
		this.opr_id = opr_id;
		this.rolle = rolle;
	}

	public int getOprId(){
		return opr_id;
	}

	public String getRolle(){
		return rolle;
	}

	public void setOprId(int newID){
		opr_id = newID;
	}
	
	public void setRolle(String newRolle){
		rolle = newRolle;
	}
	
	public String toString(){
		return opr_id + "\t" + rolle;
	}
}
