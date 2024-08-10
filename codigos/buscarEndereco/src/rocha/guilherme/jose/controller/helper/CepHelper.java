package rocha.guilherme.jose.controller.helper;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import rocha.guilherme.jose.model.ModelCEP;
import rocha.guilherme.jose.view.CepView;

public class CepHelper {

	private final CepView cepView;

	public CepHelper(CepView cepView) {
		this.cepView = cepView;
	}

	public void preencherComboBox() {
		String[] ufs = new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", 
				"MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
		
		cepView.getComboBoxUf().setModel(new DefaultComboBoxModel<>(ufs));
	}
	
	public ModelCEP obterCep() {
		String numero = cepView.getTextFieldCep().getText();
		
		ModelCEP cep = new ModelCEP(numero);
		return cep;
	}

	public boolean verificarCampoCep() {
		if(cepView.getTextFieldCep().getText().replace("-", "").trim().isEmpty()) {
			return false;			
		}
		
		return true;
	}

	public void prencherDados(ModelCEP cep) {
		cepView.getTextFieldBairro().setText(cep.getBairro());
		cepView.getTextFieldCidade().setText(cep.getCidade());
		cepView.getTextFieldEndereco().setText(cep.getTipoLogradouro() + " " + cep.getLogradouro());
		cepView.getComboBoxUf().setSelectedItem(cep.getUf());
		cepView.getLblStatus().setIcon(new ImageIcon(getClass().getResource("/rocha/guilherme/jose/view/icones/check.png")));
	}

	public void limparTela() {
		cepView.getTextFieldCep().setText("");
		cepView.getTextFieldBairro().setText("");
		cepView.getTextFieldCidade().setText("");
		cepView.getTextFieldEndereco().setText("");
		cepView.getComboBoxUf().setSelectedItem("");
		cepView.getLblStatus().setIcon(null);
		cepView.getTextFieldCep().requestFocus();
	}
	
}
