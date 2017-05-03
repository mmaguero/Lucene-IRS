package document;

import java.io.File;

public class MyFile {

	public static final String documentsDirectoryName = "WebContent" + File.separator + "data" + File.separator + "efe"
			+ File.separator;
	public static String indexDirectoryName = "WebContent" + File.separator + "data" + File.separator + "indexes"
			+ File.separator,
			stopWordsFileName = "WebContent" + File.separator + "data" + File.separator + "palabras_vacias_utf8.txt";

	private String title, text;

	public MyFile(String title, String text) {
		super();
		this.title = title;
		this.text = text;
	}

	public MyFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	// setters no, because is an IRS

	public String getTitle() {
		return title;
	}

	/*
	 * public void setTitle(String title) { this.title = title; }
	 */

	public String getText() {
		return text;
	}

	/*
	 * public void setText(String text) { this.text = text; }
	 */

}
