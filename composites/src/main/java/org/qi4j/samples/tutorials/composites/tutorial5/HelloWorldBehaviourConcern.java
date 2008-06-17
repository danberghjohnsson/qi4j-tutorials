/*
 * Copyright (c) 2008, Your Corporation. All Rights Reserved.
 */

package org.qi4j.samples.tutorials.composites.tutorial5;

import org.qi4j.composite.ConcernOf;

/**
 * This is a concern that modifies the mixin behaviour.
 */
public class HelloWorldBehaviourConcern extends ConcernOf<HelloWorldBehaviour>
    implements HelloWorldBehaviour
{
    public String say()
    {
        return "Simon says:" + next.say();
    }
}
