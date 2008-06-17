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

package org.qi4j.samples.tutorials.recipe.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.qi4j.entity.UnitOfWork;
import org.qi4j.entity.UnitOfWorkFactory;
import org.qi4j.injection.scope.Service;
import org.qi4j.injection.scope.Structure;
import org.qi4j.samples.tutorials.recipe.domain.CategoryEntity;
import org.qi4j.service.Activatable;

/**
 * TODO
 */
public class FrameMixin
    implements Frame, Activatable
{
    private JFrame frame;

    private @Service Iterable<FramePlugin> framePlugins;
    private @Structure UnitOfWorkFactory esf;

    public JFrame getFrame()
    {
        return frame;
    }

    public void activate() throws Exception
    {
        frame = new JFrame();

        UnitOfWork unitOfWork = esf.newUnitOfWork();

        createDummyData( unitOfWork );

        Container container = frame.getContentPane();
        container.setLayout( new GridLayout( 0, 1 ) );
        container.add( new JLabel( "Application" ) );

        for( FramePlugin framePlugin : framePlugins )
        {
            container.add( framePlugin.activate( unitOfWork ) );
        }

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        frame.pack();

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation( (int) screensize.getWidth() / 2 - frame.getWidth() / 2, (int) screensize.getHeight() / 2 - frame.getHeight() / 2 );

        frame.setVisible( true );
    }

    private void createDummyData( UnitOfWork unitOfWork )
    {
        // Create dummy data
        unitOfWork.newEntityBuilder( CategoryEntity.class ).newInstance().name().set( "CategoryEntity 1" );
        unitOfWork.newEntityBuilder( CategoryEntity.class ).newInstance().name().set( "CategoryEntity 2" );
        unitOfWork.newEntityBuilder( CategoryEntity.class ).newInstance().name().set( "CategoryEntity 3" );
    }

    public void passivate() throws Exception
    {
    }
}
