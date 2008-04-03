/*
 * Copyright 2006 Niclas Hedhman.
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

import static org.junit.Assert.*;
import org.junit.Test;
import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.bootstrap.ModuleAssembly;
import org.qi4j.composite.CompositeBuilder;
import org.qi4j.test.AbstractQi4jTest;

public class Step2TestCase
    extends AbstractQi4jTest
{
    private Voyage voyage;
    private ShippingService shippingService;

    @Override public void setUp() throws Exception
    {
        super.setUp();
        CompositeBuilder<VoyageComposite> voyageBuilder = compositeBuilderFactory.newCompositeBuilder( VoyageComposite.class );
        voyageBuilder.stateFor( Voyage.class ).bookedCargoSize().set( 0.0 );
        voyageBuilder.stateFor( Voyage.class ).capacity().set( 100.0 );
        voyage = voyageBuilder.newInstance();

        CompositeBuilder<ShippingServiceComposite> shippingBuilder = compositeBuilderFactory.newCompositeBuilder( ShippingServiceComposite.class );
        shippingService = shippingBuilder.newInstance();
    }

    @Test
    public void testOrdinaryBooking()
    {
        Cargo cargo1 = newCargo( 40 );
        Cargo cargo2 = newCargo( 40 );
        Cargo cargo3 = newCargo( 20 );
        int code = shippingService.makeBooking( cargo1, voyage );
        assertEquals( 1, code );
        code = shippingService.makeBooking( cargo2, voyage );
        assertEquals( 2, code );
        code = shippingService.makeBooking( cargo3, voyage );
        assertEquals( 3, code );
    }

    @Test
    public void testOverbooking()
    {
        Cargo cargo1 = newCargo( 100 );
        Cargo cargo2 = newCargo( 9 );
        int code = shippingService.makeBooking( cargo1, voyage );
        assertEquals( 1, code );
        code = shippingService.makeBooking( cargo2, voyage );
        assertEquals( 2, code );
    }

    @Test
    public void testTooMuch()
    {
        Cargo cargo1 = newCargo( 40 );
        Cargo cargo2 = newCargo( 40 );
        Cargo cargo3 = newCargo( 31 );
        int code = shippingService.makeBooking( cargo1, voyage );
        assertEquals( 1, code );
        code = shippingService.makeBooking( cargo2, voyage );
        assertEquals( 2, code );
        code = shippingService.makeBooking( cargo3, voyage );
        assertEquals( -1, code );
    }

    public void assemble( ModuleAssembly module )
        throws AssemblyException
    {
        module.addComposites( VoyageComposite.class, CargoComposite.class, ShippingServiceComposite.class );
    }

    private Cargo newCargo( double size )
    {
        CompositeBuilder<CargoComposite> builder = compositeBuilderFactory.newCompositeBuilder( CargoComposite.class );
        builder.stateFor( Cargo.class ).size().set( size );
        return builder.newInstance();
    }
}
