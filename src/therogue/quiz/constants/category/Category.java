/**
 * This File is Part of Quiz
 * (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.constants.category;

import java.util.HashMap;
import java.util.List;

import therogue.quiz.constants.property.IProperty;
import therogue.quiz.file.FileBuilderUtils;

/**
 * @author The Rogue
 *
 */
public class Category implements ICategory
{
	private final HashMap<String, IProperty> properties = new HashMap<String, IProperty>();
	
	private final HashMap<String, ICategory> subCategories = new HashMap<String, ICategory>();
	
	public final String name;
	public String title;
	
	public Category(String name, String title) {
		this.name = name;
		this.title = title;
	}
	
	@Override
	public void writeCategory(List<String> list) {
		if (title != null) {
			FileBuilderUtils.addHeader(list, title);
		}
		list.add("\"" + name + "\" {");
		for (String s : properties.keySet()) {
			FileBuilderUtils.newLine(list);
			properties.get(s).writeCategory(list);
		}
		list.add("}");
	}
	
	@Override
	public void readCategory(List<String> list) {
		for (String line : list) {
			line = line.trim();
			if (line.length() < 1 || line.charAt(0) == '#') {
				continue;
			} else if (line.contains(":")) {
				String name = line.substring(2, line.indexOf('='));
				String value = line.substring(line.indexOf('=') + 1, line.length());
				if (properties.get(name) != null) {
					properties.get(name).readCategory(value);
				}
			}
		}
	}
	
	@Override
	public void addProperty(IProperty p){
		properties.put(p.getName(), p);
	}
	
	@Override
	public void addSubCategory(ICategory c)
	{
		subCategories.put(c.getName(), c);
	}
	
	@Override
	public String getName()
	{
		return name;
	}


}
