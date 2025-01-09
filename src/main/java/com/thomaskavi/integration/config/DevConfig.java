package com.thomaskavi.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.thomaskavi.integration.services.EmailService;
import com.thomaskavi.integration.services.SendGridEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

  @Bean
  public EmailService emailService() {
    return new SendGridEmailService();
  }
}
