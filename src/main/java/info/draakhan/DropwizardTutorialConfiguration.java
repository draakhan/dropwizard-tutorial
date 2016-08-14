package info.draakhan;

import info.draakhan.core.queue.MessageQueueFactory;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DropwizardTutorialConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @Valid
    @NotNull
    private MessageQueueFactory messageQueueFactory = new MessageQueueFactory();

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    @JsonProperty("messageQueue")
    public MessageQueueFactory getMessageQueueFactory() {
        return messageQueueFactory;
    }

    @JsonProperty("messageQueue")
    public void setMessageQueueFactory(MessageQueueFactory messageQueueFactory) {
        this.messageQueueFactory = messageQueueFactory;
    }
}
