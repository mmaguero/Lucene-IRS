package tags;

/*import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.lucene.index.DocsEnum;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

import document.MyFile;*/

public class TermFreq {
	/*
	 * public static String getTermFreq(String indexDirectoryName) throws
	 * Exception { Integer threshold = new Integer( 1100 );
	 * 
	 * @SuppressWarnings("deprecation") IndexReader reader =
	 * IndexReader.open(FSDirectory.open(new File(indexDirectoryName)));
	 * List<Freq> termList = new ArrayList<>(); for(var i=0; i<reader.get) { if(
	 * enum.docFreq( ) >= threshold.intValue( ) && enum.term( ).field( ).equals(
	 * "speech" ) ) { Freq freq = new Freq( enum.term( ).text( ), enum.docFreq(
	 * ) ); termList.add( freq ); } } Collections.sort( termList );
	 * Collections.reverse( termList ); System.out.println( "Frequency | Term"
	 * ); Iterator iterator = termList.iterator( ); while( iterator.hasNext( ) )
	 * { Freq freq = (Freq) iterator.next( ); System.out.print( freq.frequency
	 * ); System.out.println( " | " + freq.term ); } }
	 * 
	 * public static class Freq implements Comparable { String term; int
	 * frequency;
	 * 
	 * public Freq( String term, int frequency ) { this.term = term;
	 * this.frequency = frequency; }
	 * 
	 * public int compareTo(Object o) { if( o instanceof Freq ) { Freq oFreq =
	 * (Freq) o; return new CompareToBuilder( ) .append( frequency,
	 * oFreq.frequency ) .append( term, oFreq.term ) .toComparison( ); } else {
	 * return 0; } } }
	 */
	// http://filotechnologia.blogspot.com.es/2013/11/get-tf-and-idf-of-all-terms-of-index.html
	/*
	 * public static String forTagsCloud(String indexDirectoryName) {
	 * 
	 * @SuppressWarnings("deprecation") IndexReader reader =
	 * IndexReader.open(FSDirectory.open(new File(indexDirectoryName)));
	 * 
	 * // Calculating the Term Frequencies for (int docID = 0; docID <
	 * reader.maxDoc(); docID++) { TermsEnum termsEnum =
	 * MultiFields.getTerms(reader, field).iterator(null); DocsEnum docsEnum =
	 * null;
	 * 
	 * Terms vector = reader.getTermVector(docId, CONTENT);
	 * 
	 * try { termsEnum = vector.iterator(termsEnum); } catch
	 * (NullPointerException e) { e.printStackTrace(); } BytesRef bytesRef =
	 * null; while ((bytesRef = termsEnum.next()) != null) { if
	 * (termsEnum.seekExact(bytesRef, true)) { String term =
	 * bytesRef.utf8ToString(); float tf = 0;
	 * 
	 * docsEnum = termsEnum.docs(null, null, DocsEnum.FLAG_FREQS); while
	 * (docsEnum.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) { tf =
	 * tfidfSIM.tf(docsEnum.freq()); termFrequencies.put(term, tf); }
	 * 
	 * float idf = docFrequencies.get(term); float w = tf * idf;
	 * tf_Idf_Weights.put(term, w); } }
	 * 
	 * return tf_Idf_Weights; }
	 * 
	 * return null; }
	 */
}