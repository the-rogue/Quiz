/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.config;



/**
 * @author The Rogue
 *
 */
public class Property<T> implements IProperty<T>
{
	public final String name;
	public T value;
	
	public Property(String name, T val)
	{
		this.name = name;
		this.value = val;
	}

	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public String toString(){
		return value.toString();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void handleJSONObject(Object object)
	{
		value = (T)object;
	}

	@Override
	public T getJSONObject()
	{
		return value;
	}
	
}
