package com.practise;

import java.io.FileReader;
import java.util.Properties;
import org.skife.config.ConfigurationObjectFactory;
import com.glam.congfigmagic.MyConfig;
import com.glam.guice.Library;
import com.glam.guice.MyModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {
	
	public static void main(String[] args) {
		Properties p = new Properties();
		String pass = null;
		System.out.println("-- Start -- ");
		try  
		{
			FileReader reader = new FileReader("Credentials.properties");
			p.load(reader);
			pass = p.getProperty("myApp.userPass");
			p.setProperty("userPass", pass);
		} catch (Exception e) {
			System.out.println("Error in reading Property File...");
		}
		
		System.out.println("-- Check 1 -- ");
		ConfigurationObjectFactory factory=new ConfigurationObjectFactory(p);
		MyConfig conf = factory.build(MyConfig.class);
		

		System.out.println("User Details Are : { " +conf.getName() +" , "+conf.getPass() + " } ");
		 

		//Reading parameters from Configuration Magic
		if(conf.getName().equals(conf.getName()) && conf.getPass().equals(conf.getPass()))
		{
			System.out.println("\n\n\t\t --- Welcome Admin --- ");
			System.out.println("\n\n");
		}
		else
		{
			System.out.println("\n\n\t\t Sorry, You are not Authorize...");
			System.out.println("\n\nTerminating");
			System.exit(0);
		}
		
		
		Injector inj = Guice.createInjector(new MyModule());
		Library l= inj.getInstance(Library.class);
		
		l.issueBook("Software Engineering by Roger PressMan", "456");
		
		System.out.println("\t\tBook Is Issued");
		
		System.out.println("\n\n\t\t-- End --");
	}


	
	
	

}
