package engine;

import document.MyFile;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.analysis.es.SpanishAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;

import static org.apache.lucene.index.DirectoryReader.indexExists;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

public class Index {

	private static List<String> getSGMLFiles() {

		List<String> fList = new ArrayList<>();

		// take files of the directory
		File[] files = new File(MyFile.documentsDirectoryName).listFiles();

		// Loop of files
		for (File _f : files) {
			if (_f.isFile() && FilenameUtils.getExtension(_f.getPath()).toUpperCase().equals("SGML")) {
				fList.add(_f.getName());
			}
		}

		return fList;
	}

	private static List<MyFile> getSGMLItems() throws ParserConfigurationException, IOException, SAXException {

		List<MyFile> items = new ArrayList<>(); // for return
		List<String> files = getSGMLFiles(); // Get file names

		// initialize
		String content;
		org.w3c.dom.Document document;
		NodeList nodes;

		// make a poblation
		for (String f : files) {
			// crash format :(
			content = FileUtils.readFileToString(new File(MyFile.documentsDirectoryName + f), "ISO-8859-1");
			content = content.replace("< ", "  ");
			content = content.replace("&", "");
			content = content.replace("<\n<", "\n<");
			content = content.replace(";<", ";");
			content = "<SGML>" + content + "</SGML>";

			// DOM object content
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(
					new String(content.getBytes("ISO-8859-1"), "ISO-8859-1").getBytes("UTF-8")));
			document.getDocumentElement().normalize();

			// root node
			nodes = document.getElementsByTagName("DOC");

			// initialize
			Node node;
			Element element;
			String title, text;

			// Loop of nodes
			int i;
			for (i = 0; i < nodes.getLength(); i++) {
				node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					// element title and text
					element = (Element) node;
					// take value
					title = element.getElementsByTagName("TITLE").item(0).getTextContent();
					text = element.getElementsByTagName("TEXT").item(0).getTextContent();

					// Add to the output
					items.add(new MyFile(title, text));
				}
			}
		}

		return items;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		// TODO Auto-generated method stub
		long time1 = System.currentTimeMillis(), time2;

		System.out.println("Create the analyzer");
		SpanishAnalyzer analyzer = new SpanishAnalyzer(Version.LUCENE_43,
				new CharArraySet(Version.LUCENE_43,
						Arrays.asList(StringUtils
								.split(FileUtils.readFileToString(new File(MyFile.stopWordsFileName), "ISO-8859-1"))),
						true));

		System.out.println("Read news from a directory");
		List<MyFile> items = getSGMLItems();

		System.out.println("Create the index writery");
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_43, analyzer);
		Directory directory = FSDirectory.open(new File(MyFile.indexDirectoryName));
		IndexWriter iWriter = new IndexWriter(directory, config);

		System.out.println("Delete the lastest index ");
		if (indexExists(directory)) {
			iWriter.deleteAll();
		}

		String title, text;
		Document doc;
		System.out.println("Iterate each document");
		for (MyFile i : items) {
			// Get data from file
			title = i.getTitle();
			text = i.getText();

			// indexing data
			doc = new Document();
			doc.add(new Field("title", title, StringField.TYPE_STORED));
			doc.add(new Field("text", text, TextField.TYPE_STORED));
			iWriter.addDocument(doc);
		}

		// Close everything
		iWriter.close();
		directory.close();

		time2 = System.currentTimeMillis();

		System.out.println("Total min. " + ((double) (time2 - time1) / 1000) / 60);
	}

}
