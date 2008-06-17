package org.qi4j.samples.tutorials.composites.tutorial4;

import org.qi4j.composite.Mixins;
import org.qi4j.library.framework.constraint.annotation.NotNull;
import org.qi4j.property.Property;

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
