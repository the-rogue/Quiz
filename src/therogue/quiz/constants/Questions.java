/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.constants;

import java.util.HashMap;
import java.util.Map;

import therogue.quiz.config.Category;
import therogue.quiz.config.Property;

/**
 * @author The Rogue
 *
 */
public class Questions
{
	public static final Category QUESTIONS = new Category("Questions", "Enter Questions here in the format below");
	public static final Property<Map<String, String>> QUESTIONLIST = new Property<Map<String, String>>("Questions:Answers", new HashMap<String, String>());
	public static final Property<Map<String, Integer>> QUESTIONTIMERS = new Property<Map<String, Integer>>("Questions:Time_Limit", new HashMap<String, Integer>());
}
