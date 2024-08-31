package utils;
 
import java.awt.Font;
import java.io.File;


public class Poppins {

	static File fontStyle;
	static Font customFont;
	
	public static Font getPoppins(float size) {
		try {
			 fontStyle = new File("res\\fonts\\Poppins-Regular.ttf");
			 customFont = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(size);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return customFont;
	}
	
	
	public static Font getPoppinsBold(float size) {
		try {
			 fontStyle = new File("res\\fonts\\Poppins-Bold.ttf");
			 customFont = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(size);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return customFont;
	}
	
	

}

    

