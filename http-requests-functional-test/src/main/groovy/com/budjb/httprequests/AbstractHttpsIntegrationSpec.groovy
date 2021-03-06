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
package com.budjb.httprequests

import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Ignore

@Ignore
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = [
    'server.ssl.key-store = classpath:keystore.jks',
    'server.ssl.key-password = password'
])
abstract class AbstractHttpsIntegrationSpec extends AbstractIntegrationSpec {
    /**
     * Return the base URL of the running server.
     *
     * @return
     */
    @Override
    String getBaseUrl() {
        return "https://localhost:${webPort}"
    }
}
