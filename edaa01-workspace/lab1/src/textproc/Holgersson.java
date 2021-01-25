package textproc;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {
	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();
		Scanner s1 = new Scanner(new File("undantagsord.txt"));
		s1.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		Set<String> stopwords = new HashSet<>();

		while(s1.hasNext()) {
			stopwords.add(s1.next());
		}

		s1.close();


		TextProcessor[] ps = new TextProcessor[] {
				new SingleWordCounter("nils"),
				new SingleWordCounter("norge"),
				new MultiWordCounter(REGIONS),
				new GeneralWordCounter(stopwords)
		};

		Scanner s2 = new Scanner(new File("nilsholg.txt"));
		s2.findWithinHorizon("\uFEFF", 1);
		s2.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s2.hasNext()) {
			String word = s2.next().toLowerCase();
			for (TextProcessor p : ps) {
				p.process(word);
			}
		}

		s2.close();
		for (TextProcessor p : ps) {
			p.report();
		}

		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
	}
}