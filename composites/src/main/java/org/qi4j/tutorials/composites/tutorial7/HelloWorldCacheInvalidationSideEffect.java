package org.qi4j.tutorials.composites.tutorial7;

import org.qi4j.composite.SideEffectOf;
import org.qi4j.injection.scope.This;
import org.qi4j.library.cache.InvocationCache;

/**
 * When the properties are updated, clear the cache which
 * is used by the say() method.
 */
public class HelloWorldCacheInvalidationSideEffect extends SideEffectOf<HelloWorldState>
    implements HelloWorldState
{
    @This InvocationCache cache;

    public void setPhrase( String phrase ) throws IllegalArgumentException
    {
        cache.clearCachedValues();
        // No need to call next since this is a side-effect. The call has already been performed.
    }

    public String getPhrase()
    {
        return null;
    }

    public void setName( String name ) throws IllegalArgumentException
    {
        cache.clearCachedValues();
    }

    public String getName()
    {
        return null;
    }
}
