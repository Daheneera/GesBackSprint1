package es.mdef.gesinalog_API.Excepciones;

public class RegisterNotFoundException extends RuntimeException {

	
		private static final Long serialVersionUID = 1L;

		public RegisterNotFoundException(Long id, String tipo) {
			super("No s eha encontrado la "+ tipo + " " +id);
		}
		
		
}
