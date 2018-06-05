package Autres;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class PDFTools {
    private static final String AUTHOR_CREATOR = "Caron, Wang";
    private static final Font FONT = new Font(Font.FontFamily.COURIER, 18, Font.BOLD);
    
    public static void generatePDF(Facture f) {
    	try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Facture " + f.getNumero() + ".pdf"));
            doc.open();
            addMetaData(doc, "Facture");
            addContent(doc, f);
            //addContent(doc, f);
            doc.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    private static void addMetaData(Document doc, String arg) {
        doc.addTitle(arg);
        doc.addSubject(arg);
        doc.addKeywords(arg);
        doc.addAuthor(AUTHOR_CREATOR);
        doc.addCreator(AUTHOR_CREATOR);
    }

    private static void addContent(Document document, Facture f) throws DocumentException {
        Paragraph paragraphe = new Paragraph();
        addEmptyLine(paragraphe, 1);// We add one empty line
        paragraphe.add(new Paragraph("Facture n�"+f.getNumero(), FONT));// Lets write a big header

        addEmptyLine(paragraphe, 1);// Will create: Report generated by: _name, _date
        paragraphe.add(new Paragraph(f.toString()));
        
        document.add(paragraphe);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}