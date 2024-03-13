package com.NotifEaze.NotifEaze.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.service.EmailService;
import com.NotifEaze.NotifEaze.service.PushNotificationService;
import com.NotifEaze.NotifEaze.service.SmsService;

@RestController
@RequestMapping("/api/communication")
public class CommunicationController {
	
	private EmailService emailService;
	
	private SmsService smsService;
	
	private PushNotificationService notifiService;
	
	

	public CommunicationController(EmailService emailService,SmsService smsService,PushNotificationService notifiService) {
		super();
		this.emailService = emailService;
		this.smsService = smsService;
		this.notifiService = notifiService;
	}

	@PostMapping("/send-sms")
    public ResponseEntity<BaseSmsResponse> sendSms(@RequestBody Map<String, String> request) {
        /* To be developed */
    	
		BaseSmsResponse response = smsService.sendSms(request.get("phoneNumber"), request.get("message"));
		
        return ResponseEntity.ok(response);
    }

    @PostMapping("/send-email")
    public ResponseEntity<BaseEmailResponse> sendEmail(@RequestBody Map<String, String> request) {
        /* To be developed */
    	BaseEmailResponse response = emailService.sendEmail(request.get("to"), request.get("subject"), request.get("body"));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/send-notification")
    public ResponseEntity<BasePushNotificationResponse> sendNotification(@RequestBody Map<String, String> request) {
        /* To be developed */
    	
    	BasePushNotificationResponse response = notifiService.sendNotification(request.get("fmcToken"), request.get("message"));
    	
    	
        return ResponseEntity.ok(response);
    }
}
