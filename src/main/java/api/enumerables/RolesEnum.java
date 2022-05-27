package api.enumerables;

public enum RolesEnum {
	  ADMIN("admin"),
	  CLIENTE("cliente"),
	  EMPRESA("empresa");

	private String valor;

	// Constructor
	private RolesEnum(String valor) {
		this.valor = valor;
	}
	
	// Getters setters
	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

}
