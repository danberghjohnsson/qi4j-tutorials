package org.qi4j.samples.tutorials.composites.tutorial6;

import org.qi4j.composite.ConcernOf;

/**
 * This Concern validates the parameters
 * to the HelloWorldState interface.
 */
public class HelloWorldBehaviourConcern extends ConcernOf<HelloWorldBehaviour>
    implements HelloWorldBehaviour
{
    public String say()
    {
        return "Simon says:" + next.say();
    }
}
