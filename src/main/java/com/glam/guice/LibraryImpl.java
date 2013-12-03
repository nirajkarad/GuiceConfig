package com.glam.guice;

import com.google.inject.Inject;

public class LibraryImpl implements Library{
	
	private final Library lib;
	
	@Inject
	public LibraryImpl(Library l) {
		this.lib = l;
	}

	@Override
	public void issueBook(String name, String id) {
		System.out.println("\t\tIssuing Book { "+name+" , "+id+" } ");
	}

}
