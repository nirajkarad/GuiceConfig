package com.glam.congfigmagic;

import org.skife.config.Config;
import org.skife.config.Default;


public interface MyConfig {
	@Config("userName")
	@Default("Admin")
	public String getName();
	
	@Config("userPass")
	public String getPass();
	
}
