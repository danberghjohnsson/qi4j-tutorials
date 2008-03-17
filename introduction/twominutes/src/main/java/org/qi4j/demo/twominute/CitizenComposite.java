package org.qi4j.demo.twominute;

import org.qi4j.composite.Mixins;
import org.qi4j.composite.Composite;

@Mixins( SpeachMixin.class )
public interface CitizenComposite extends Composite, Speach  // ,..., other types,
{
}