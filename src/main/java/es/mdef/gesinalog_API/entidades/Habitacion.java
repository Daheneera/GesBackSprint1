package es.mdef.gesinalog_API.entidades;

import java.util.List;



public class Habitacion extends InstalacionConId {
	
	private Boolean telefono;
	private Boolean tv;
	private Integer numCamas;
	
	
	//Getters & setters
	
	public Boolean getTelefono() {
		return telefono;
	}
	public void setTelefono(Boolean telefono) {
		this.telefono = telefono;
	}
	public Boolean getTv() {
		return tv;
	}
	public void setTv(Boolean tv) {
		this.tv = tv;
	}
	public Integer getNumCamas() {
		return numCamas;
	}
	public void setNumCamas(Integer numCamas) {
		this.numCamas = numCamas;
	}
	@Override
	public String toString() {
		return "Habitacion [telefono=" + telefono + ", tv=" + tv + ", numCamas=" + numCamas + "]";
	}

	

	
}
