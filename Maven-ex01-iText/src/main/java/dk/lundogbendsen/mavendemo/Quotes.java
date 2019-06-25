package dk.lundogbendsen.mavendemo;

import java.io.FileOutputStream;
import java.util.Random;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Quotes {

	
	public String getTodaysQuote() {
		String[] quotes = { "To be or not to be", "Go make my day, punk", "Hasta la vista, baby" };
		return quotes[new Random().nextInt(quotes.length)];
	}

	
	private static final String FILE = "./out.pdf";
	private static Font headFont = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.NORMAL, BaseColor.RED);

	public void saveQuoteAsPdf() throws Exception {
		// Creating a PdfWriter
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(FILE));
		document.open();

		 String filename = "./src/main/resources/logo.jpg";
         Image image = Image.getInstance(filename);
         document.add(image);
		
		Paragraph heading = new Paragraph("Quotes", headFont);
		document.add(heading);

		Paragraph contents = new Paragraph();
		for (int i = 0; i < 10; i++) {
			contents.add(new Paragraph(getTodaysQuote(), redFont));
		}
		document.add(contents);
		document.close();
	}

}
