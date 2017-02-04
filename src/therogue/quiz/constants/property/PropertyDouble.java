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
public class PropertyDouble implements IProperty
{
	public final String name;
	public double value;
	public String comment;
	
	public PropertyDouble(String name, double val, String comment)
	{
		this.name = name;
		this.value = val;
		this.comment = comment;
	}
	
	@Override
	public void writeCategory(List<String> list) {
		FileBuilderUtils.addDouble(list, name, value, comment);
	}
	
	@Override
	public void readCategory(String val) {
		this.value = Double.parseDouble(val);
	}

	@Override
	public String getName()
	{
		return name;
	}
	
}
