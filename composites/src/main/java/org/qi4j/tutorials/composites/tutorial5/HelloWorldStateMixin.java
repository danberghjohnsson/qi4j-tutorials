/*
 * Copyright (c) 2008, Your Corporation. All Rights Reserved.
 */

package org.qi4j.tutorials.composites.tutorial5;

/**
 * This is the implementation of the HelloWorld
 * state interface.
 */
public class HelloWorldStateMixin
    implements HelloWorldState
{
    String phrase;
    String name;

    public String getPhrase()
    {
        return phrase;
    }

    public void setPhrase( String phrase )
        throws IllegalArgumentException
    {
        this.phrase = phrase;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
        throws IllegalArgumentException
    {
        this.name = name;
    }
}
