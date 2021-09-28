package controller;

import java.util.List;

import model.Cliente;
import model.ClienteDAO;

public class Controller {
	
	public boolean addCastro(Cliente cliente) {
		
		boolean status;
		
		ClienteDAO banco = new ClienteDAO();
		
		status = banco.create(cliente);
		
		return status;
		
	}
	
	public boolean updateCadastro(Cliente cliente) {
		
		ClienteDAO banco = new ClienteDAO();
		return banco.update(cliente); 
		
	}
	
	public boolean deletarCadastro(Cliente cliente) {
		
		ClienteDAO banco = new ClienteDAO();
		return banco.delete(cliente);
		
	}
	
	public List<Cliente> buscarClientes(String search) {
		
		ClienteDAO cdao = new ClienteDAO();
		return cdao.read(search);	
	}
	

	

}
