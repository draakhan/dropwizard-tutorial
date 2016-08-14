package info.draakhan.core.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageQueueClient {
    private static Logger LOGGER = LoggerFactory.getLogger(MessageQueueClient.class);

    private String host;
    private int port;

    public MessageQueueClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        LOGGER.info(String.format("MessageQueueClient started (host: %s, port: %s)", host, port));
    }

    public void close() {
        LOGGER.info("MessageQueueClient closed");
    }
}
