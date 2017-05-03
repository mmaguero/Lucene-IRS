package engine;

import document.MyFile;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.xml.sax.SAXException;
import org.apache.lucene.analysis.es.SpanishAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class Search {

	public static void main(String[] args)
			throws ParserConfigurationException, IOException, SAXException, ParseException {
		List<MyFile> items = Search.search("GORILA"); // for test you search
		for (MyFile i : items)
			System.out.println(i.getTitle());
	}

	@SuppressWarnings("deprecation")
	public static List<MyFile> search(String inputText) throws IOException, ParseException {

		List<MyFile> results = new ArrayList<>(); // return

		// Create the analyzer
		SpanishAnalyzer analyzer = new SpanishAnalyzer(Version.LUCENE_43,
				new CharArraySet(Version.LUCENE_43,
						Arrays.asList(StringUtils
								.split(FileUtils.readFileToString(new File(MyFile.stopWordsFileName), "ISO-8859-1"))),
						true));

		// Read and search indexes
		Directory directory = FSDirectory.open(new File(MyFile.indexDirectoryName));
		DirectoryReader iReader = DirectoryReader.open(directory);

		IndexSearcher iSearcher = new IndexSearcher(iReader);

		// Parse a simple query that searches for inputQuery
		QueryParser parser = new QueryParser(Version.LUCENE_43, "text", analyzer);
		Query query = parser.parse(inputText);

		// Search
		ScoreDoc[] hits = iSearcher.search(query, null, 1000).scoreDocs;

		// initialize
		Document hitDoc;
		String title, text;

		// Iterate through the results
		int i;
		for (i = 0; i < hits.length; i++) {
			hitDoc = iSearcher.doc(hits[i].doc);
			title = hitDoc.get("title");
			text = hitDoc.get("text");

			results.add(new MyFile(title, text));
		}

		iReader.close();
		directory.close();

		return results;
	}
}
