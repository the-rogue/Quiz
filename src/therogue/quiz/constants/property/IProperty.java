/**
 * This File is Part of Quiz
 * (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.constants.property;

import java.util.List;

/**
 * @author The Rogue
 *
 */
public interface IProperty
{	
	public void writeCategory(List<String> list);
	public void readCategory(String val);
	public String getName();
}
