package es.mdef.gesinalog_API.entidades;

import java.util.List;

import com.luque.librerias.utilidades.Instalacion;
import com.luque.librerias.utilidades.InstalacionImpl;




public class InstalacionConId extends InstalacionImpl implements Instalacion{
	
		
		
	
		private Long id;
		
		
		
		
		//Getters & setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "Instalacion [getId()=" + getId() + ", getNombre()=" + getNombre() + ", getA_c()=" + getA_c()
					+ ", getIncidencias()=" + getIncidencias() + ", getTipoInstalación()=" + getTipoInstalación()
					+ ", getMobiliario()=" + getMobiliario() + "]";
		}
		
		
		
		
		
		
		
}
