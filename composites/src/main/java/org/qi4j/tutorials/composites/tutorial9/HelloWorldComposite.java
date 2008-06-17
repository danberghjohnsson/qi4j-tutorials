package org.qi4j.tutorials.composites.tutorial9;

import org.qi4j.composite.Mixins;
import org.qi4j.composite.Composite;

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
