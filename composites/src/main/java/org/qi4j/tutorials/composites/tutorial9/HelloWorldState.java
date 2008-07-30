package org.qi4j.tutorials.composites.tutorial9;

import org.qi4j.library.constraints.annotation.NotNull;
import org.qi4j.property.Property;

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
public interface HelloWorldState
{
    @NotNull Property<String> phrase();
    @NotNull Property<String> name();
}
