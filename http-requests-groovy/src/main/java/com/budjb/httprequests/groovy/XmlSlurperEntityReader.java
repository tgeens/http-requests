/*
 * Copyright 2016-2018 the original author or authors.
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

package com.budjb.httprequests.groovy;

import com.budjb.httprequests.converter.EntityReader;
import groovy.util.XmlSlurper;
import groovy.util.slurpersupport.GPathResult;

import java.io.InputStream;

public class XmlSlurperEntityReader implements EntityReader {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(Class<?> type) {
        return GPathResult.class.isAssignableFrom(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object read(InputStream entity, String contentType, String charset) throws Exception {
        return new XmlSlurper(false, false).parse(entity);
    }
}
