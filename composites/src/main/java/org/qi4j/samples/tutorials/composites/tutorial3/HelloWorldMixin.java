package org.qi4j.samples.tutorials.composites.tutorial3;

/**
 * This is the implementation of the HelloWorld
 * interface. The behaviour and state is mixed.
 */
public class HelloWorldMixin
    implements HelloWorld
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
