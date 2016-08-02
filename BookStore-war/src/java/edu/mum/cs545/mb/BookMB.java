/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.mb;

import edu.mum.cs545.model.Author;
import edu.mum.cs545.model.Book;
import edu.mum.cs545.model.Category;
import edu.mum.cs545.model.Comment;
import edu.mum.cs545.model.Person;
import edu.mum.cs545.service.AuthorService;
import edu.mum.cs545.service.BookService;
import edu.mum.cs545.service.CategoryService;
import edu.mum.cs545.service.CommentService;
import edu.mum.cs545.service.PersonService;
import edu.mum.cs545.utils.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Lin
 */
@Named(value = "bookMB")
@SessionScoped
public class BookMB implements Serializable {
    
    @EJB
    private BookService bookService;
    
    @EJB
    private CommentService commentService;
    
    @EJB
    private PersonService personService;
    
    @EJB
    private CategoryService categoryService;
    
    @EJB
    private AuthorService authorSevice;
    
    private String searchValue;
    private Book book;
    private List<Book> filteredBooks;
    private List<String> fontPageImages;
    private Author author;
    private List<Category> categories;
    private Part file;
    private UploadedFile uploadedFile;

    private List<String> prices;
    private String[] selectedPrices;
    private String[] selectedCategories;
    private Set<Book> bookSet;
    private int bookCount;
    private String totalPrice;
    private String sortByPrice;
    private List<String> sortByPriceTypes;
    private String imageName;
    
    public BookMB() {
        filteredBooks = new ArrayList<Book>();
        fontPageImages = new ArrayList<String>();
        categories = new ArrayList<Category>();
        author = new Author();
        book = new Book();
        bookSet = new HashSet<Book>();
        totalPrice = "0.00";
        
        for (int i = 1; i <= 5; i++) {
            fontPageImages.add("fg" + i + ".jpg");
        }
        
        prices = new ArrayList<String>();
        prices.add("lower than $10.00");
        prices.add("$10.00 - 19.99");
        prices.add("$20.00 - 29.99");
        prices.add("$30.00 -39.99");
        prices.add("$40.00 - 49.99");
        prices.add("more than $50.00");
        
        sortByPriceTypes = new ArrayList<String>();
        sortByPriceTypes.add("Lowest to highest");
        sortByPriceTypes.add("Highest to lowest");
    }
    
    public String findAllBooks() {
        this.filteredBooks = bookService.findAll();
        return "viewBooks.jsf";
    }
    
    public List<Comment> findAllComments() {
        return commentService.findAll();
    }
    
    public List<Person> findAllPersons() {
        return personService.findAll();
    }
    
    public Book getBook() {
        return book;
    }
    
    public void setBook(Book bk) {
        this.book = bk;
    }
    
    public List<String> getCategoriesNames() {
        List<String> res = new ArrayList<String>();
        List<Category> categies = categoryService.findAll();
        
        for (Category c : categies) {
            res.add(c.getCgName());
        }
        
        return res;
    }
    
    public String getSearchValue() {
        return searchValue;
    }
    
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    public List<Book> getFilteredBooks() {
        return filteredBooks;
    }
    
    public void setFilteredBooks(List<Book> filteredBooks) {
        this.filteredBooks = filteredBooks;
    }
    
    public List<String> getImages() {
        return fontPageImages;
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public String getCategoryNameByCategoryId(long categoryId) {
        return categoryService.findOne(categoryId).getCgName();
    }
    
    public String getCategoryNameByBookId(long bookId) {
        String name = categoryService.findOneByBookId(bookId).getCgName();
        return name;
    }
    
    public List<Category> getCategories() {
        categories = categoryService.findAll();
        return categories;
    }
    
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    public int getBookCount() {
        return bookCount;
    }
    
    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public String getSortByPrice() {
        return sortByPrice;
    }
    
    public void setSortByPrice(String sortByPrice) {
        this.sortByPrice = sortByPrice;
    }
    
    public List<String> getSortByPriceTypes() {
        return sortByPriceTypes;
    }
    
    public void setSortByPriceTypes(List<String> sortByPriceTypes) {
        this.sortByPriceTypes = sortByPriceTypes;
    }
    
    public List<String> getFontPageImages() {
        return fontPageImages;
    }
    
    public void setFontPageImages(List<String> fontPageImages) {
        this.fontPageImages = fontPageImages;
    }
    
    public String getImageName() {
        return imageName;
    }
    
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    
    public Part getFile() {
        return file;
    }
    
    public void setFile(Part file) {
        this.file = file;
    }
    
    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }
    
    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
    public List<Book> findBooksByName(String searchValue) {
        return this.bookService.findBooksByName(this.searchValue);
    }

