CREATE KEYSPACE cassandra_example
	WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };