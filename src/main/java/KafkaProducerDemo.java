import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "3");
        properties.setProperty("linger.ms", "1");

        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);


        sendMessagesToProducer(producer);

        producer.close();
    }

    private static void sendMessagesToProducer(Producer<String, String> producer) {
        for (int key = 0; key < 10; key ++) {
            ProducerRecord<String, String> producerRecord =
                    new ProducerRecord<String, String>("my_topic", Integer.toString(key), "message with key " + Integer.toString(key));

            producer.send(producerRecord);
        }
    }
}