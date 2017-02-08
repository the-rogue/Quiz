/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.gui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * @author The Rogue
 *
 */
public class ColorButton extends JButton
{
	private Color Background2 = Color.WHITE;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public ColorButton()
	{
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
	}
	
	/**
	 * @param icon
	 */
	public ColorButton(Icon icon)
	{
		super(icon);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
	}
	
	/**
	 * @param text
	 */
	public ColorButton(String text)
	{
		super(text);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
	}
	
	/**
	 * @param text
	 * @param icon
	 */
	public ColorButton(String text, Icon icon)
	{
		super(text, icon);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
	}
	
	/**
	 * @return the 2nd Gradient of the button
	 */
	public Color getBackground2()
	{
		return Background2;
	}

	/**
	 * @param backgroundColor the 2nd Gradient of the button to set
	 */
	public void setBackground2(Color backgroundColor)
	{
		if (backgroundColor != null) {
			Background2 = backgroundColor;
		}
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		Color background = getBackground();
		Color background2 = getBackground2();
		if (getModel().isPressed())
		{
			background = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 50);
			background2 = new Color(getBackground2().getRed(), getBackground2().getGreen(), getBackground2().getBlue(), 50);
		}
		else if (getModel().isRollover())
		{
			background = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 200);
			background2 = new Color(getBackground2().getRed(), getBackground2().getGreen(), getBackground2().getBlue(), 200);
		}
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setPaint(new GradientPaint(new Point(0, 0), background, new Point(0, getHeight() / 3), background2));
		g2.fillRect(0, 0, getWidth(), getHeight() / 3);
		g2.setPaint(new GradientPaint(new Point(0, getHeight() / 3), background2, new Point(0, getHeight()), background));
		g2.fillRect(0, getHeight() / 3, getWidth(), getHeight());
		g2.dispose();
		super.paintComponent(g);
	}
	
}
