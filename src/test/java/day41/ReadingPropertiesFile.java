package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//Get the location of the properties file
		FileInputStream File= new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		
		//Loading the properties file
		Properties propertiesobj = new Properties();
		propertiesobj.load(File);
		
		//Reading data from properties file
		String url = propertiesobj.getProperty("appurl");
		String email = propertiesobj.getProperty("email");
		String pw = propertiesobj.getProperty("password");
		String odrid = propertiesobj.getProperty("orderid");
		String cusid = propertiesobj.getProperty("customerid");
		
		System.out.println(url+"  "+email+"  "+pw+"  "+odrid+"  "+cusid);
		
		//Reading all keys form properties file
		Set<String> keys = propertiesobj.stringPropertyNames();
		System.out.println(keys);
		
		//Method2
		Set<Object> keys2 = propertiesobj.keySet();
		System.out.println(keys2);
		
		//Reading all values form properties file
		Collection<Object> values = propertiesobj.values();
		System.out.println(values);
		
		File.close();
	}

}
