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
                assembly.addComposites( CitizenComposite.class );
            }
        };
        CompositeBuilderFactory factory =
            assembler.getCompositeBuilderFactory();
        CitizenComposite citizen = factory.newComposite( CitizenComposite.class );
        System.out.println( citizen.sayHello() );
    }
}