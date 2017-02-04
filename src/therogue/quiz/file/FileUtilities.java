/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author The Rogue
 *
 */
public class FileUtilities
{
	public static List<String> readOrCreateFile(List<String> defaultLines, Path path)
	{
		try
		{
			List<String> Lines = Files.readAllLines(path);
			if (Lines != null && !Lines.isEmpty()) { return Lines; }
		}
		catch (IOException e)
		{
			System.out.println("Completely Failed to Read from the File: " + path.toString());
			
		}
		writeFile(defaultLines, path);
		return defaultLines;
	}
	
	public static void writeFile(List<String> defaultLines, Path path)
	{
		try
		{
			path.toFile().delete();
		}
		catch (SecurityException e)
		{	
			
		}
		try
		{
			Files.write(path, defaultLines, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
		}
		catch (IOException e1)
		{
			System.out.println("Completely Failed to Write to the File: " + path.toString());
		}
	}
}
