package com.thomaskavi.integration.services;

import com.thomaskavi.integration.dto.EmailDTO;

public interface EmailService {

  void sendEmail(EmailDTO dto);
}
