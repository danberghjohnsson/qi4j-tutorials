package org.qi4j.tutorials.composites.tutorial10;

import org.qi4j.api.property.Property;
import org.qi4j.api.property.Immutable;
import org.qi4j.library.constraints.annotation.NotEmpty;

/**
 * This interface contains only the state
 * of the HelloWorld object.
 */
public interface HelloWorldState
{
    @NotEmpty Property<String> phrase();
    @NotEmpty Property<String> name();
}