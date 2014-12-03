Cassandra Datastax driver Example
==========================
Example for connecting cassandra by datastax driver

#Environment
* Cassandra: 2.1
* JDK: 1.7

#How to run
1. Setup Cassandra
  [Installing DataStax Community](http://www.datastax.com/documentation/cassandra/2.1/cassandra/install/install_cassandraTOC.html)
2. Set Cassandra server ip
  Modify cassandraServerIP in CassandraAccessTest class
3. Clone this project
4. Run `mvn clean test`