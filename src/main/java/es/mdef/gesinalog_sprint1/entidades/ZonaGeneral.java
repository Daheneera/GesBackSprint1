package es.mdef.gesinalog_sprint1.entidades;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("G")
public class ZonaGeneral extends Instalacion {
	
	private Integer aforo;

	public Integer getAforo() {
		return aforo;
	}

	public void setAforo(Integer aforo) {
		this.aforo = aforo;
	}

	@Override
	public String toString() {
		return "ZonaGeneral [aforo=" + aforo + "]";
	}
	
	
}
