/**
 * This File is Part of Quiz
 * (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.constants;

import therogue.quiz.constants.category.Category;
import therogue.quiz.constants.property.PropertyString;



/**
 * @author The Rogue
 *
 */
public class General
{
	private General(){}
	
	public static final Category GENERAL = new Category("general", "General Settings");
	
	public static final PropertyString TITLE = new PropertyString("title", "Quiz", "The title of the Quiz");
}
