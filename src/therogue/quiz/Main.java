/**
 * This File is Part of Quiz
 * (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz;

import therogue.quiz.file.ConfigManager;


/**
 * @author The Rogue
 *
 */
public class Main
{
	public static ConfigManager theConfigManager;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Working");
		theConfigManager = new ConfigManager();
	}
}
