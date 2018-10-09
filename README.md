## Zookeeper
### Installing Zookeeper:

`$ wget https://archive.apache.org/dist/zookeeper/zookeeper-3.4.9/zookeeper-3.4.9.tar.gz`

`$ tar -zxf zookeeper-3.4.9.tar.gz`

`$ mv zookeeper-3.4.9 /usr/local/zookeeper`

`$ mkdir -p /var/lib/zookeeper`

`$ cat > /usr/local/zookeeper/conf/zoo.cfg`

		tickTime=2000
		dataDir=/var/lib/zookeeper
		clientPort=2181


`$ bin/zkServer.sh start`

		JMX enabled by default
		Using config: /usr/local/zookeeper/bin/../conf/zoo.cfg
		Starting zookeeper ... STARTED

### Validate Zookeeper
`$ telnet localhost 2181`

		Trying 127.0.0.1...
		Connected to localhost.
		Escape character is '^]'.
		> srvr
		Zookeeper version: 3.4.9-1757313, built on 08/23/2016 06:50 GMT
		Latency min/avg/max: 0/9/197
		Received: 1013
		Sent: 1015
		Connections: 2
		Outstanding: 0
		Zxid: 0x90
		Mode: standalone
		Node count: 133
		Connection closed by foreign host.


## Kafka
### Installing Kafka

`$ wget http://www-us.apache.org/dist/kafka/2.0.0/kafka_2.12-2.0.0.tgz`

`$ tar -zxf kafka_2.12-2.0.0.tgz`

`$ mv kafka_2.12-2.0.0 /usr/local/kafka`

`$ mkdir /tmp/kafka-logs`

### Kafka Operation

`$ bin/kafka-server-start.sh -daemon config/server.properties`

`$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test`

`$ bin/kafka-topics.sh --describe --zookeeper localhost:2181 --topic test`

`$ bin/kafka-topics.sh --list --zookeeper localhost:2181`

`$ bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test`

		This is a message
		This is another message

`$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning`


## Run Application

### Service One Application

`$ mvn spring-boot:run`

### Service Two Application

`$ mvn spring-boot:run`

### Service Three Application

`mvn tomcat7:run`


References
https://kafka.apache.org/quickstart