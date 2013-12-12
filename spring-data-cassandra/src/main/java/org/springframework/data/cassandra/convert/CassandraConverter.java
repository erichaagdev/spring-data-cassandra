/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.cassandra.convert;

import org.springframework.cassandra.core.keyspace.CreateTableSpecification;
import org.springframework.data.cassandra.mapping.CassandraPersistentEntity;
import org.springframework.data.cassandra.mapping.CassandraPersistentProperty;
import org.springframework.data.convert.EntityConverter;

/**
 * Central Cassandra specific converter interface from Object to Row.
 * 
 * @author Alex Shvid
 */
public interface CassandraConverter extends
		EntityConverter<CassandraPersistentEntity<?>, CassandraPersistentProperty, Object, Object> {

	// TODO: move this method to a more appropriate location
	CreateTableSpecification getCreateTableSpecification(CassandraPersistentEntity<?> entity);
}