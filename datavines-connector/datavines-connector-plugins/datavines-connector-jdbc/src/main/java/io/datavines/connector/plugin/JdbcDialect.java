/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.datavines.connector.plugin;

import io.datavines.connector.api.Dialect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.datavines.common.ConfigConstants.*;

public abstract class JdbcDialect implements Dialect {

    protected final HashMap<String,String> dialectKeyMap = new HashMap<>();

    @Override
    public Map<String, String> getDialectKeyMap() {
        dialectKeyMap.put(REGEX_KEY, "${column} regexp '${regexp}'");
        dialectKeyMap.put(NOT_REGEX_KEY, "${column} not regexp '${regexp}'");
        dialectKeyMap.put(STRING_TYPE, "varchar");
        return dialectKeyMap;
    }

    @Override
    public String getColumnPrefix() {
        return "`";
    }

    @Override
    public String getColumnSuffix() {
        return "`";
    }

    @Override
    public List<String> getExcludeDatabases() {
        return Arrays.asList("sys", "information_schema", "performance_schema", "mysql");
    }

}
