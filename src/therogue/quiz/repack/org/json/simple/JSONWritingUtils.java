/**
 * This File is Part of Quiz (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.repack.org.json.simple;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A Utility Class to convert Objects to JSON readable Strings (Which can then be written)
 * 
 * Based heavily on org.json.simple
 * 
 * @author The Rogue
 *
 */
public class JSONWritingUtils
{
	/**
	 * Convert a map to JSON text. The result is a JSON object.
	 * 
	 * @param map
	 * @return JSON text, or "null" if map is null.
	 */
	public static <T, U> String toJSONString(Map<T, U> map, int indentLevel)
	{
		int subIndentLevel = indentLevel + 1;
		if (map == null) return getIndent(indentLevel) + "null";
		
		StringBuffer sb = new StringBuffer();
		boolean first = true;
		Iterator<T> iter = map.keySet().iterator();
		
		sb.append('{');
		sb.append("\n");
		while (iter.hasNext())
		{
			if (first) first = false;
			else
			{
				sb.append(',');
				sb.append("\n");
			}
			
			T key = iter.next();
			sb.append(getIndent(subIndentLevel));
			sb.append('\"');
			if (String.valueOf(key) == null) sb.append("null");
			else sb.append(escape(String.valueOf(key)));
			sb.append('\"').append(':');
			sb.append(toJSONString(map.get(key), subIndentLevel));
		}
		sb.append("\n");
		sb.append(getIndent(indentLevel));
		sb.append('}');
		return sb.toString();
	}
	
	/**
	 * Convert a list to JSON text. The result is a JSON array.
	 * 
	 * @param list
	 * @return JSON text, or "null" if list is null.
	 */
	public static <T> String toJSONString(List<T> list, int indentLevel)
	{
		int subIndentLevel = indentLevel + 1;
		if (list == null) return getIndent(indentLevel) + "null";
		
		boolean first = true;
		StringBuffer sb = new StringBuffer();
		Iterator<T> iter = list.iterator();
		
		sb.append('[');
		sb.append("\n");
		while (iter.hasNext())
		{
			if (first) first = false;
			else
			{
				sb.append(',');
				sb.append("\n");
			}
			
			T value = iter.next();
			sb.append(getIndent(subIndentLevel));
			if (value == null)
			{
				sb.append("null");
				continue;
			}
			sb.append(toJSONString(value, indentLevel));
			
		}
		sb.append("\n");
		sb.append(getIndent(indentLevel));
		sb.append(']');
		
		return sb.toString();
	}
	
	/**
	 * Convert an object to JSON text.
	 * 
	 * @param value
	 * @return JSON text, or "null" if value is null or it's an NaN or an INF number.
	 */
	public static String toJSONString(Object value, int indentLevel)
	{
		if (value == null) return "null";
		
		if (value instanceof String) return "\"" + escape((String) value) + "\"";
		
		if (value instanceof Double)
		{
			if (((Double) value).isInfinite() || ((Double) value).isNaN()) return "null";
			else return value.toString();
		}
		
		if (value instanceof Float)
		{
			if (((Float) value).isInfinite() || ((Float) value).isNaN()) return "null";
			else return value.toString();
		}
		
		if (value instanceof Number) return value.toString();
		
		if (value instanceof Boolean) return value.toString();
		
		if (value instanceof Map) return toJSONString((Map<?, ?>) value, indentLevel);
		
		if (value instanceof List) return toJSONString((List<?>) value, indentLevel);
		
		return value.toString() ;
	}
	
	/**
	 * Creates a the indentation that makes JSON Files easier to read
	 * 
	 * @param indentLevel
	 * @return A string Representing the indent spacing
	 */
	public static String getIndent(int indentLevel)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < indentLevel; i++)
		{
			sb.append("    ");
		}
		return sb.toString();
	}
	
	/**
	 * Gets a writable String Escape quotes, \, /, \r, \n, \b, \f, \t and other control characters (U+0000 through U+001F).
	 * 
	 * @param s
	 *            - Must not be null.
	 * @return The escaped, writable string
	 */
	private static String escape(String s)
	{
		if (s == null) return null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			switch (ch)
			{
				case '"':
					sb.append("\\\"");
					break;
				case '\\':
					sb.append("\\\\");
					break;
				case '\b':
					sb.append("\\b");
					break;
				case '\f':
					sb.append("\\f");
					break;
				case '\n':
					sb.append("\\n");
					break;
				case '\r':
					sb.append("\\r");
					break;
				case '\t':
					sb.append("\\t");
					break;
				case '/':
					sb.append("\\/");
					break;
				default:
					// Reference: http://www.unicode.org/versions/Unicode5.1.0/
					if ((ch >= '\u0000' && ch <= '\u001F') || (ch >= '\u007F' && ch <= '\u009F') || (ch >= '\u2000' && ch <= '\u20FF'))
					{
						String ss = Integer.toHexString(ch);
						sb.append("\\u");
						for (int k = 0; k < 4 - ss.length(); k++)
						{
							sb.append('0');
						}
						sb.append(ss.toUpperCase());
					}
					else
					{
						sb.append(ch);
					}
			}
		}
		return sb.toString();
	}
}
