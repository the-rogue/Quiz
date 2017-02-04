/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.constants.property;

import java.util.ArrayList;
import java.util.List;

import therogue.quiz.file.FileBuilderUtils;

/**
 * @author The Rogue
 *
 */
public class PropertyList implements IProperty
{
	
	public static final String DEMOENTRY = "This is a demonstration entry DO NOT EDIT";
	
	public final String name;
	public List<String> value;
	public String comment;
	
	public PropertyList(String name, List<String> val, String comment)
	{
		this.name = name;
		value = new ArrayList<String>();
		this.value.addAll(val);
		this.comment = comment;
	}
	
	@Override
	public void writeCategory(List<String> list)
	{
		FileBuilderUtils.addString(list, name, DEMOENTRY, comment);
		for (String s : value)
		{
			FileBuilderUtils.addString(list, name, s, comment);
		}
	}
	
	@Override
	public void readCategory(String val)
	{
		if (val.equals(DEMOENTRY)){
			return;
		}
		this.value.add(val);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
}
