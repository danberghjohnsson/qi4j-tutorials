package org.qi4j.tutorials.composites.tutorial8;

import org.qi4j.api.injection.scope.PropertyField;
import org.qi4j.api.property.Property;

/**
 * This is the implementation of the HelloWorld
 * state interface.
 */
public class HelloWorldStateMixin
    implements HelloWorldState
{
    @PropertyField Property<String> phrase;
    @PropertyField Property<String> name;

    public Property<String> phrase()
    {
        return phrase;
    }

    public Property<String> name()
    {
        return name;
    }
}