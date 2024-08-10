package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPainelGradient  extends JPanel{

	private int width;
	private int height;
	private Color color1;
	private Color color2;

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		width = getWidth();
		height = getHeight();
		color1 = Color.decode("#8E2DE2");
		color2 = Color.decode("#4A00E0");
		
		// Criando o gradiente
		GradientPaint gp = new GradientPaint(0, 0, color1, width, height, color2);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, width, height);
	}
}
