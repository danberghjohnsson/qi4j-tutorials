package org.qi4j.demo.twominute;

import org.qi4j.api.mixin.Mixins;
import org.qi4j.api.composite.Composite;

@Mixins( SpeakerMixin.class )
public interface PoliticianComposite extends Composite, Speaker  // +others
{
}