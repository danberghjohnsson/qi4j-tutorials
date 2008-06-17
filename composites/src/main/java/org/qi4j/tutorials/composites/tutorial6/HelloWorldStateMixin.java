/*
 * Copyright (c) 2008, Your Corporation. All Rights Reserved.
 */

package org.qi4j.tutorials.composites.tutorial6;

/**
 * This is the implementation of the HelloWorld
 * state interface. The parameter validation is still
 * mixed with the state management.
 */
public class HelloWorldStateMixin
    implements HelloWorldState
{
    String phrase;
    String name;

    public String say()
    {
        return phrase + " " + name;
    }

    public String getPhrase()
    {
        return phrase;
    }

    public void setPhrase( String phrase )
    {
        this.phrase = phrase;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }
}