package org.qi4j.tutorials.composites.tutorial7;

/**
 * This interface contains only the state
 * of the HelloWorld object.
 * <p/>
 * It declares the standard generic Mixin
 * as default implementation.
 * <p/>
 * Since there is no specific Mixin for this
 * interface the Assertion is declared here.
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
