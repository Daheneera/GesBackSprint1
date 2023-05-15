package es.mdef.gesinalog_sprint1.entidades;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("H")
public class Habitacion extends Instalacion {
	
	private Boolean telefono;
	private Boolean tv;
	private Integer numCamas;
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
