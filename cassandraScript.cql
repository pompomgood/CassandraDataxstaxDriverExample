CREATE KEYSPACE cassandra_example WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE cassandra_example.sample_user (
    group text,
    name text,
    habits set<text>,
    PRIMARY KEY ((group), name)
);