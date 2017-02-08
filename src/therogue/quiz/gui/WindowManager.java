/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import therogue.quiz.util.GeneralUtils;

/**
 * @author The Rogue
 *
 */
public class WindowManager
{
	private QuizManager appRunner;
	private static Font fontDefault;
	private static Font fontFancy;
	
	QuizFrame theWindow;
	
	JTextField answerbox = new JTextField();
	JLabel label2 = new JLabel();
	JLabel label1 = new JLabel();
	JTextPane variableLabel = new JTextPane();
	JTextPane variableLabel2 = new JTextPane();
	JScrollPane  vlholder = new JScrollPane();
	JScrollPane  vl2holder = new JScrollPane();
	ColorButton button1 = new ColorButton();
	
	public WindowManager(QuizManager appRunner)
	{
		this.appRunner = appRunner;
		theWindow = new QuizFrame();
		fontDefault = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
		fontFancy = GeneralUtils.createFont("raidercrusader3d.ttf", 36);
		answerbox.setFont(fontDefault);
		theWindow.add(answerbox);
		theWindow.add(label2);
		theWindow.add(label1);
		variableLabel.setEditable(false);
		variableLabel.setOpaque(false);
		variableLabel.setFocusable(false);
		vlholder.add(variableLabel);
		vlholder.setOpaque(false);
		vlholder.setBorder(null);
		vlholder.setViewportView(variableLabel);
		vlholder.getViewport().setOpaque(false);
		vlholder.getViewport().setBorder(null);
		theWindow.add(vlholder);
		variableLabel2.setEditable(false);
		variableLabel2.setOpaque(false);
		variableLabel2.setFocusable(false);
		vl2holder.add(variableLabel2);
		vl2holder.setOpaque(false);
		vl2holder.setBorder(null);
		vl2holder.setViewportView(variableLabel2);
		vl2holder.getViewport().setOpaque(false);
		vl2holder.getViewport().setBorder(null);
		theWindow.add(vl2holder);
		button1.setBounds(400, 410, 200, 45);
		button1.setFont(fontFancy);
		theWindow.add(button1);
		theWindow.setVisible(true);
	}
	
	public QuizManager getAppRunner()
	{
		return appRunner;
	}
	
	public static Font getFontDefault()
	{
		return fontDefault;
	}
	
	public static Font getFontFancy()
	{
		return fontFancy;
	}
	
}
