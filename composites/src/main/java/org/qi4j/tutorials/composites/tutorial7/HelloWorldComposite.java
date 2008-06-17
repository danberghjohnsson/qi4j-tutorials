package org.qi4j.tutorials.composites.tutorial7;

import org.qi4j.composite.Composite;
import org.qi4j.composite.Mixins;
import org.qi4j.composite.SideEffects;

/**
 * This Composite interface declares transitively
 * all the Fragments of the HelloWorld composite.
 * <p/>
 * It declares that the InvocationCacheMixin might
 * be used, which then implements the @ThisAs
 * dependency by the cache invalidation side-effect.
 */
@Mixins( {HelloWorldBehaviourMixin.class, HelloWorldStateMixin.class} )
@SideEffects( HelloWorldBehaviourSideEffect.class )
public interface HelloWorldComposite
    extends HelloWorld, Composite
{
}