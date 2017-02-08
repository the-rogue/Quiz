/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.constants;

import java.awt.Color;

import therogue.quiz.config.Category;
import therogue.quiz.config.Property;

/**
 * @author The Rogue
 *
 */
public class General
{
	private General()
	{
	}
	
	public static final Color BACKGROUND_COLOR = new Color(241, 255, 239);
	
	public static final Category GENERAL = new Category("General", "General Parameters");
	
	public static final Property<String> TITLE = new Property<String>("title", "Quiz");
}
