package org.qi4j.samples.tutorials.composites.tutorial7;

import org.qi4j.composite.Mixins;

/**
 * This interface contains only the behaviour
 * of the HelloWorld object.
 * <p/>
 * It declares what Mixin to use as default implementation.
 */
public interface HelloWorldBehaviour
{
    String say();
}
