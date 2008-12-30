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

package org.qi4j.tutorials.services.tutorial3;

import org.qi4j.api.injection.scope.Service;

/**
 * Simple service consumer. The service is injected using the @Service annotation.
 */
public class ServiceConsumer
    implements Runnable
{
    @Service SomeSimple someSimpleService;

    public void run()
    {
        someSimpleService.doService( "Hello", "World" );
    }
}