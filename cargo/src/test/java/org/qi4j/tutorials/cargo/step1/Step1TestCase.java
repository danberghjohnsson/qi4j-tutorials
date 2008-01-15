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
package org.qi4j.tutorials.cargo.step1;

import junit.framework.TestCase;
import org.qi4j.tutorials.cargo.step1.internal.ShippingServiceImpl;
import org.qi4j.tutorials.cargo.step1.OverbookingPolicy;

public class Step1TestCase extends TestCase
{
    private ShippingService shippingService;
    private Voyage voyage;


    protected void setUp() throws Exception
    {
        BookingPolicy policy = new OverbookingPolicy();
        shippingService = new ShippingServiceImpl( policy );
        voyage = shippingService.findVoyage( "Singapore", "New York" );
    }

    public void testOrdinaryBooking()
    {
        Cargo cargo1 = shippingService.newCargo( 40 );
        Cargo cargo2 = shippingService.newCargo( 40 );
        Cargo cargo3 = shippingService.newCargo( 20 );
        int code = shippingService.makeBooking( cargo1, voyage );
        assertEquals( 1, code );
        code = shippingService.makeBooking( cargo2, voyage );
        assertEquals( 2, code );
        code = shippingService.makeBooking( cargo3, voyage );
        assertEquals( 3, code );
    }

    public void testOverbooking()
    {
        Cargo cargo1 = shippingService.newCargo( 100 );
        Cargo cargo2 = shippingService.newCargo( 9 );
        int code = shippingService.makeBooking( cargo1, voyage );
        assertEquals( 1, code );
        code = shippingService.makeBooking( cargo2, voyage );
        assertEquals( 2, code );
    }

    public void testTooMuch()
    {
        Cargo cargo1 = shippingService.newCargo( 40 );
        Cargo cargo2 = shippingService.newCargo( 40 );
        Cargo cargo3 = shippingService.newCargo( 31 );
        int code = shippingService.makeBooking( cargo1, voyage );
        assertEquals( 1, code );
        code = shippingService.makeBooking( cargo2, voyage );
        assertEquals( 2, code );
        code = shippingService.makeBooking( cargo3, voyage );
        assertEquals( -1, code );
    }
}
