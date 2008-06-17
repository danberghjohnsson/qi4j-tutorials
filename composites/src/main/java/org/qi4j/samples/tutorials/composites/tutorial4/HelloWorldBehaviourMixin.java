package org.qi4j.samples.tutorials.composites.tutorial4;

import org.qi4j.injection.scope.This;

/**
 * This is the implementation of the HelloWorld
 * behaviour interface.
 * <p/>
 * It uses a @This Dependency Injection
 * annotation to access the state of the Composite. The field
 * will be automatically injected when the Composite
 * is instantiated. Injections of resources or references
 * can be provided either to fields, constructor parameters or method parameters.
 */
public class HelloWorldBehaviourMixin
    implements HelloWorldBehaviour
{
    @This HelloWorldState state;

    public String say()
    {
        return state.getPhrase() + " " + state.getName();
    }
}
