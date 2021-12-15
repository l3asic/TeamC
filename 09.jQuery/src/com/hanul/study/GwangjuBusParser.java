package com.hanul.study;

import java.net.URL;

import net.htmlparser.jericho.Source;

public class GwangjuBusParser {
	//Jericho Html Parser ▶ jericho-html-3.4.jar > WebContent > WEB-INF > lib
	public Source makeJson() {
		Source source = null;
		try {
			String addr = "http://api.gwangju.go.kr/json/lineInfo";
			URL url = new URL(addr);
			source = new Source(url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("makeJson() Exception!!!");
		}
		return source;
	}//makeJson()
	
	public Source makeXml() {
		Source source = null;
		try {
			String addr = "http://api.gwangju.go.kr/xml/lineInfo";
			URL url = new URL(addr);
			source = new Source(url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("makeJson() Exception!!!");
		}
		return source;
	}//makeXml()
	
	public static void main(String[] args) {
		GwangjuBusParser parser = new GwangjuBusParser();
		//System.out.println(parser.makeJson());
		System.out.println(parser.makeXml());
	}
}//class
