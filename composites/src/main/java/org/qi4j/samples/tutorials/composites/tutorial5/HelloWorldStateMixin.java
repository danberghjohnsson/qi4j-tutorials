/*
 * Copyright (c) 2008, Your Corporation. All Rights Reserved.
 */

package org.qi4j.samples.tutorials.composites.tutorial5;

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

    public String getPhrase()
    {
        return phrase;
    }

    public void setPhrase( String phrase )
        throws IllegalArgumentException
    {
        if( phrase == null )
        {
            throw new IllegalArgumentException( "Phrase may not be null " );
        }

        this.phrase = phrase;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
        throws IllegalArgumentException
    {
        if( name == null )
        {
            throw new IllegalArgumentException( "Name may not be null " );
        }

        this.name = name;
    }
}
