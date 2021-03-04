package lab3;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import textproc.GeneralWordCounter;

public class BookReaderApplication {
	public static void main(String[] args) {
		final String delimiter = "(\\s|,|\\.|:|;|!|\\?|'|\\\")+";
		
		try {	
			Scanner s1 = new Scanner(new File("undantagsord.txt"));
			s1.useDelimiter(delimiter);

			Set<String> stopwords = new HashSet<>();

			while (s1.hasNext()) {
				stopwords.add(s1.next());
			}

			s1.close();
			
			Scanner s2 = new Scanner(new File("nilsholg.txt"));
			s2.findWithinHorizon("\uFEFF", 1);
			s2.useDelimiter(delimiter); 
			
			GeneralWordCounter counter = new GeneralWordCounter(stopwords);
			
			while (s2.hasNext()) {
				String word = s2.next().toLowerCase();
				counter.process(word);
			}
			
			BookReaderController controller = new BookReaderController(counter);
			

		} catch (Exception e) {

		}
	}

}
