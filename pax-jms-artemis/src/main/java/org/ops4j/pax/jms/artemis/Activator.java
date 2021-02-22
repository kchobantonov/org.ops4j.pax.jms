/*
 * Copyright 2021 OPS4J.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.jms.artemis;

import org.ops4j.pax.jms.service.ConnectionFactoryFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

/**
 * Created by gnodet on 19/07/2017.
 */
public class Activator implements BundleActivator {

    ServiceRegistration<ConnectionFactoryFactory> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        Hashtable<String, Object> props = new Hashtable<>();
        props.put(ConnectionFactoryFactory.JMS_CONNECTIONFACTORY_TYPE, "artemis");
        registration = context.registerService(ConnectionFactoryFactory.class,
                new ArtemisConnectionFactoryFactory(),
                props);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        registration.unregister();
    }

}
