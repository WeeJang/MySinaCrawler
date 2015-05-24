package edu.bjtu.myc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.omg.CORBA.TIMEOUT;


public class Utils {

	//root_dir
	// switch to e:/result/tweet/
	public static final String ROOTDIR = "/home/jangwee/result/tweet/";
	
	//http_timeout(ms)
	public static final int HTTP_TIMEOUT = 6000 ; 
	
	//modify
	public static void write2disk(String searchword,String dirPath,Integer pageIndex ,String htmlInfo) throws IOException{
		File f = new File(dirPath +  searchword + "/" + pageIndex + ".html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write(htmlInfo);
		bw.close();
	}
	//end 
	
	
	public static void main(String[] args) throws IOException{
		String saveTXTPath = "/home/jangwee/result/tweet/tweettxt/samsung.txt";
		String searchword = "samsung";
		HTMLParser htmlParser = new HTMLParser();
		Vector<String> tweets = htmlParser.write2txt(searchword, "/home/jangwee/result/tweet/tweethtml/samsung", saveTXTPath);
		String saveXMLPath = "/home/jangwee/result/tweet/tweetxml/" + "/" + searchword + ".xml";
		htmlParser.writeVector2xml(tweets, saveXMLPath);
		System.out.println("Save to txt & xml files succeed.");
	}

}
