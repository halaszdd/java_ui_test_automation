package hu.inf.unideb.ta.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfiguration.class)
public class CucumberContextConfig {
}
