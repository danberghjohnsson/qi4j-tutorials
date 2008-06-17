/*
 * Copyright (c) 2008, Rickard Öberg. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.qi4j.tutorials.recipe.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import org.qi4j.bootstrap.ApplicationFactory;
import org.qi4j.bootstrap.Assembler;
import org.qi4j.bootstrap.LayerName;
import org.qi4j.bootstrap.ModuleName;
import org.qi4j.injection.scope.Service;
import org.qi4j.library.rdf.RdfFactory;
import org.qi4j.library.rdf.RdfFormat;
import org.qi4j.object.ObjectBuilderFactory;
import org.qi4j.runtime.structure.ApplicationModel;
import org.qi4j.tutorials.recipe.assembly.DomainAssembler;
import org.qi4j.tutorials.recipe.assembly.InfrastructureAssembler;
import org.qi4j.tutorials.recipe.assembly.ViewAssembler;
import org.qi4j.structure.Application;

/**
 * TODO
 */
public class Main
{
    @Service Frame frame;

    public static void main( String[] args )
        throws Exception
    {
        new Main();
    }

    public Main()
        throws Exception
    {
        final Application application = new ApplicationFactory().newApplication( new Assembler[][][]
            {
                {
                    {
                        new LayerName( "View" ), new ModuleName( "Frame" ),
                        new ViewAssembler(),
                        new DomainAssembler(),
                        new InfrastructureAssembler()
                    }
                }
            } );

        application.activate();

        ObjectBuilderFactory obf = application.findModule( "View", "Frame" ).objectBuilderFactory();
        obf.newObjectBuilder( Main.class ).injectTo( this );

        frame.getFrame().addWindowListener( new WindowAdapter()
        {

            @Override public void windowClosing( WindowEvent windowEvent )
            {
                try
                {
                    application.passivate();
                }
                catch( Exception e )
                {
                    e.printStackTrace();
                }
            }
        } );

//        outputMetadata( application );
    }

    public void outputMetadata( ApplicationModel binding )
        throws Exception
    {
        RdfFactory.getInstance().serialize( binding, "urn:qi4j:sample/tutorials/recipe", RdfFormat.rdfxml, new PrintWriter( System.out ) );
    }
}
