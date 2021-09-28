package controller;

import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Endereco {

	private String cep;
	private String numero;
	private String logradouro;
	private String tipoLogradouro;
	private String bairro;
	private String cidade;
	private String uf;

	public Endereco GetEndereco(String cep) {

		Endereco endereco = new Endereco();

		try {

			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");

			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();

			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();

				if (element.getQualifiedName().equals("cidade")) {
					endereco.setCidade(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					endereco.setUf(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					endereco.setBairro(element.getText());
				}
				if (element.getQualifiedName().equals("logradouro")) {
					endereco.setLogradouro(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					endereco.setTipoLogradouro(element.getText());
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return endereco;

	}

	public boolean testCep(String cep) {

		boolean testeCep;
		String resultado = "";

		try {

			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");

			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();

			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();

				if (element.getQualifiedName().equals("resultado")) {

					resultado = element.getText();

				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		if (resultado.equals("1")) {
			testeCep = true;
		} else {
			testeCep = false;
		}

		return testeCep;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

}