    public String outputAuthorName(long authorId) {
        Author author = authorSevice.findOne(authorId);
        
        return author.getFname() + " " + author.getLname();
    }
    
    public String outputCategoryName(long cgId) {
        Category c = categoryService.findOne(cgId);
        
        return c.getCgName();
    }
    
    public String addBookPage() {
        this.book = new Book();
        return "addBook.jsf";
    }
    
    public String resetAdd() {
        this.book = new Book();
        return "addBook.jsf";
    }
    
    public String cancelAdd() {
        this.book = new Book();
        return "viewBooks.jsf";
    }

    public String addBook() {
        long auId = generateAuthorId();
        long bkId = generateBookId();
        Book bk = new Book();
        bk.setBid(bkId);
        bk.setISBN(this.book.getISBN());
        bk.setTitle(this.book.getTitle());
        bk.setYear(this.book.getYear());
        bk.setPrice(this.book.getPrice());
        bk.setCgId(this.book.getCgId());
        bk.setCategory(getCategoryNameByCategoryId(this.book.getCgId()));
        bk.setImageName(this.imageName);
        bk.setStockCount(this.book.getStockCount());
        bk.setAuthorId(auId);
        bk.setStatus(true);
        bk.setCommentList(new ArrayList<Comment>());
        bk.setImportDate(this.book.getImportDate());
        bookService.save(bk);
        
        Author au = new Author();
        au.setAuId(auId);
        au.setFname(this.author.getFname());
        au.setLname(this.author.getLname());
        au.setDOB(this.author.getDOB());
        au.setBiography(this.author.getBiography());
        au.setPublishedBooks(new ArrayList<Long>(Arrays.asList(bkId)));
        au.setStatus(true);
        authorSevice.save(au);
        
        filteredBooks = bookService.findAll();
        
        return "viewBooks.jsf";
    }
    
    public String searchBook() {
        this.filteredBooks = findBooksByName(searchValue);
        return "viewBooks.jsf";
    }
    
    public String addToCart() {
        return "shoppingCart.jsf";
    }
    
    public String goToDetail(Book bk) {
        this.book = bk;
        return "bookDetails.jsf";
    }
    
    public String preEdit(Book bk) {
        this.book = bk;
        return "editBook.jsf";
    }
    
    public String update() {
        bookService.update(this.book);
        this.book = new Book();
        
        return "viewBooks.jsf";
    }
    
    public String delete(Book bk) {
        bookService.delete(bk.getBid());
        this.filteredBooks = bookService.findAll();
        return "viewBooks.jsf";
    }
    
