package rocha.guilherme.jose.view;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class SobreView extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SobreView dialog = new SobreView();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setResizable(false);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public SobreView() {
		setModal(true);
		
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SobreView.class.getResource("/rocha/guilherme/jose/view/icones/home.png")));
		setBounds(100, 100, 450, 280);
		setContentPane(new JPainelGradient());
		getContentPane().setLayout(null);
		
		JLabel lblNomeVersao = new JLabel("Buscar Endere\u00E7o - Vers\u00E3o 1.0");
		lblNomeVersao.setForeground(Color.WHITE);
		lblNomeVersao.setFont(new Font("Arial", Font.BOLD, 12));
		lblNomeVersao.setBounds(32, 32, 169, 16);
		getContentPane().add(lblNomeVersao);
		
		JLabel lblAuthor = new JLabel("@author Jos\u00E9 Guilherme da Rocha");
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setFont(new Font("Arial", Font.BOLD, 12));
		lblAuthor.setBounds(32, 68, 197, 16);
		getContentPane().add(lblAuthor);
		
		JLabel lblWebService = new JLabel("Web Service:");
		lblWebService.setForeground(Color.WHITE);
		lblWebService.setFont(new Font("Arial", Font.BOLD, 12));
		lblWebService.setBounds(32, 104, 75, 16);
		getContentPane().add(lblWebService);
		
		JLabel lblLinkWebService = new JLabel("republicavirtual.com.br");
		lblLinkWebService.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblLinkWebService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://republicavirtual.com.br/");
			}
		});
		lblLinkWebService.setForeground(new Color(135, 183, 255));
		lblLinkWebService.setFont(new Font("Arial", Font.BOLD, 12));
		lblLinkWebService.setBounds(117, 104, 136, 16);
		getContentPane().add(lblLinkWebService);
		
		JButton btnGitHub = new JButton("");
		btnGitHub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/guisystem");
			}
		});
		btnGitHub.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGitHub.setIcon(new ImageIcon(SobreView.class.getResource("/rocha/guilherme/jose/view/icones/github.png")));
		btnGitHub.setToolTipText("GitHub");
		btnGitHub.setOpaque(false);
		btnGitHub.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGitHub.setBorder(null);
		btnGitHub.setBackground(SystemColor.control);
		btnGitHub.setBounds(32, 160, 48, 48);
		getContentPane().add(btnGitHub);
		
		JButton btnLinkedIn = new JButton("");
		btnLinkedIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://www.linkedin.com/in/jos%C3%A9-guilherme-da-rocha/");
			}
		});
		btnLinkedIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLinkedIn.setIcon(new ImageIcon(SobreView.class.getResource("/rocha/guilherme/jose/view/icones/linkedin.png")));
		btnLinkedIn.setToolTipText("LinkedIn");
		btnLinkedIn.setOpaque(false);
		btnLinkedIn.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLinkedIn.setBorder(null);
		btnLinkedIn.setBackground(SystemColor.control);
		btnLinkedIn.setBounds(100, 160, 48, 48);
		getContentPane().add(btnLinkedIn);
		
		JButton btInstagram = new JButton("");
		btInstagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://www.instagram.com/seu_nome_de_usuario/");
			}
		});
		btInstagram.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btInstagram.setIcon(new ImageIcon(SobreView.class.getResource("/rocha/guilherme/jose/view/icones/instagram.png")));
		btInstagram.setToolTipText("Instagram");
		btInstagram.setOpaque(false);
		btInstagram.setFont(new Font("Arial", Font.PLAIN, 12));
		btInstagram.setBorder(null);
		btInstagram.setBackground(SystemColor.control);
		btInstagram.setBounds(168, 160, 48, 48);
		getContentPane().add(btInstagram);
		
		JButton btnWhatsApp = new JButton("");
		btnWhatsApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://wa.me/5581998626494");
			}
		});
		btnWhatsApp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnWhatsApp.setIcon(new ImageIcon(SobreView.class.getResource("/rocha/guilherme/jose/view/icones/whatsapp.png")));
		btnWhatsApp.setToolTipText("WhatsApp");
		btnWhatsApp.setOpaque(false);
		btnWhatsApp.setFont(new Font("Arial", Font.PLAIN, 12));
		btnWhatsApp.setBorder(null);
		btnWhatsApp.setBackground(SystemColor.control);
		btnWhatsApp.setBounds(236, 160, 48, 48);
		getContentPane().add(btnWhatsApp);

	}
	
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
