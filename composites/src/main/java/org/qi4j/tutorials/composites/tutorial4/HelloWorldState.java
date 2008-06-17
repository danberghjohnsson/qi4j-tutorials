package org.qi4j.tutorials.composites.tutorial4;

import org.qi4j.composite.Mixins;

/**
 * This interface contains only the state
 * of the HelloWorld object.
 */
@Mixins( HelloWorldStateMixin.class )
public interface HelloWorldState
{
    void setPhrase(String phrase)
        throws IllegalArgumentException;
    String getPhrase();

    void setName(String name)
        throws IllegalArgumentException;
    String getName();
}
