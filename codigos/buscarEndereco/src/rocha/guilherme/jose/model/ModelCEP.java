package rocha.guilherme.jose.model;

import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ModelCEP {

	private String numeroCep;
	private String uf;
	private String cidade;
	private String bairro;
	private String tipoLogradouro;
	private String logradouro;
	private boolean cepExiste;

	public ModelCEP(String numeroCep) {
		this.numeroCep = numeroCep;
	}
	
	public String getNumeroCep() {
		return numeroCep;
	}

	public void setNumeroCep(String numeroCep) {
		this.numeroCep = numeroCep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public boolean isCepExiste() {
		return cepExiste;
	}

	public void setCepExiste(boolean cepExiste) {
		this.cepExiste = cepExiste;
	}

	public void buscarEndereco() {
		
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + numeroCep + "&formato=xml");
		
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			
			for(Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element elemento = it.next();
				if(elemento.getQualifiedName().equals("cidade")) {
					setCidade(elemento.getText());
				}
				
				if(elemento.getQualifiedName().equals("bairro")) {
					setBairro(elemento.getText());
				}
				
				if(elemento.getQualifiedName().equals("uf")) {
					setUf(elemento.getText());
				}
				
				if(elemento.getQualifiedName().equals("tipo_logradouro")) {
					setTipoLogradouro(elemento.getText());
				}
				
				if(elemento.getQualifiedName().equals("logradouro")) {
					setLogradouro(elemento.getText());
				}
				
				if(elemento.getQualifiedName().equals("resultado")) {
					if(elemento.getText().equals("1") || elemento.getText().equals("2")) {
						setCepExiste(true);
					}else {
						setCepExiste(false);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
