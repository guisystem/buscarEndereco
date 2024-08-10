package rocha.guilherme.jose.controller;

import rocha.guilherme.jose.controller.helper.CepHelper;
import rocha.guilherme.jose.model.ModelCEP;
import rocha.guilherme.jose.view.CepView;
import rocha.guilherme.jose.view.SobreView;

public class CepController {

	private final CepView cepView;
	private final CepHelper helper;
	
	public CepController(CepView cepView) {
		this.cepView = cepView;
		this.helper = new CepHelper(cepView);
	}

	public void preencherTela() {
		helper.preencherComboBox();
		
	}

	public void buscarEndereco() {
		
		ModelCEP cep = helper.obterCep();
		cep.buscarEndereco();
		
		if(helper.verificarCampoCep()) {
			if(cep.isCepExiste()) {
				helper.prencherDados(cep);
			}else {
				cepView.exibeMensagemInformativa("Esse CEP não existe!");
				cepView.getLblStatus().setIcon(null);
				helper.limparTela();
				cepView.getTextFieldCep().setText(cep.getNumeroCep());
			}
		}else {
			cepView.exibeMensagemInformativa("Por favor, informe o CEP!");
			cepView.getTextFieldCep().requestFocus();
		}
		
	}

	public void abrirTelaSobre() {
		SobreView sobre = new SobreView();
		sobre.setLocationRelativeTo(null);
		sobre.setVisible(true);
	}

	public void limparTela() {
		helper.limparTela();
		
	}
}
