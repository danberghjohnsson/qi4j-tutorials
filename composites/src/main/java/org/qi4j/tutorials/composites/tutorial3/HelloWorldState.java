package org.qi4j.tutorials.composites.tutorial3;

/**
 * This interface contains only the state
 * of the HelloWorld Composite.
 */
public interface HelloWorldState
{
    void setPhrase(String phrase)
        throws IllegalArgumentException;
    String getPhrase();

    void setName(String name)
        throws IllegalArgumentException;
    String getName();
}
