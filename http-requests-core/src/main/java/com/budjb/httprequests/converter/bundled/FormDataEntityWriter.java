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
package com.budjb.httprequests.converter.bundled;

import com.budjb.httprequests.FormData;
import com.budjb.httprequests.converter.EntityWriter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * An entity writer that formats form data.
 */
public class FormDataEntityWriter implements EntityWriter {
    /**
     * Returns a Content-Type of the converted object that will be set in the HTTP request.
     * <p>
     * If no Content-Type is known, null is returned.
     *
     * @return Content-Type of the converted object, or null if unknown.
     */
    @Override
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    /**
     * Determines whether the given class type is supported by the writer.
     *
     * @param type Type to convert.
     * @return Whether the type is supported.
     */
    @Override
    public boolean supports(Class<?> type) {
        return FormData.class.isAssignableFrom(type);
    }

    /**
     * Convert the given entity.
     * <p>
     * If an error occurs, null may be returned so that another converter may attempt conversion.
     *
     * @param entity       Entity as an {@link InputStream}.
     * @param characterSet The character set of the request.
     * @return The converted object, or null if an error occurs.
     * @throws Exception when an unexpected error occurs.
     */
    @Override
    public InputStream write(Object entity, String characterSet) throws Exception {
        if (characterSet == null) {
            characterSet = Charset.defaultCharset().name();
        }

        List<String> parts = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : ((FormData) entity).getFields().entrySet()) {
            String k = URLEncoder.encode(entry.getKey(), characterSet);

            for (String value : entry.getValue()) {
                parts.add(k + "=" + URLEncoder.encode(value, characterSet));
            }
        }

        return new ByteArrayInputStream(String.join("&", parts).getBytes(characterSet));
    }
}
