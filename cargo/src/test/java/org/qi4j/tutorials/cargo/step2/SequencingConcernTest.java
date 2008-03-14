/*
 * Copyright 2008 Alin Dreghiciu.
 *
 * Licensed  under the  Apache License,  Version 2.0  (the "License");
 * you may not use  this file  except in  compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed  under the  License is distributed on an "AS IS" BASIS,
 * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.qi4j.tutorials.cargo.step2;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.qi4j.bootstrap.SingletonAssembler;
import org.qi4j.bootstrap.ModuleAssembly;
import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.spi.service.provider.SingletonInstanceProvider;
import org.qi4j.spi.service.provider.Singleton;
import org.qi4j.composite.Mixins;
import org.qi4j.composite.Concerns;
import org.qi4j.test.mock.MockPlayerMixin;
import org.qi4j.test.mock.MockComposite;
import org.qi4j.property.Property;
import apple.awt.ClientPropertyApplicator;

/**
 * Unit tests for SequencingConcern.
 *
 * @author Alin Dreghiciu
 */
public class SequencingConcernTest
{
    /**
     * Tests that when shipping service fails to make the booking generator is not called and booking failure code is
     * returned.
     */
    @Test
    public void failingBooking()
    {
        SingletonAssembler assembler = new SingletonAssembler()
        {
            public void assemble( ModuleAssembly module ) throws AssemblyException
            {
                module.addComposites( ShippingServiceTestComposite.class );
            }
        };
        ShippingService shippingService = createMock( ShippingService.class );
        Cargo cargo = createMock( Cargo.class );
        Voyage voyage = createMock( Voyage.class );
        expect( shippingService.makeBooking( cargo, voyage ) ).andReturn( -1000 );
        replay( shippingService, cargo, voyage );
        ShippingServiceTestComposite underTest = assembler.getCompositeBuilderFactory().newComposite( ShippingServiceTestComposite.class );
        underTest.useMock( shippingService ).forClass( ShippingService.class );
        assertThat( "Booking result", underTest.makeBooking( cargo, voyage ), is( equalTo( -1000 ) ) );
        verify( shippingService, cargo, voyage );
    }

    /**
     * Tests that when shipping service succeeds to make the booking generator gets called and generated value is
     * returned.
     */
    @Test
    public void succesfulBooking()
    {
        SingletonAssembler assembler = new SingletonAssembler()
        {
            public void assemble( ModuleAssembly module ) throws AssemblyException
            {
                module.addComposites( ShippingServiceTestComposite.class );
            }
        };
        ShippingService shippingService = createMock( ShippingService.class );
        Cargo cargo = createMock( Cargo.class );
        Voyage voyage = createMock( Voyage.class );
        Sequence generator = createMock( Sequence.class );
        Property<Integer> sequence = createMock( Property.class );
        expect( shippingService.makeBooking( cargo, voyage ) ).andReturn( 100 );
        expect( generator.sequence() ).andReturn( sequence ).anyTimes();
        expect( sequence.get() ).andReturn( 1000 );
        expect( sequence.set( 1001 ) ).andReturn( 1001 );
        replay( shippingService, cargo, voyage, generator, sequence );
        ShippingServiceTestComposite underTest = assembler.getCompositeBuilderFactory().newComposite( ShippingServiceTestComposite.class );
        underTest.useMock( shippingService ).forClass( ShippingService.class );
        underTest.useMock( generator ).forClass( Sequence.class );
        assertThat( "Booking result", underTest.makeBooking( cargo, voyage ), is( equalTo( 1000 ) ) );
        verify( shippingService, cargo, voyage, generator, sequence );
    }

    @Mixins( MockPlayerMixin.class )
    @Concerns( SequencingConcern.class )
    public static interface ShippingServiceTestComposite
        extends ShippingService, Sequence, MockComposite
    {
    }


}
