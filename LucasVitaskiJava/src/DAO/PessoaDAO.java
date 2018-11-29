package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Pessoa;
import Conexao.CNXHSQLDB;

public class PessoaDAO {

	private final String SQL_INSERIR_PESSOA = "INSERT INTO PESSOA ("+ "NOME, EMAIL, ENDERECO)" + "VALUES (?, ?, ?)";
	private final String SQL_ALTERAR_PESSOA = "UPDATE PESSOA SET NOME=?, EMAIL=?, ENDERECO=? WHERE NOME=?;";
	private final String SQL_EXCLUIR_PESSOA = "DELETE FROM PESSOA WHERE ID=?";
	private final String SQL_SELECIONAR_PESSOA = "SELECT * FROM PESSOA";
	
private PreparedStatement pst = null;
	
	public boolean inserirPessoa(Pessoa umaPessoa) {
		boolean ret = false;
		Connection conn = CNXHSQLDB.conectar();
		try {
			pst = conn.prepareStatement(SQL_INSERIR_PESSOA);
			pst.setString(1, umaPessoa.getNome());
			pst.setString(2, umaPessoa.getEmail());
			pst.setString(3, umaPessoa.getEndereco());
			ret = pst.execute();
			CNXHSQLDB.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;
	}
	
	public ArrayList<Pessoa> listarPessoa(){
		ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		Connection conn = CNXHSQLDB.conectar();
		Pessoa umaPessoa;
		try {
			pst = conn.prepareStatement(SQL_SELECIONAR_PESSOA);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				umaPessoa = new Pessoa();
				umaPessoa.setID(rs.getInt("ID"));
				umaPessoa.setNome(rs.getString("Nome"));
				umaPessoa.setEmail(rs.getString("Email"));
				umaPessoa.setEndereco(rs.getString("Endereco"));			
				listaPessoa.add(umaPessoa);
			}
			rs.close();
			pst.close();
			CNXHSQLDB.fecharCNX();			
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return listaPessoa;
	}
	
	public boolean alterarPessoa(Pessoa umaPessoa) {
		boolean ret = false;
		Connection conn = CNXHSQLDB.conectar();
		try {
			pst = conn.prepareStatement(SQL_ALTERAR_PESSOA);
			pst.setString(1, umaPessoa.getNome());
			pst.setString(2, umaPessoa.getEmail());
			pst.setString(3, umaPessoa.getEndereco());;
			ret = pst.execute();
			pst.close();
			CNXHSQLDB.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;	
	}
	
	public boolean excluirPessoa(Pessoa umaPessoa) {
		boolean ret = false;
		Connection conn = CNXHSQLDB.conectar();
		try {
			pst = conn.prepareStatement(SQL_EXCLUIR_PESSOA);
			pst.setInt(1, umaPessoa.getID());
			ret = pst.execute();
			pst.close();
			CNXHSQLDB.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;	
	}

}
