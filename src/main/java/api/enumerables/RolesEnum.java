package api.enumerables;

 public enum RolesEnum {
	  ADMIN,
	  CLIENTE,
	  EMPRESA;

	
	/**
	 * @return the valor
	 */
	public static String getRole(RolesEnum rol) {
		
		switch (rol) {
		case ADMIN:
			return "ROLE_ADMIN";
		case CLIENTE:
			return "ROLE_CLIENTE";
		case EMPRESA:
			return "ROLE_EMPRESA";
		}
		throw new Error("-Role not available in RolesEnum!");
	}
	public static RolesEnum getRoleEnum(String rol) {
		
		switch (rol) {
		case "ROLE_ADMIN":
			return ADMIN;
		case "ROLE_CLIENTE":
			return CLIENTE;
		case "ROLE_EMPRESA":
			return EMPRESA;
		}
		throw new Error("-Role not available in RolesEnum!");
	}



}
