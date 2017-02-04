/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author The Rogue
 *
 */
public class StringUtils
{
	public static int countCharOcc(String container, char matching, char exclusion)
	{
		int counter = 0;
		for (int i = 0; i < container.length(); i++)
		{
			if (container.charAt(i) == exclusion) return counter;
			if (container.charAt(i) == matching)
			{
				++counter;
			}
		}
		return counter;
	}
	
	public static boolean matchWithExluder(String container, String stringMatch, char exclusion)
	{
		if (charExcluder(container, exclusion).matches(stringMatch)) return true;
		return false;
	}
	
	public static String getMatchedPart(String container, String stringMatch, char exclusion) {
		Pattern p = Pattern.compile(".*(" + stringMatch + ").*");
		Matcher m = p.matcher(charExcluder(container, exclusion));
		if (m.matches()) {
			return m.group(1);
		}
		return "";
	}
	
	public static String charExcluder(String container, char exclusion) {
		int upTo = container.indexOf(exclusion) != -1 ? container.indexOf(exclusion) : container.length();
		return container.substring(0, upTo);
	}
	
}
