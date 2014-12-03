package com.pompom.training.cassandra.datastaxdriver;

import java.util.Set;

import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "cassandra_example", name = "sample_user")
public class SampleUser {
	private String group;
	private String name;
	private Set<String> habit;
}
