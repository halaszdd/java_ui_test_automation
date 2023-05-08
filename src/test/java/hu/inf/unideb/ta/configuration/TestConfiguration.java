package hu.inf.unideb.ta.configuration;

import hu.inf.unideb.ta.factory.WebDriverFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("hu.inf.unideb.ta")
public class TestConfiguration {

    @Bean(destroyMethod = "tearDown")
    public WebDriverFactory webDriverFactory() {
        return new WebDriverFactory();
    }
}
