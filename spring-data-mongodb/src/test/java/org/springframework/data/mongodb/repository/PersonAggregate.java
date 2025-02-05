/*
 * Copyright 2019-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.mongodb.repository;

import lombok.Value;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 * @author Christoph Strobl
 * @author Mark Paluch
 */
@Value
class PersonAggregate {

	@Id private String lastname;
	private Set<String> names;

	@PersistenceConstructor
	public PersonAggregate(String lastname, Collection<String> names) {
		this.lastname = lastname;
		this.names = new HashSet<>(names);
	}

	public PersonAggregate(String lastname, String name) {
		this(lastname, Collections.singletonList(name));
	}
}
