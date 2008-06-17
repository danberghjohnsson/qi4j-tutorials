package org.qi4j.samples.tutorials.composites.tutorial7;

import org.qi4j.composite.SideEffectOf;

/**
 * When the properties are updated, clear the cache which
 * is used by the say() method.
 */
public class HelloWorldBehaviourSideEffect extends SideEffectOf<HelloWorldBehaviour>
    implements HelloWorldBehaviour
{
    public String say()
    {
        System.out.println( "Simon says:" + next.say() );
        return null;
    }
}
