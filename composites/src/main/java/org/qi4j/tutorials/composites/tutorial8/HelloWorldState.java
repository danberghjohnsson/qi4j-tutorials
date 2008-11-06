package org.qi4j.tutorials.composites.tutorial8;

import org.qi4j.property.Property;

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
    Property<String> phrase();
    Property<String> name();
}
