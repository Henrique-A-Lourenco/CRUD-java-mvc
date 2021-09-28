package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

	/*
	 * CRUD 
	 * C: CREATE 
	 * R: READ 
	 * U: UPDATE 
	 * D: DELETE
	 */

	public boolean create(Cliente cliente) {
		
		boolean status;
		String sql = "INSERT INTO clientes (nome, cep, numero, logradouro, bairro, cidade, uf) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCep());
			pstm.setString(3, cliente.getNumero());
			pstm.setString(4, cliente.getLogradouro());
			pstm.setString(5, cliente.getBairro());
			pstm.setString(6, cliente.getCidade());
			pstm.setString(7, cliente.getUf());

			pstm.execute();
			
			status = true;

			//JOptionPane.showMessageDialog(null, "Salvo", "Cadastro", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		} finally {

			try {

				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
		return status;

	}

	public List<Cliente> read(String search) {
		
		String sql;
		
		if (search == "") {
			
			sql = "SELECT * FROM clientes";
			
		}
		else {
			
			sql = "SELECT * FROM clientes WHERE nome LIKE '%" + search + "%'";
			
		}
		
		List<Cliente> clientes = new ArrayList<Cliente>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rst = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rst = pstm.executeQuery();

			while (rst.next()) {

				Cliente cliente = new Cliente();

				cliente.setId(rst.getInt("idcliente"));
				cliente.setNome(rst.getString("nome"));
				cliente.setCep(rst.getString("cep"));
				cliente.setNumero(rst.getString("numero"));
				cliente.setLogradouro(rst.getString("logradouro"));
				cliente.setBairro(rst.getString("bairro"));
				cliente.setCidade(rst.getString("cidade"));
				cliente.setUf(rst.getString("uf"));

				clientes.add(cliente);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (rst != null) {
					rst.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		return clientes;
	}

	public boolean update(Cliente cliente) {
		
		boolean status;
		
		String sql = "UPDATE clientes SET nome = ? , cep = ? , numero = ? , logradouro = ? , bairro = ? , cidade = ? , uf = ? WHERE idcliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCep());
			pstm.setString(3, cliente.getNumero());
			pstm.setString(4, cliente.getLogradouro());
			pstm.setString(5, cliente.getBairro());
			pstm.setString(6, cliente.getCidade());
			pstm.setString(7, cliente.getUf());
			
			pstm.setInt(8, cliente.getId());

			pstm.execute();
			
			status = true;

		} catch (Exception e) {
			
			status = false;
			e.printStackTrace();
			
		} finally {

			try {

				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
		return status;

	}

	public boolean delete(Cliente cliente) {
		
		boolean status;
		

		String sql = "DELETE FROM clientes WHERE idcliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setInt(1, cliente.getId());

			pstm.execute();
			
			status = true;

		} catch (Exception e) {
			
			status = false;
			e.printStackTrace();
			
		} finally {

			try {

				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
		return status;
		

	}
	
	
}
