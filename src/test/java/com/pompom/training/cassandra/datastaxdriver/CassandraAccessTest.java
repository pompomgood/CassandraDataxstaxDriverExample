package com.pompom.training.cassandra.datastaxdriver;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraAccessTest {

	Session cassandraSession;
	
	@Before
	public void setup() {
		String cassandraServerIP = "192.168.1.83";
		Cluster cluster = Cluster.builder().addContactPoint(cassandraServerIP).build();
		this.cassandraSession = cluster.connect();
		this.cassandraSession.execute("TRUNCATE cassandra_example.sample_user");
	}
	
	@After
	public void closeSession(){
		this.cassandraSession.execute("TRUNCATE cassandra_example.sample_user");
		this.cassandraSession.close();
	}

	@Test
	public void accessByMapper() {
		SampleUser user = new SampleUser();
		user.setGroup("group1");
		user.setName("pompom");
		Set<String> habits = new HashSet<String>();
		habits.add("game");
		habits.add("TV");
		user.setHabits(habits);
		
		SamplerUserDAOwithMapper userDAO = new SamplerUserDAOwithMapper(this.cassandraSession);
		System.out.println("Add user");
		userDAO.add(user);
		findUser();
		
		System.out.println("Delete user");
		userDAO.delete(user);
		findUser();
	}
	
	public void findUser(){
		String searchUserCQL = "select * FROM cassandra_example.sample_user WHERE group = 'group1' AND name = 'pompom'";
		ResultSet findResult = this.cassandraSession.execute(searchUserCQL);
		List<Row> rows = findResult.all();
		System.out.println("CQL: "+searchUserCQL);
		System.out.println("Result size: "+ rows.size());
	}
	
	

}
