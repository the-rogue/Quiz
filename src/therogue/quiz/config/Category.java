/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author The Rogue
 *
 */
public class Category implements ICategory
{
	private final HashMap<String, IProperty<?>> properties = new HashMap<String, IProperty<?>>();
	private final HashMap<String, ICategory> subCategorys = new HashMap<String, ICategory>();
	
	public final String name;
	public String title;
	
	public Category(String name, String title)
	{
		this.name = name;
		this.title = title;
	}
	
	@Override
	public String getName()
	{
		return name;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleJSONMap(Map<String, Object> map)
	{
		if (map == null) return;
		for (String s : map.keySet()) {
			if (properties.get(s) != null) {
				properties.get(s).handleJSONObject(map.get(s));
			}
			if (subCategorys.get(s) != null) {
				subCategorys.get(s).handleJSONMap((Map<String,Object>)map.get(s));
			}
		}
	}

	@Override
	public Map<String, Object> getJSONMap()
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (String s : properties.keySet()){
			map.put(s, properties.get(s).getJSONObject());
		}
		for (String s : subCategorys.keySet()){
			map.put(s, subCategorys.get(s).getJSONMap());
		}
		return map;
	}
	
	public void addSubCategory(ICategory c){
		subCategorys.put(c.getName(), c);
	}
	
	public void addProperty(IProperty<?> p){
		properties.put(p.getName(), p);
	}
	
}
