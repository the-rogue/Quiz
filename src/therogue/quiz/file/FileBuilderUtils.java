/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.file;

import java.util.List;

/**
 * @author The Rogue
 *
 */
public class FileBuilderUtils
{
	public static List<String> addHeader(List<String> s, String title)
	{
		addLineSequence(s, addRepeatedLine(title.length() + 6, '#'));
		addLineSequence(s, "#", addRepeatedLine(title.length() + 4, ' '), "#");
		addLineSequence(s, "#  ", title, "  #");
		addLineSequence(s, "#", addRepeatedLine(title.length() + 4, ' '), "#");
		addLineSequence(s, addRepeatedLine(title.length() + 6, '#'));
		newLine(s);
		return s;
	}
	
	private static String addRepeatedLine(int length, char appendant)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++)
		{
			sb.append(appendant);
		}
		return sb.toString();
	}
	
	private static void addLineSequence(List<String> list, String... obj)
	{
		StringBuilder sb = new StringBuilder();
		for (String s : obj)
		{
			sb.append(s);
		}
		list.add(sb.toString());
	}
	
	public static void newLine(List<String> list)
	{
		list.add("");
	}
	
	public static void addString(List<String> list, String ID, String string, String comment) {
		addComment(list, comment);
		list.add("  S:" + ID + "=" + string);
		newLine(list);
	}
	
	public static void addInteger(List<String> list, String ID, int intval, String comment) {
		addComment(list, comment);
		list.add("  I:" + ID + "=" + intval);
		newLine(list);
	}
	
	public static void addLong(List<String> list, String ID, long longval, String comment) {
		addComment(list, comment);
		list.add("  L:" + ID + "=" + longval);
		newLine(list);
	}
	
	public static void addFloat(List<String> list, String ID, float floatval, String comment) {
		addComment(list, comment);
		list.add("  F:" + ID + "=" + floatval);
		newLine(list);
	}
	
	public static void addDouble(List<String> list, String ID, double doubleval, String comment) {
		addComment(list, comment);
		list.add("  D:" + ID + "=" + doubleval);
		newLine(list);
	}
	
	public static void addBoolean(List<String> list, String ID, boolean booleanval, String comment) {
		addComment(list, comment);
		list.add("  B:" + ID + "=" + booleanval);
		newLine(list);
	}
	
	public static void addComment(List<String> list, String comment) {
		list.add("  #" + comment);
	}
}
