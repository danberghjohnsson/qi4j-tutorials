package org.qi4j.tutorials.composites.tutorial6;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.bootstrap.ModuleAssembly;
import org.qi4j.bootstrap.SingletonAssembler;

public class HelloWorldTest
{
    HelloWorld helloWorld;

    @Before
    public void setUp() throws Exception
    {
        SingletonAssembler assembly = new SingletonAssembler()
        {
            public void assemble( ModuleAssembly module ) throws AssemblyException
            {
                module.addTransients( HelloWorldComposite.class );
            }
        };
        helloWorld = assembly.transientBuilderFactory().newTransientBuilder( HelloWorldComposite.class ).newInstance();
    }

    @Test
    public void givenHelloWorldWhenSetPropertiesAndSayThenReturnCorrectResult()
    {
        {
            helloWorld.setPhrase( "Hello" );
            helloWorld.setName( "World" );
            String result = helloWorld.say();
            assertThat( result, equalTo( "Simon says:Hello World" ) );
        }

        {
            helloWorld.setPhrase( "Hey" );
            helloWorld.setName( "Universe" );
            String result = helloWorld.say();
            assertThat( result, equalTo( "Simon says:Hey Universe" ) );
        }
    }

    @Test
    public void givenHelloWorldWhenSetInvalidPhraseThenThrowException()
    {
        try
        {
            helloWorld.setPhrase( null );
            fail( "Should not be allowed to set phrase to null" );
        }
        catch( IllegalArgumentException e )
        {
            // Ok
        }

        try
        {
            helloWorld.setPhrase( "" );
            fail( "Should not be allowed to set phrase to empty string" );
        }
        catch( IllegalArgumentException e )
        {
            // Ok
        }
    }

    @Test
    public void givenHelloWorldWhenSetInvalidNameThenThrowException()
    {
        try
        {
            helloWorld.setName( null );
            fail( "Should not be allowed to set name to null" );
        }
        catch( IllegalArgumentException e )
        {
            // Ok
        }

        try
        {
            helloWorld.setName( "" );
            fail( "Should not be allowed to set name to empty string" );
        }
        catch( IllegalArgumentException e )
        {
            // Ok
        }
    }
}
