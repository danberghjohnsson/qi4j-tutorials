package org.qi4j.samples.tutorials.composites.tutorial3;

import org.qi4j.composite.Composite;
import org.qi4j.composite.Mixins;

/**
 * This Composite interface declares all the Fragments
 * of the HelloWorld composite.
 * <p/>
 * Currently it only declares one Mixin.
 */
@Mixins( HelloWorldMixin.class )
public interface HelloWorldComposite
    extends HelloWorld, Composite
{
}
