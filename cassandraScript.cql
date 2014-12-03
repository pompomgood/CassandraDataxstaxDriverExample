CREATE KEYSPACE cassandra_example
	WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };

CREATE TABLE cassandra_example.sample_user (
    group text,
    name text,
    habits set<text>,
    PRIMARY KEY ((text), name)
);