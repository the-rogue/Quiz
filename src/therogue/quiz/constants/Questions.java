/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.constants;

import java.util.Collections;

import therogue.quiz.constants.category.Category;
import therogue.quiz.constants.property.PropertyList;

/**
 * @author The Rogue
 *
 */
public class Questions
{
	public static final Category QUESTIONS = new Category("questions", "Enter Questions here in the format below");
	
	public static final PropertyList QUESTIONLIST = new PropertyList("question", Collections.<String> emptyList(), "A Question");
}
