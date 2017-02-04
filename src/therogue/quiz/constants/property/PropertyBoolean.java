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
public class PropertyBoolean implements IProperty
{
	public final String name;
	public boolean value;
	public String comment;
	
	public PropertyBoolean(String name, boolean val, String comment)
	{
		this.name = name;
		this.value = val;
		this.comment = comment;
	}
	
	@Override
	public void writeCategory(List<String> list) {
		FileBuilderUtils.addBoolean(list, name, value, comment);
	}
	
	@Override
	public void readCategory(String val) {
		this.value = val.equals("true") ? true : false;
	}

	@Override
	public String getName()
	{
		return name;
	}
	
}
