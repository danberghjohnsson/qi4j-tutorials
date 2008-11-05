package org.qi4j.tutorials.composites.tutorial6;

import org.qi4j.library.constraints.annotation.NotNull;
import org.qi4j.composite.Mixins;

/**
 * This interface contains only the state
 * of the HelloWorld object.
 * <p/>
 * It declares the standard generic Mixin
 * as default implementation.
 * <p/>
 * Since there is no specific Mixin for this
 * interface the Concern is declared here.
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
