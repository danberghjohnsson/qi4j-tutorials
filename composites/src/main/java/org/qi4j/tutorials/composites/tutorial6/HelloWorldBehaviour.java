package org.qi4j.tutorials.composites.tutorial6;

import org.qi4j.api.concern.Concerns;
import org.qi4j.api.mixin.Mixins;

/**
 * This interface contains only the behaviour
 * of the HelloWorld object.
 * <p/>
 * It declares what Mixin to use as default implementation.
 */
@Concerns( HelloWorldBehaviourConcern.class )
@Mixins( HelloWorldBehaviourMixin.class )
public interface HelloWorldBehaviour
{
    String say();
}
