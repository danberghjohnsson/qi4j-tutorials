package org.qi4j.demo.twominute;

import org.qi4j.composite.Mixins;
import org.qi4j.composite.Composite;

@Mixins( SpeakerMixin.class )
public interface PoliticianComposite extends Composite, Speaker  // +others
{
}