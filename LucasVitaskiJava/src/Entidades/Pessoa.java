package Entidades;

public class Pessoa{
	private int ID;
	private String Nome;
	private String Email;
	private String endereco;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ID;
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (ID != other.ID)
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pessoa [ID=" + ID + ", Nome=" + Nome + ", Email=" + Email + ", endereco=" + endereco + "]";
	}
	public Pessoa(int iD, String nome, String email, String endereco) {
		super();
		ID = iD;
		Nome = nome;
		Email = email;
		this.endereco = endereco;
	}
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

}