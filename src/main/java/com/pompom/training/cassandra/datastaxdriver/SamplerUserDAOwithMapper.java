package com.pompom.training.cassandra.datastaxdriver;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

public class SamplerUserDAOwithMapper {

	Session cassandraSession;

	public SamplerUserDAOwithMapper(Session session) {
		this.cassandraSession = session;
	}

	public void add(SampleUser user) {
		Mapper<SampleUser> mapper = new MappingManager(cassandraSession)
				.mapper(SampleUser.class);
		mapper.save(user);
	}

	public void delete(SampleUser user) {
		Mapper<SampleUser> mapper = new MappingManager(cassandraSession)
				.mapper(SampleUser.class);
		mapper.delete(user);
	}

}
