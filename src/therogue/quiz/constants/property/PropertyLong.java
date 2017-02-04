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
public class PropertyLong implements IProperty
{
	public final String name;
	public long value;
	public String comment;
	
	public PropertyLong(String name, long val, String comment)
	{
		this.name = name;
		this.value = val;
		this.comment = comment;
	}
	
	@Override
	public void writeCategory(List<String> list) {
		FileBuilderUtils.addLong(list, name, value, comment);
	}
	
	@Override
	public void readCategory(String val) {
		this.value = Long.parseLong(val);
	}

	@Override
	public String getName()
	{
		return name;
	}
	
}
