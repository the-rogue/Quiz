/**
 * This File is Part of Quiz
 * (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.config;


/**
 * @author The Rogue
 *
 */
public interface IProperty<T>
{	
	public String getName();
	
	public void handleJSONObject(Object object);
	
	public T getJSONObject();
}
