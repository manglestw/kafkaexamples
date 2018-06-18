<h2>Apache Kafka: Hands-on practice from Udemy course. </h2>



<h3>Dependencies</h3>
- Docker for Mac >= 1.12

<h3>Starting</h3>

- Start docker
`
docker run --rm -it \
           -p 2181:2181 -p 3030:3030 -p 8081:8081 \
           -p 8082:8082 -p 8083:8083 -p 9092:9092 \
           -e ADV_HOST=127.0.0.1 \
           landoop/fast-data-dev
`



- Kafka command lines tools
`
docker run --rm -it --net=host landoop/fast-data-dev bash
`

<h3> Useful commands </h3>

- Create first topic
`
kafka-topics --zookeeper 127.0.0.1:2181 --create --topic first_topic --partitions 3 --replication-factor 1
`

- List of topics
` 
kafka-topics  --zookeeper 127.0.0.1:2181 --list 
`

- Delete topic
`
kafka-topics  --zookeeper 127.0.0.1:2181 --topic second_topic --delete
`

- Describe topics

`
kafka-topics --zookeeper 127.0.0.1:2181 --describe --topic first_topic
`

- Publish messages
`
kafka-console-producer --broker-list 127.0.0.1:9092 --topic first_topic
`

- Consume messages
`
kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic
`

- Consume messages from beginning (processed already too)

`
kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --from-beginning
`

- Consume messages from beginning and specific partition

`
kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --from-beginning —partition 0
`

- Consume messages from beginning (not already processed in a group)
 
`
kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --consumer-property group.id=mygroup1 --from-beginning
`