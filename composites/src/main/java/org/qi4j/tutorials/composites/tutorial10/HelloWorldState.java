package org.qi4j.tutorials.composites.tutorial10;

import org.qi4j.api.property.Property;

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
    Property<String> phrase();
    Property<String> name();
}