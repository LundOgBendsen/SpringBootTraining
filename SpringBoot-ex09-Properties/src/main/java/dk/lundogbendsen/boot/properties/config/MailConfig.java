package dk.lundogbendsen.boot.properties.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix="config")
public class MailConfig {
    private int retryAttempts = 3; //will be overridden
    private String smtpServer = "smtp.google.com (MailConfig)"; //will be overridden
    private Template template = new Template();

    public int getRetryAttempts() {
        System.out.println("getretries");
        return retryAttempts;
    }

    public void setRetryAttempts(int retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public void setSmtpServer(String smtpServer) {
        this.smtpServer = smtpServer;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    private static class Template {
        private String subject = "News!";
        private String from = "team@acme.com";
        private List<String> languages = Arrays.asList("da", "en");

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public List<String> getLanguages() {
            return languages;
        }

        public void setLanguages(List<String> languages) {
            this.languages = languages;
        }
    }

}
