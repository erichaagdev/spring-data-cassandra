/*
 * Copyright 2013-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.cassandra.core.mapping;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Identifies a secondary index in the table on a single column.
 * <p>
 * The following columns of a {@link Table} type can be annotated with {@link Indexed}:
 * <ul>
 * <li>Scalar data types</li>
 * <li>User-defined types</li>
 * <li>Collection types</li>
 * <li>Map type</li>
 * </ul>
 * <p>
 * Map types distinguish allows entry, key or value-level indexing with the restriction that only a single secondary
 * index is allowed.
 *
 * <pre class="code">
 * &#64;Table
 * class Person {
 *
 * 	Map&lt;@Indexed String, String&gt; indexedKey; // allows CONTAINS KEY queries
 * 	Map&lt;String, @Indexed String&gt; indexedValue; // allows CONTAINS queries
 * }
 * </pre>
 *
 * @author Alex Shvid
 * @author Matthew T. Adams
 * @author Mark Paluch
 * @see Table
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE })
public @interface Indexed {

	/**
	 * The name of the index. If {@literal null} or empty, then the index name will be generated by Cassandra and will be
	 * unknown unless column metadata is used to discover the generated index name.
	 */
	String value() default "";
}
