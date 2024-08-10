package rocha.guilherme.jose.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import rocha.guilherme.jose.controller.CepController;

import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CepView extends JFrame {

	private JPanel contentPane;
	private JLabel lblCep;
	private JTextField textFieldCep;
	private JButton btnSobre;
	private JLabel lblEndereo;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JTextField textFieldEndereco;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JLabel lblUf;
	private JComboBox<String> comboBoxUf;
	
	private CepController controller;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CepView frame = new CepView();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CepView() {
		controller = new CepController(this);
		
		setTitle("Buscar Endere\u00E7o");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CepView.class.getResource("/rocha/guilherme/jose/view/icones/home.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 393);
		contentPane = new JPainelGradient();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarEndereco = new JLabel("Buscar endere\u00E7o pelo CEP");
		lblBuscarEndereco.setForeground(new Color(128, 128, 255));
		lblBuscarEndereco.setForeground(Color.WHITE);
		lblBuscarEndereco.setFont(new Font("Arial", Font.BOLD, 20));
		lblBuscarEndereco.setBounds(145, 28, 253, 24);
		contentPane.add(lblBuscarEndereco);
		
		lblCep = new JLabel("CEP:");
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCep.setBounds(32, 96, 40, 20);
		contentPane.add(lblCep);
		
		textFieldCep = new JFormattedTextField();
		textFieldCep.setOpaque(false);
		textFieldCep.setBorder(new LineBorder(Color.WHITE));
		textFieldCep.setForeground(Color.WHITE);
		try {
			((JFormattedTextField) textFieldCep).setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textFieldCep.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldCep.setBounds(83, 92, 120, 28);
		contentPane.add(textFieldCep);
		textFieldCep.setColumns(10);
		
		JButton btnBuscar = new JButtonGradient();
		btnBuscar.setText("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.buscarEndereco();
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnBuscar.setBounds(263, 92, 110, 28);
		contentPane.add(btnBuscar);
		
		btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.abrirTelaSobre();
			}
		});
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(SystemColor.control);
		btnSobre.setToolTipText("Sobre");
		btnSobre.setOpaque(false);
		btnSobre.setIcon(new ImageIcon(CepView.class.getResource("/rocha/guilherme/jose/view/icones/about.png")));
		btnSobre.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSobre.setBounds(463, 72, 48, 48);
		contentPane.add(btnSobre);
		
		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEndereo.setBounds(32, 152, 78, 20);
		contentPane.add(lblEndereo);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 16));
		lblBairro.setBounds(32, 192, 50, 20);
		contentPane.add(lblBairro);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCidade.setBounds(32, 232, 60, 20);
		contentPane.add(lblCidade);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setOpaque(false);
		textFieldEndereco.setBorder(new LineBorder(Color.WHITE));
		textFieldEndereco.setForeground(Color.WHITE);
		textFieldEndereco.setEditable(false);
		textFieldEndereco.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(131, 148, 380, 28);
		contentPane.add(textFieldEndereco);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setOpaque(false);
		textFieldBairro.setBorder(new LineBorder(Color.WHITE));
		textFieldBairro.setForeground(Color.WHITE);
		textFieldBairro.setEditable(false);
		textFieldBairro.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(131, 188, 380, 28);
		contentPane.add(textFieldBairro);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setOpaque(false);
		textFieldCidade.setBorder(new LineBorder(Color.WHITE));
		textFieldCidade.setForeground(Color.WHITE);
		textFieldCidade.setEditable(false);
		textFieldCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(131, 228, 220, 28);
		contentPane.add(textFieldCidade);
		
		lblUf = new JLabel("UF:");
		lblUf.setForeground(Color.WHITE);
		lblUf.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUf.setBounds(424, 232, 25, 20);
		contentPane.add(lblUf);
		
		comboBoxUf = new JComboBox<>();
		comboBoxUf.setForeground(Color.WHITE);
		comboBoxUf.setBackground(Color.decode("#4A00E0"));
		comboBoxUf.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxUf.setBounds(461, 228, 50, 28);
		contentPane.add(comboBoxUf);
		
		JButton btnLimparTela = new JButtonGradient();
		btnLimparTela.setText("LIMPAR TELA");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimparTela.setBounds(32, 294, 116, 28);
		contentPane.add(btnLimparTela);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(207, 96, 20, 20);
		contentPane.add(lblStatus);
	
		iniciar();
	}

	private void iniciar() {
		controller.preencherTela();
	}
	
	public void exibeMensagemInformativa(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.INFORMATION_MESSAGE);
	}

	public JTextField getTextFieldCep() {
		return textFieldCep;
	}

	public void setTextFieldCep(JTextField textFieldCep) {
		this.textFieldCep = textFieldCep;
	}

	public JTextField getTextFieldEndereco() {
		return textFieldEndereco;
	}

	public void setTextFieldEndereco(JTextField textFieldEndereco) {
		this.textFieldEndereco = textFieldEndereco;
	}

	public JTextField getTextFieldBairro() {
		return textFieldBairro;
	}

	public void setTextFieldBairro(JTextField textFieldBairro) {
		this.textFieldBairro = textFieldBairro;
	}

	public JTextField getTextFieldCidade() {
		return textFieldCidade;
	}

	public void setTextFieldCidade(JTextField textFieldCidade) {
		this.textFieldCidade = textFieldCidade;
	}

	public JComboBox<String> getComboBoxUf() {
		return comboBoxUf;
	}

	public void setComboBoxUf(JComboBox<String> comboBoxUf) {
		this.comboBoxUf = comboBoxUf;
	}

	public JLabel getLblStatus() {
		return lblStatus;
	}

	public void setLblStatus(JLabel lblStatus) {
		this.lblStatus = lblStatus;
	}
	
}
