package edu.mum.cs545.persistence;

public interface DataAccess {
	public void saveBookStore(BookStore bookStore);
	public BookStore readBookStore();
}
