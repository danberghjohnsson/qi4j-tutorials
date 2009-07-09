package org.qi4j.tutorials.services.step3;

import org.qi4j.api.service.ServiceComposite;
import org.qi4j.api.mixin.Mixins;


@Mixins( LibraryMixin.class )
public interface LibraryService extends Library, ServiceComposite
{
}