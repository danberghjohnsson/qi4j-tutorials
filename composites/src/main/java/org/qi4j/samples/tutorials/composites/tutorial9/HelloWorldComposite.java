package org.qi4j.samples.tutorials.composites.tutorial9;

import org.qi4j.composite.Concerns;
import org.qi4j.composite.Mixins;
import org.qi4j.composite.Composite;
import org.qi4j.library.framework.caching.InvocationCacheAbstractComposite;

/**
 * This Composite interface declares transitively
 * all the Fragments of the HelloWorld composite.
 * <p/>
 * All standard declarations have been moved to
 * the StandardAbstractEntityComposite so we don't have to repeat
 * them in all Composites.
 */
@Mixins( { HelloWorldBehaviourMixin.class, GenericPropertyMixin.class } )
public interface HelloWorldComposite
    extends HelloWorldBehaviour, HelloWorldState, Composite
{
}
