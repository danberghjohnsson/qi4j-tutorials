package org.qi4j.tutorials.composites.tutorial4;

import org.qi4j.api.mixin.Mixins;

/**
 * This interface contains only the state
 * of the HelloWorld object.
 * The exceptions will be thrown by Qi4j automatically if
 * null is sent in as values. The parameters would have to be declared
 * as @Optional if null is allowed.
 */
@Mixins( HelloWorldStateMixin.class )
public interface HelloWorldState
{
    void setPhrase( String phrase )
        throws IllegalArgumentException;

    String getPhrase();

    void setName( String name )
        throws IllegalArgumentException;

    String getName();
}
