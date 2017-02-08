/**
 * This File is Part of Quiz
 * (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import therogue.quiz.constants.General;

/**
 * @author The Rogue
 *
 */
public class QuizFrame extends JFrame
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuizFrame(){
		super(General.TITLE.value);
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{
			BufferedImage image = ImageIO.read(new File("window_image.png"));
			this.setIconImage(image);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(General.BACKGROUND_COLOR);
	}
}
