package org.qi4j.tutorials.composites.tutorial10;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.bootstrap.ModuleAssembly;
import org.qi4j.bootstrap.SingletonAssembler;
import org.qi4j.api.composite.CompositeBuilder;

public class HelloWorldTest
{
    private SingletonAssembler assembly;

    @Before
    public void setUp() throws Exception
    {
        assembly = new SingletonAssembler()
        {
            public void assemble( ModuleAssembly module ) throws AssemblyException
            {
                module.addComposites( HelloWorldComposite.class );
            }
        };
    }

    @Test
    public void givenAssemblyWhenBuildInstanceAndSayThenReturnCorrectResult()
    {
        {
            CompositeBuilder<HelloWorldComposite> builder = assembly.compositeBuilderFactory().newCompositeBuilder( HelloWorldComposite.class );
            builder.stateFor( HelloWorldState.class ).phrase().set( "Hello" );
            builder.stateFor( HelloWorldState.class ).name().set( "World" );
            HelloWorldComposite helloWorld = builder.newInstance();
            String result = helloWorld.say();
            assertThat( result, equalTo( "Hello World" ) );
        }

        {
            CompositeBuilder<HelloWorldComposite> builder = assembly.compositeBuilderFactory().newCompositeBuilder( HelloWorldComposite.class );
            builder.stateFor( HelloWorldState.class ).phrase().set( "Hey" );
            builder.stateFor( HelloWorldState.class ).name().set( "Universe" );
            HelloWorldComposite helloWorld = builder.newInstance();
            String result = helloWorld.say();
            assertThat( result, equalTo( "Hey Universe" ) );
        }
    }

    @Test
    public void givenAssemblyWhenSetInvalidPhraseThenThrowException()
    {
        try
        {
            CompositeBuilder<HelloWorldComposite> builder = assembly.compositeBuilderFactory().newCompositeBuilder( HelloWorldComposite.class );
            builder.stateFor( HelloWorldState.class ).phrase().set( null );
            HelloWorldComposite helloWorld = builder.newInstance();

            fail( "Should not be allowed to set phrase to null" );
        }
        catch( IllegalArgumentException e )
        {
            // Ok
        }
    }

    @Test
    public void givenAssemblyWhenSetInvalidNameThenThrowException()
    {
        try
        {
            CompositeBuilder<HelloWorldComposite> builder = assembly.compositeBuilderFactory().newCompositeBuilder( HelloWorldComposite.class );
            builder.stateFor( HelloWorldState.class ).name().set( null );
            HelloWorldComposite helloWorld = builder.newInstance();

            fail( "Should not be allowed to set phrase to null" );
        }
        catch( IllegalArgumentException e )
        {
            // Ok
        }
    }
}