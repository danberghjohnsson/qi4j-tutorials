package org.qi4j.demo.twominute;

import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.bootstrap.ModuleAssembly;
import org.qi4j.bootstrap.SingletonAssembler;
import org.qi4j.composite.CompositeBuilderFactory;

public class Main
{
    public static void main( String[] args )
    {
        SingletonAssembler assembler = new SingletonAssembler()
        {
            public void assemble( ModuleAssembly assembly )
                throws AssemblyException
            {
                assembly.addComposites( PoliticianComposite.class );
            }
        };
        CompositeBuilderFactory factory =
            assembler.compositeBuilderFactory();
        Speaker speaker =
            factory.newComposite( PoliticianComposite.class );
        System.out.println( speaker.sayHello() );
    }
}