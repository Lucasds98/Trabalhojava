package View;

import Entidades.Pessoa;

public class ViewPessoa {


		public ViewPessoa() {
			
		}

		public Pessoa inserir(String nome, String email,  String endereco) {
			Pessoa pessoa = new Pessoa();
			
			pessoa.setNome(nome);
			
			pessoa.setEmail(email);
			
			pessoa.setEndereco(endereco);
			
											
			return pessoa;
		}
		
		
		
	}

