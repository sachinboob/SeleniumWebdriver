package com.demo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * This is a simple text extraction example to get started. For more advance
 * usage, see the ExtractTextByArea and the DrawPrintTextLocations examples in
 * this subproject, as well as the ExtractText tool in the tools subproject.
 *
 * @author Tilman Hausherr
 */
public class ExtractTextSimple {
	private ExtractTextSimple() {
		// example class should not be instantiated
	}

	/**
	 * This will print the documents text page by page.
	 *
	 * @param args The command line arguments.
	 *
	 * @throws IOException If there is an error parsing or extracting the document.
	 */
	public static void extractText(String filePath) throws IOException {


		try (PDDocument document = PDDocument.load(new File(filePath))) {
			AccessPermission ap = document.getCurrentAccessPermission();
			if (!ap.canExtractContent()) {
				throw new IOException("You do not have permission to extract text");
			}

			PDFTextStripper stripper = new PDFTextStripper();

			// This example uses sorting, but in some cases it is more useful to switch it
			// off,
			// e.g. in some files with columns where the PDF content stream respects the
			// column order.
			stripper.setSortByPosition(false);

			for (int p = 1; p <= document.getNumberOfPages(); ++p) {
				System.out.println("In loop...");
				// Set the page interval to extract. If you don't, then all pages would be
				// extracted.
				stripper.setStartPage(p);
				stripper.setEndPage(p);

				// let the magic happen
				String text = stripper.getText(document);

				// do some nice output with a header
				String pageStr = String.format("page %d:", p);
				System.out.println(pageStr);
				for (int i = 0; i < pageStr.length(); ++i) {
					System.out.print("-");
				}
				System.out.println();
				System.out.println(text.trim());
				System.out.println();

				// If the extracted text is empty or gibberish, please try extracting text
				// with Adobe Reader first before asking for help. Also read the FAQ
				// on the website:
				// https://pdfbox.apache.org/2.0/faq.html#text-extraction
			}
		}
	}

	/**
	 * This will print the usage for this document.
	 */
	private static void usage() {
		System.err.println("Usage: java " + ExtractTextSimple.class.getName() + " <input-pdf>");
		System.exit(-1);
	}
}