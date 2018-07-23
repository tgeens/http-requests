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

import com.budjb.httprequests.converter.EntityWriter;
import groovy.json.JsonBuilder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class JsonEntityWriter implements EntityWriter {
    /**
     * {@inheritDoc}
     */
    @Override
    public String getContentType() {
        return "application/json";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(Class<?> type) {
        return List.class.isAssignableFrom(type) || Map.class.isAssignableFrom(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputStream write(Object entity, String characterSet) throws Exception {
        if (characterSet == null) {
            characterSet = Charset.defaultCharset().toString();
        }
        return new ByteArrayInputStream(new JsonBuilder(entity).toString().getBytes(characterSet));
    }
}
