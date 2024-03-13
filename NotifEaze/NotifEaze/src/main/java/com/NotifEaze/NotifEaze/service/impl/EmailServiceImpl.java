package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	private GupshupMock gupshupMock;
	
	
	
	public EmailServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}



	public EmailServiceImpl(GupshupMock gupshupMock) {
		super();
		this.gupshupMock = gupshupMock;
	}



	@Override
	public BaseEmailResponse sendEmail(String to, String subject, String body) {
		// TODO Auto-generated method stub
		
		String emailResponse = gupshupMock.getEmailResponse(to);
		
		if(emailResponse != null) {
			
			
			return new BaseEmailResponse(true, "Email sent successfully");
		}
		
		
		return new BaseEmailResponse(false, "Email not found.");
	}

}
