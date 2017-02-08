/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import therogue.quiz.constants.General;
import therogue.quiz.constants.Questions;
import therogue.quiz.file.FileManager;
import therogue.quiz.repack.org.json.simple.JSONWritingUtils;
import therogue.quiz.repack.org.json.simple.parser.JSONParser;
import therogue.quiz.repack.org.json.simple.parser.ParseException;

/**
 * @author The Rogue
 *
 */
public class ConfigManager extends FileManager
{
	private String configurationPath = FileManager.ROOTBASEDIR + "Quiz Configurations.txt";
	private static final HashMap<String, Category> categories = new HashMap<String, Category>();
	public static final String SAMPLEVALUE = "This is a Sample Question";
	
	public ConfigManager()
	{
		setupParameters();
		setupConfig();
	}
	
	private String writeConfig()
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (String s : categories.keySet()){
			map.put(s, categories.get(s).getJSONMap());
		}
		return JSONWritingUtils.toJSONString(map, 0);
	}
	
	private void readConfig(HashMap<String, Object> json)
	{
		if (json == null) return;
		for (String s : categories.keySet())
		{	
			Category c = categories.get(s);
			@SuppressWarnings("unchecked")
			Map<String,Object> m = (Map<String,Object>)json.get(s);
			c.handleJSONMap(m);
		}
	}
	
	public static void addCategory(Category c)
	{
		categories.put(c.name, c);
	}
	
	@SuppressWarnings("unchecked")
	private void setupConfig()
	{
		HashMap<String, Object> json;
		try
		{
			json = (HashMap<String, Object>) new JSONParser().parse(new FileReader(configurationPath));
			readConfig(json);
		}
		catch (IOException | ParseException e)
		{}
		new File(configurationPath).delete();
		try (FileWriter writer = new FileWriter(configurationPath))
		{
			writer.write(writeConfig());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void setupParameters(){
		addCategory(General.GENERAL);
		addCategory(Questions.QUESTIONS);
		General.GENERAL.addProperty(General.TITLE);
		Questions.QUESTIONS.addProperty(Questions.QUESTIONLIST);
		Questions.QUESTIONLIST.value.put(SAMPLEVALUE, "This is a Sample Answer");
		Questions.QUESTIONTIMERS.value.put(SAMPLEVALUE, 10);
	}
}
