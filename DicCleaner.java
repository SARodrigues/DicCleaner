import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;
import java.util.TreeSet;

public class DicCleaner {

	private static final Pattern pattern = Pattern.compile("^([a-zA-ZÀ-ÿ0-9\\-]+)(\\s|/)*.*$");

	private static File srcFile;
	private static File destFile;

	private static Set<String> dictSet = new TreeSet<String>();;

	public static void main(String[] args) {
		srcFile = new File(args[0]);
		destFile = new File(args[1]);

		loadSourceFile();
		writeDictionary();

		System.out.println("All done!");
	}

	private static void loadSourceFile() {
		System.out.println("Loading source file...");

		FileReader fileReader = null;
		BufferedReader reader = null;

		try {
			fileReader = new FileReader(srcFile);
			reader = new BufferedReader(fileReader);

			boolean first = true;
			for (String line; (line = reader.readLine()) != null; ) {
				if (first) {
					first = false;
					continue;
				}
				
				Matcher matcher = pattern.matcher(line);
				if (!matcher.find()) continue;
				if (matcher.group(1).matches("\\s*")) continue;

				dictSet.add(matcher.group(1));
			}

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
			try {
				if (reader != null) reader.close();	
				if (fileReader != null) fileReader.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
	}

	private static void writeDictionary() {
		System.out.println("Writing dictionary to disk...");

		FileWriter fileWriter = null;
		BufferedWriter writer = null;

		try {
			fileWriter = new FileWriter(destFile);
			writer = new BufferedWriter(fileWriter);

			for (String word : dictSet) {
				writer.write(word + "\r\n");
			}

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
			try {
				if (writer != null) writer.close();	
				if (fileWriter != null) fileWriter.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
	}

}