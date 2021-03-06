package com.pompom.training.cassandra.datastaxdriver;

import java.util.Set;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "cassandra_example", name = "sample_user")
public class SampleUser {
	@PartitionKey(value = 0)
	private String group;
	@ClusteringColumn(value = 0)
	private String name;
	private Set<String> habits;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getHabits() {
		return habits;
	}

	public void setHabits(Set<String> habits) {
		this.habits = habits;
	}

}