    public void fileUploadListener(FileUploadEvent e) {
        uploadedFile = e.getFile();
        String fileName = uploadedFile.getFileName();
        int dotIndex = fileName.lastIndexOf(".");
        this.imageName = fileName.substring(0, dotIndex);
        
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");

        File outputFile = new File(path + File.separator + "resources" + File.separator + "images" + File.separator + fileName);
//        File outputFile=new File("D:\\"+File.separator+"resources"+File.separator+"images"+File.separator+fileName);
        try {
            FileInputStream in = (FileInputStream) uploadedFile.getInputstream();
            FileOutputStream out = new FileOutputStream(outputFile);
            
            byte[] buffer = new byte[(int) uploadedFile.getSize()];
            int len = 0;
            while ((len = in.read(buffer)) != - 1) {
                out.write(buffer, 0, len);
            }
            out.flush();
            in.close();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private long generateBookId() {
        return bookService.getBookMap().values().size() + 1;
    }
    
    private long generateAuthorId() {
        return authorSevice.getAuthorMap().values().size() + 1;
    }
    
    public List<String> getPrices() {
        return prices;
    }
    
    public void setPrices(List<String> prices) {
        this.prices = prices;
    }
    
    public String[] getSelectedPrices() {
        return selectedPrices;
    }
    
    public void setSelectedPrices(String[] selectedPrices) {
        this.selectedPrices = selectedPrices;
    }
    
    public String[] getSelectedCategories() {
        return selectedCategories;
    }
    
    public void setSelectedCategories(String[] selectedCategories) {
        this.selectedCategories = selectedCategories;
    }
    
    public String getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public void handlePricesChange() {
        int lenPrices = this.selectedPrices.length;
        bookSet = new HashSet<Book>();
        
        for (int i = 0; i < lenPrices; i++) {
            if (selectedPrices[i].equals("lower than $10.00")) {
                addConditionalBooksByPrices(bookSet, 0.0, 9.99);
            } else if (selectedPrices[i].equals("$10.00 - 19.99")) {
                addConditionalBooksByPrices(bookSet, 10.00, 19.99);
            } else if (selectedPrices[i].equals("$20.00 - 29.99")) {
                addConditionalBooksByPrices(bookSet, 20.00, 29.99);
            } else if (selectedPrices[i].equals("$30.00 -39.99")) {
                addConditionalBooksByPrices(bookSet, 30.00, 39.99);
            } else if (selectedPrices[i].equals("$40.00 - 49.99")) {
                addConditionalBooksByPrices(bookSet, 40.00, 49.99);
            } else {
                addConditionalBooksByPrices(bookSet, 50.00, Double.MAX_VALUE);
            }
        }
        
        this.filteredBooks = new ArrayList<Book>(bookSet);

        //if no checkbox is selected, show all the books.
        if (filteredBooks.size() == 0) {
            filteredBooks = bookService.findAll();
        }
    }
    
    public void handleCategoryChange() {
        int lenCategories = selectedCategories.length;
        
        bookSet = new HashSet<Book>();
        
        for (int i = 0; i < lenCategories; i++) {
            if (selectedCategories[i].equals("IT")) {
                addConditionalBooksByCategory(bookSet, "IT");
            } else if (selectedCategories[i].equals("History")) {
                addConditionalBooksByCategory(bookSet, "History");
            } else if (selectedCategories[i].equals("Economy")) {
                addConditionalBooksByCategory(bookSet, "Economy");
            } else if (selectedCategories[i].equals("Fiction")) {
                addConditionalBooksByCategory(bookSet, "Fiction");
            } else if (selectedCategories[i].equals("Biography")) {
                addConditionalBooksByCategory(bookSet, "Biography");
            }
        }
        
        this.filteredBooks = new ArrayList<Book>(bookSet);

        //if no checkbox is selected, show all the books.
        if (filteredBooks.size() == 0) {
            filteredBooks = bookService.findAll();
        }
    }
    
    public void handlePrice() {
        if (this.bookCount == 0) {
            this.totalPrice = String.format("%.2f", this.book.getPrice());
        } else {
            this.totalPrice = String.format("%.2f", book.getPrice() * this.bookCount);
        }
    }
    
    public void handleSortByPrice() {
        if (this.sortByPrice.equals("Lowest to highest")) {
            Comparator<Book> comparator = new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return Double.compare(o1.getPrice(), o2.getPrice());
                }
            };
            
            Collections.sort(this.filteredBooks, comparator);
        } else {
            Comparator<Book> comparator = new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return Double.compare(o2.getPrice(), o1.getPrice());
                }
            };
            
            Collections.sort(this.filteredBooks, comparator);
        }
    }

    public Author getAuthorByBookId(long bookId){
        Author au = authorSevice.findOne(bookId);
        if(au == null){
            au = new Author();
        }
        
        return au;
    }
    
    private void addConditionalBooksByPrices(Set<Book> books, double min, double max) {
        List<Book> bookList = bookService.findAll();
        
        for (Book bk : bookList) {
            if (bk.getPrice() >= min && bk.getPrice() <= max) {
                books.add(bk);
            }
        }
    }
    
    private void addConditionalBooksByCategory(Set<Book> books, String categoryName) {
        List<Book> bookList = bookService.findAll();
        
        for (Book bk : bookList) {
            if (getCategoryNameByBookId(bk.getBid()).equals(categoryName)) {
                books.add(bk);
            }
        }
    }
    
    private String getCategoryNameById(long cgId) {
        ServletContext sct = Utilities.getServletContext();
        HashMap<Long, Category> categoryMap = (HashMap<Long, Category>) sct.getAttribute("categoryMap");
        
        return categoryMap.get(cgId).getCgName();
    }
}
