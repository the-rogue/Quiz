/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.constants.category;

import java.util.List;

import therogue.quiz.constants.property.IProperty;

/**
 * @author The Rogue
 *
 */
public interface ICategory
{
	public void writeCategory(List<String> list);
	
	public void readCategory(List<String> list);
	
	public void addProperty(IProperty p);
	
	public void addSubCategory(ICategory c);
	
	public String getName();
}
