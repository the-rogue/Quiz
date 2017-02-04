/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.file;

import java.io.File;
import java.net.URL;

/**
 * @author The Rogue
 *
 */
public class FileManager
{
	public static final String ROOTBASEDIR = getRootPath();
	
	public static String getRootPath()
	{
		URL location = FileManager.class.getProtectionDomain().getCodeSource().getLocation();
		String path = location.getPath();
		path = path.replaceAll("%20", " ");
		return new File(path).getParent();
	}
}
