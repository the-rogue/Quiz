/**
 * This File is Part of Quiz
 * (C) 2017 The Rogue, All Rights Reserved
 */
package therogue.quiz.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author The Rogue
 *
 */
public class GeneralUtils
{	
	public static Font createFont(String file, int size){
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File(file));
			//font = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getClassLoader().getResourceAsStream("256BYTES.ttf"));
			font = font.deriveFont(Font.PLAIN, size);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return font;
	}
	
	public static String getListText(List<String> list) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (String s : list) {
			if (!first) {
				sb.append("\n");
			} else {
				first = false;
			}
			sb.append("-");
			sb.append(s);
		}
		return sb.toString();
	}
}
