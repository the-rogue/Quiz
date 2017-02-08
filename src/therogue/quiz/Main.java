/**
 * This File is Part of Quiz
 * (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz;

import therogue.quiz.config.ConfigManager;
import therogue.quiz.gui.QuizManager;
import therogue.quiz.gui.WindowManager;


/**
 * @author The Rogue
 *
 */
public class Main
{
	public static ConfigManager theConfigManager;
	public static WindowManager theWindowManager;
	public static QuizManager theQuizManager;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		theQuizManager = new QuizManager(theWindowManager);
		theConfigManager = new ConfigManager();
		theWindowManager = new WindowManager(theQuizManager);
		theQuizManager.start();
		
	}
}
