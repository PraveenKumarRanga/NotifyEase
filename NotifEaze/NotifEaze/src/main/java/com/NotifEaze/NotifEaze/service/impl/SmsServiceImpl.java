package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.service.SmsService;
@Service
public class SmsServiceImpl implements SmsService{

	private GupshupMock gupshupMock;	
	
	public SmsServiceImpl(GupshupMock gupshupMock) {
		super();
		this.gupshupMock = gupshupMock;
	}

	public SmsServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public BaseSmsResponse sendSms(String phoneNumber, String message) {
		// TODO Auto-generated method stub
		String smsResponse = gupshupMock.getSmsResponse(phoneNumber);
		
		if(smsResponse != null) {
			
			
			return new BaseSmsResponse(true, "Sms sent successfully.");
		}
		return new BaseSmsResponse(false, message);
	}

	@Override
	public SmsDeliveryStatus checkDeliveryStatus(String messageId) {
		// TODO Auto-generated method stub
		String smsDelivery = gupshupMock.getSmsDeliveryStatusResponse(messageId);
		
		if(smsDelivery != null) {
			return new SmsDeliveryStatus(true, messageId);
		}
		return new SmsDeliveryStatus(false, messageId);
	}

}
