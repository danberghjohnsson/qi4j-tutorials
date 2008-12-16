package org.qi4j.tutorials.composites.tutorial10;

import org.qi4j.api.injection.scope.This;

/**
 * This is the implementation of the say() method. The mixin
 * is abstract so it doesn't have to implement all methods
 * from the Composite interface.
 * <p/>
 * The result of the say() method is cached so that subsequent
 * invocations return the same value without performing the
 * actual computation.
 */
public abstract class HelloWorldMixin
    implements HelloWorldComposite
{
    @This HelloWorldState state;

    public String say()
    {
        return state.phrase().get() + " " + state.name().get();
    }
}
