package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bookstoread {
    private final List<String> books = new ArrayList<>() ;
    public List<String> getBooksList()
    {
        return books;
    }

    public List<String> getBooksListV2() {
        return Collections.unmodifiableList(books);
    }
    public void addBooks(String bookName) {
        books.add("bookName");
    }
    public void addBooksV2(String bookName)
    {
        if (bookName.length()>0)
        {
            books.add("bookName");
        }
    }
    public void bookshelfArrangeByBookTitle(List<String> BooksToArrange)
    {
        Collections.sort(BooksToArrange);
    }
    public void addManyBooks(String[] names)
    {
        books.addAll(Arrays.asList(names));
    }

}
