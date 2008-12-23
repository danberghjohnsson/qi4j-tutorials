package org.qi4j.tutorials.composites.tutorial7;

import org.qi4j.library.constraints.annotation.NotEmpty;

/**
 * This interface contains only the state
 * of the HelloWorld object.
 */
public interface HelloWorldState
{
    void setPhrase(@NotEmpty String phrase)
        throws IllegalArgumentException;
    String getPhrase();

    void setName(@NotEmpty String name)
        throws IllegalArgumentException;
    String getName();
}
