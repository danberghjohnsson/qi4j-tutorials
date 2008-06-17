package org.qi4j.tutorials.composites.tutorial2;

/**
 * This interface contains only the state
 * of the HelloWorld object.
 */
public interface HelloWorldState
{
    void setPhrase( String phrase )
        throws IllegalArgumentException;

    String getPhrase();

    void setName( String name )
        throws IllegalArgumentException;

    String getName();
}
