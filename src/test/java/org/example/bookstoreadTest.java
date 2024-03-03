package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class bookstoreadTest {
    List<String> books;
    Bookstoread store;

    @BeforeEach
    public void initEach() {
        store = new Bookstoread();

    }

    @Test
    public void emptyBookShelfWhenNoBookAdded() {
        books = store.getBooksList();
        assertTrue(books.isEmpty(), () -> "List initaly should be empty ");
    }

    @Test
    public void booksShouldContainTwoBooksWhenTwoAdded() {
        books = store.getBooksList();
        store.addBooks("Math for everyone");
        store.addBooks("i9adh 3elmi");
        assertEquals(books.size(), 2, () -> "Should contain exactly two books");
    }

    @Test
    public void emptyBooksShelfWhenAddIsCalledWithoutBooks() {
        books = store.getBooksList();
        store.addManyBooks(new String[]{"Math for everyone", "i9adh 3elmi"});
        int sizeInit = books.size();
        store.addBooksV2("");
        assertEquals(books.size(), sizeInit);
    }

    @Test
    public void booksReturnedFromBookShelfIsImmutableForClient() {
        books = store.getBooksListV2();
        store.addManyBooks(new String[]{"Math for everyone", "i9adh 3elmi","ppppp"});
        try {
            books.add("The MythicalMan-Month");
            fail(() -> "Should not be able to add book to books");
        } catch(Exception e) {
            //l'opération d'ajout ne doit pas etre exécutée et donc ça donne une exeption de type UnsupportedOperationException
            assertTrue(e instanceof UnsupportedOperationException, ()-> "Should throw UnsupportedOperationException.");
        }
    }

    @Test
    public void booksInBookShelfAreInInsertionOrderAfterCallingArrange()
    {
        books = store.getBooksListV2();
        List<String> booksInitialValues = new ArrayList<>(books);
        try {
            store.bookshelfArrangeByBookTitle(books);
        }catch(Exception e) {
            assertTrue(books.equals(booksInitialValues),()-> "books should maintain the same order before the tree");
        }
    }
}
