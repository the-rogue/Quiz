/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.file;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import therogue.quiz.constants.General;
import therogue.quiz.constants.Questions;
import therogue.quiz.constants.category.Category;
import therogue.quiz.util.StringUtils;

/**
 * @author The Rogue
 *
 */
public class ConfigManager extends FileManager
{
	private Path configurationPath = Paths.get(FileManager.ROOTBASEDIR + "/Quiz Configurations.txt");
	@SuppressWarnings("unused")
	private List<String> configLines;
	private static final HashMap<String, Category> categories = new HashMap<String, Category>();
	
	public ConfigManager()
	{
		configLines = FileUtilities.readOrCreateFile(writeConfig(), configurationPath);
		//readConfig(configLines);
		FileUtilities.writeFile(writeConfig(), configurationPath);
	}
	
	private List<String> writeConfig()
	{
		List<String> configwrite = new ArrayList<String>();
		for (String c : categories.keySet())
		{
			categories.get(c).writeCategory(configwrite);
		}
		return configwrite;
	}
	
	@SuppressWarnings("unused")
	private void readConfig(List<String> listlines)
	{
		if (!checkFile(listlines)) return;
		int openBrackets = 0;
		String name = null;
		boolean isToCategory = false;
		ArrayList<String> linesToCategory = new ArrayList<String>();
		for (String line : listlines)
		{
			line = line.trim();
			if (!isToCategory && StringUtils.matchWithExluder(line, "\\s*\"\\S*\"\\s*=\\s*\\{.*", '#'))
			{
				name = StringUtils.getMatchedPart(line, "\"\\S*\"", '#');
				linesToCategory.add(line.substring(line.indexOf(StringUtils.getMatchedPart(line, "\\{.*", '#')) + 1, line.length()));
				isToCategory = true;
			}
			else if (isToCategory)
			{
				for (int i = 0; i < line.length(); i++)
				{
					if (line.charAt(i) == '#') break;
					if (line.charAt(i) == '{')
					{
						++openBrackets;
					}
					else if (line.charAt(i) == '}')
					{
						--openBrackets;
						if (openBrackets == 0) {
							if (categories.get(name) != null)
							{
								categories.get(name).readCategory(linesToCategory);
							}
						}
					}

				}
				isToCategory = false;

				linesToCategory.add(line);
			}
		}
	}
	
	public static void addCategory(Category c)
	{
		categories.put(c.name, c);
	}
	
	private static boolean checkFile(List<String> listlines)
	{
		int brackets = 0;
		for (String s : listlines)
		{
			
			if (s.charAt(0) == '#') continue;
			brackets += StringUtils.countCharOcc(s, '{', '#');
			brackets -= StringUtils.countCharOcc(s, '}', '#');
		}
		if (brackets != 0) return false;
		else return true;
		
	}
	
	static
	{
		addCategory(General.GENERAL);
		addCategory(Questions.QUESTIONS);
		General.GENERAL.addProperty(General.TITLE);
		Questions.QUESTIONS.addProperty(Questions.QUESTIONLIST);
	}
	
}
