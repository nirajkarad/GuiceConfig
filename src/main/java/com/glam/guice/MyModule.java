package com.glam.guice;

import com.google.inject.Binder;
import com.google.inject.Module;

public class MyModule implements Module{

	@Override
	public void configure(Binder binder) {

		binder.bind(Library.class).to(LibraryImpl.class);
		
	}

	
	
}
