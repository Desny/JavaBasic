package com.dfbz.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://staticfile.tujia.com/upload/info/day_140829/201408291110208765.jpg");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			OutputStream out = new FileOutputStream("pic.jpg");
			int len = -1;
			while((len=in.read())!=-1) {
				out.write(len);
			}
			out.close();
			in.close();
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
