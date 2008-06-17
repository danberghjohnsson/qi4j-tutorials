package org.qi4j.samples.tutorials.composites.tutorial7;

import org.qi4j.composite.Concerns;
import org.qi4j.composite.Mixins;
import org.qi4j.composite.SideEffects;
import org.qi4j.library.framework.properties.PropertiesMixin;
import org.qi4j.library.framework.constraint.annotation.NotNull;

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
    void setPhrase(@NotNull String phrase)
        throws IllegalArgumentException;
    String getPhrase();

    void setName(@NotNull String name)
        throws IllegalArgumentException;
    String getName();
}
