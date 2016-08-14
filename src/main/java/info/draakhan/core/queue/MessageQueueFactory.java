package info.draakhan.core.queue;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.lifecycle.Managed;
import io.dropwizard.setup.Environment;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class MessageQueueFactory {
    private static final int MIN_TCP_PORT = 1;
    private static final int MAX_TCP_PORT = 65535;

    @NotEmpty
    private String host;

    @Min(MIN_TCP_PORT)
    @Max(MAX_TCP_PORT)
    private int port = 5672;

    @JsonProperty
    public String getHost() {
        return host;
    }

    @JsonProperty
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty
    public int getPort() {
        return port;
    }

    @JsonProperty
    public void setPort(int port) {
        this.port = port;
    }

    public MessageQueueClient build(Environment environment) {
        MessageQueueClient messageQueueClient = new MessageQueueClient(getHost(), getPort());
        environment.lifecycle().manage(new Managed() {
            @Override
            public void start() throws Exception {
                messageQueueClient.start();
            }

            @Override
            public void stop() throws Exception {
                messageQueueClient.close();
            }
        });

        return messageQueueClient;
    }
}
