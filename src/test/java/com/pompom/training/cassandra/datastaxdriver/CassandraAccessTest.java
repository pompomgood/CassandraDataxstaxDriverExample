package com.pompom.training.cassandra.datastaxdriver;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraAccessTest {

	Session cassandraSession;
	
	@Before
	public void getSession() {
		String cassandraServerIP = "192.168.1.83";
		Cluster cluster = Cluster.builder().addContactPoint(cassandraServerIP).build();
		this.cassandraSession = cluster.connect();
	}
	
	@After
	public void closeSession(){
		this.cassandraSession.close();
	}

	@Test
	public void addByMapper() {
		SampleUser user = new SampleUser();
		user.setGroup("group1");
		user.setName("pompom");
		Set<String> habits = new HashSet<String>();
		habits.add("game");
		habits.add("TV");
		user.setHabits(habits);
		SamplerUserDAOwithMapper userDAO = new SamplerUserDAOwithMapper(this.cassandraSession);
		userDAO.add(user);
	}

}
