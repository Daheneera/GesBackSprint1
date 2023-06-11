package es.mdef.gesinalog_API.entidades;

import java.util.List;

import com.luque.librerias.utilidades.sinHuesped;



public class ZonaGeneral extends InstalacionConId implements sinHuesped{
	
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
