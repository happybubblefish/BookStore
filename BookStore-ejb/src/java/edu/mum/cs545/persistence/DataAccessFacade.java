package edu.mum.cs545.persistence;

import edu.mum.cs545.persistence.BookStore;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataAccessFacade implements DataAccess {

    public static final String OUTPUT_DIR = System.getProperty("user.dir")
            + "/src/java/edu/mum/cs545/persistence/storage/";
    public static final String DATE_PATTERN = "MM/dd/yyyy";

    public void saveBookStore(BookStore bookStore) {
        ObjectOutputStream out = null;
        try {
            Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "BookStore.ser");
            out = new ObjectOutputStream(Files.newOutputStream(path));
            out.writeObject(bookStore);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public BookStore readBookStore() {
        ObjectInputStream in = null;
        BookStore library = null;
        try {
            Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "BookStore.ser");
            System.out.println(path.toAbsolutePath());
            in = new ObjectInputStream(Files.newInputStream(path));
            library = (BookStore) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
        }
        return library;
    }
}
