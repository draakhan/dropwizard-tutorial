package info.draakhan.health;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
    private final static String TEMPLATE_TEST_NAME = "TEST";

    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, TEMPLATE_TEST_NAME);

        if (!saying.contains(TEMPLATE_TEST_NAME)) {
            return Result.unhealthy("Template doesn't include a name");
        }

        return Result.healthy();
    }
}
