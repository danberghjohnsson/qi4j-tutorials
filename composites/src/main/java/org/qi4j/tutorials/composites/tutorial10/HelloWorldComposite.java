package org.qi4j.tutorials.composites.tutorial10;

import org.qi4j.composite.Mixins;
import org.qi4j.composite.Composite;

/**
 * This Composite interface declares transitively
 * all the Fragments of the HelloWorld composite.
 * <p/>
 * All standard declarations have been moved to
 * the StandardAbstractEntityComposite so we don't have to repeat
 * them in all Composites.
 * <p/>
 * The Fragments are all abstract, so it's ok to
 * put the domain methods here. Otherwise the Fragements
 * would have to implement all methods, including those in Composite.
 */
@Mixins( { HelloWorldMixin.class } )
public interface HelloWorldComposite
    extends Composite
{
    String say();
}
