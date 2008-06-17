package org.qi4j.samples.tutorials.composites.tutorial9;

import org.qi4j.injection.scope.This;

/**
 * This is the implementation of the HelloWorld
 * behaviour interface.
 * <p/>
 * The result of the say() method is cached so that subsequent
 * invocations return the same value without performing the
 * actual computation.
 */
public class HelloWorldBehaviourMixin
    implements HelloWorldBehaviour
{
    @This HelloWorldState state;

    public String say()
    {
        return state.phrase().get() + " " + state.name().get();
    }
}
