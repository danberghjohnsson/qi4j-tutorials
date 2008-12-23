package org.qi4j.tutorials.composites.tutorial8;

import org.qi4j.api.composite.Composite;
import org.qi4j.api.mixin.Mixins;

/**
 * This Composite interface declares transitively
 * all the Fragments of the HelloWorld composite.
 */
@Mixins( { HelloWorldBehaviourMixin.class, HelloWorldStateMixin.class } )
public interface HelloWorldComposite
    extends HelloWorldBehaviour, HelloWorldState, Composite
{
}
