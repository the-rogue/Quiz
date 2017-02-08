/**
 * This File is Part of Quiz
 * (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.config;

import java.util.Map;

/**
 * @author The Rogue
 *
 */
public interface ICategory
{	
	public String getName();
	
	public void handleJSONMap(Map<String, Object> map);
	
	public Map<String, Object> getJSONMap();
}
