package org.qi4j.tutorials.services.step4;


public interface Library
{
    Book borrowBook( String author, String title );

    void returnBook( Book book );
}