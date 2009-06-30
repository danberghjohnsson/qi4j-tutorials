package org.qi4j.demo.twominute;

import org.qi4j.api.mixin.Mixins;
import org.qi4j.api.composite.Composite;
import org.qi4j.api.composite.TransientComposite;

@Mixins( SpeakerMixin.class )
public interface PoliticianComposite 
    extends TransientComposite, Speaker // +others
{
}
