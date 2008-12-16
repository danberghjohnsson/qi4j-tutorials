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

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import org.qi4j.api.property.Property;

/**
 * Bind properties to Swing components. Updates the Property
 * objects when the value changes in the bound component.
 */
public class PropertyBinder
{
    public Component bind( Component component, final Property property )
    {
        if( component instanceof JTextField )
        {
            final JTextField textField = (JTextField) component;

            textField.setText( property.get().toString() );

            textField.addFocusListener( new FocusListener()
            {
                public void focusGained( FocusEvent focusEvent )
                {
                }

                public void focusLost( FocusEvent focusEvent )
                {
                    property.set( textField.getText() );
                }
            } );
        }

        return component;
    }
}
