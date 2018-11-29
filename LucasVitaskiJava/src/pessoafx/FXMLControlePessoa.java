package pessoafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.PessoaDAO;
import Entidades.Pessoa;
import View.ViewPessoa;
import View.ViewPessoa;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

	public class FXMLControlePessoa  implements Initializable{
		 
	private ViewPessoa ViewPessoa= new ViewPessoa();
	 private PessoaDAO pessoaDAO = new PessoaDAO();
		  private ArrayList<Pessoa> ListaPessoa = new ArrayList<Pessoa>();	
		  private Pessoa PessoaEscolhida;
		    
	    @FXML
	    private TextField Label_nome;

	    @FXML
	    private TextField Label_email;

	    @FXML
	    private TextField Label_endereco;
	    
	    @FXML
	    private TableColumn<?, ?> Id_Coluna_Nome;

	    @FXML
	    private TableColumn<?, ?> Id_Coluna_Email;

	    @FXML
	    private TableColumn<?, ?> Id_Coluna_Endereco;


	    @FXML
	    private TableView<Pessoa> Table_Pessoa;

	    @FXML
	    private Button Buton_editar;

	    @FXML
	    private Button Buton_excluir;

	    @FXML
	    private Button Button_adicionar;

	    @FXML
	    private Button Buton_sair;
	    
	    public void initialize(URL location, ResourceBundle resources) {
	    	Id_Coluna_Nome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
	    	Id_Coluna_Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
	    	Id_Coluna_Endereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
			refreshTable();

			Table_Pessoa.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pessoa>() {

				@Override
				public void changed(ObservableValue<? extends Pessoa> observable, Pessoa oldValue, Pessoa newValue) {
					PessoaEscolhida = newValue;
				}
			});
		}
	    
	    private void refreshTable() {
			ListaPessoa = new PessoaDAO().listarPessoa();
			ObservableList<Pessoa> observableList = FXCollections.observableArrayList(ListaPessoa);
			Table_Pessoa.setItems(observableList);	
		}
	    @FXML
	    private void cadastrar(ActionEvent event) {
	    	
	    	Pessoa Pessoa = ViewPessoa.inserir(Label_nome.getText(), Label_email.getText(), Label_endereco.getText());
	    	pessoaDAO.inserirPessoa(Pessoa);
	    	refreshTable();

	    }
	    @FXML
	    private void deletar() {
			pessoaDAO.excluirPessoa(PessoaEscolhida);
			refreshTable();	 
	 }
    
    @FXML
	 private void editarPessoa() {
    	Label_nome.setText(PessoaEscolhida.getNome());
    	Label_email.setText(PessoaEscolhida.getEmail());
    	Label_endereco.setText(PessoaEscolhida.getEndereco());

		 
		 pessoaDAO.alterarPessoa(PessoaEscolhida);
		 refreshTable();	
	 }
    
    @FXML
    private void editar() {
    	PessoaEscolhida.setNome(Label_nome.getText());
    	PessoaEscolhida.setEmail(Label_email.getText());
    	PessoaEscolhida.setEndereco(Label_endereco.getText());
    	 
    	
		 
		 pessoaDAO.alterarPessoa(PessoaEscolhida);
		 refreshTable();	
	 }
    @FXML
   private  void sair(ActionEvent event ) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Sair");
    	String s ="Voce quer sair mesmo";
    	alert.setContentText(s);
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if((result.isPresent()) && (result.get() == ButtonType.OK)){
    		System.exit(0);
    	
    }
    }
	}

