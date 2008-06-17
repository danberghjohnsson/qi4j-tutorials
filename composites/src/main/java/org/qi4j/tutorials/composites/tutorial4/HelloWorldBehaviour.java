package org.qi4j.tutorials.composites.tutorial4;

import org.qi4j.composite.Mixins;

/**
 * This interface contains only the behaviour
 * of the HelloWorld object.
 */
@Mixins( HelloWorldBehaviourMixin.class )
public interface HelloWorldBehaviour
{
    String say();
}
