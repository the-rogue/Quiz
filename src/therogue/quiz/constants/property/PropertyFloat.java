/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.constants.property;

import java.util.List;

import therogue.quiz.file.FileBuilderUtils;

/**
 * @author The Rogue
 *
 */
public class PropertyFloat implements IProperty
{
	public final String name;
	public float value;
	public String comment;
	
	public PropertyFloat(String name, float val, String comment)
	{
		this.name = name;
		this.value = val;
		this.comment = comment;
	}
	
	@Override
	public void writeCategory(List<String> list) {
		FileBuilderUtils.addFloat(list, name, value, comment);
	}
	
	@Override
	public void readCategory(String val) {
		this.value = Float.parseFloat(val);
	}

	@Override
	public String getName()
	{
		return name;
	}
	
}
