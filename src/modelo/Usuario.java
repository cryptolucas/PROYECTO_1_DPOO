package modelo;

public abstract class Usuario {
	private String login;
	private String password;
	private String tipoUsuario;
	
	public Usuario(String login, String password, String tipoUsuario) {
		this.login = login;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}
	
}
