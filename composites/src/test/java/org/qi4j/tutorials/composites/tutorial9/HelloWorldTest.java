package org.qi4j.tutorials.composites.tutorial9;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.bootstrap.ModuleAssembly;
import org.qi4j.bootstrap.SingletonAssembler;
import org.qi4j.composite.CompositeBuilderFactory;
import org.qi4j.composite.CompositeBuilder;

public class HelloWorldTest
{
    HelloWorldComposite helloWorld;

    @Before
    public void setUp() throws Exception
    {
        SingletonAssembler assembly = new SingletonAssembler()
        {
            public void assemble( ModuleAssembly module ) throws AssemblyException
            {
                module.addComposites( HelloWorldComposite.class );
            }
        };
        CompositeBuilderFactory builderFactory = assembly.compositeBuilderFactory();
        CompositeBuilder<HelloWorldComposite> builder = builderFactory.newCompositeBuilder( HelloWorldComposite.class );
        builder.stateOfComposite().name().set( "" );
        builder.stateOfComposite().phrase().set( "" );
        helloWorld = builder.newInstance();
    }

    @Test
    public void givenHelloWorldWhenSetPropertiesAndSayThenReturnCorrectResult()
    {
        {
            helloWorld.phrase().set( "Hello" );
            helloWorld.name().set( "World" );
            String result = helloWorld.say();
            assertThat( result, equalTo( "Hello World" ) );
        }

        {
            helloWorld.phrase().set( "Hey" );
            helloWorld.name().set( "Universe" );
            String result = helloWorld.say();
            assertThat( result, equalTo( "Hey Universe" ) );
        }
    }

    @Test
    public void givenHelloWorldWhenSetInvalidPhraseThenThrowException()
    {
        try
        {
            helloWorld.phrase().set( null );
            fail( "Should not be allowed to set phrase to null" );
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
            helloWorld.name().set( null );
            fail( "Should not be allowed to set name to null" );
        }
        catch( IllegalArgumentException e )
        {
            // Ok
        }
    }
}
