package com.NotifEaze.NotifEaze.service.impl;

import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.service.PushNotificationService;

public class PushNotificationServiceImpl implements PushNotificationService{

	private GupshupMock gupshupMock;
	
	
	
	public PushNotificationServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PushNotificationServiceImpl(GupshupMock gupshupMock) {
		super();
		this.gupshupMock = gupshupMock;
	}
	
	@Override
	public BasePushNotificationResponse sendNotification(String fcmToken, String message) {
		// TODO Auto-generated method stub
		
		String notification = gupshupMock.getPushNotificationResponse(fcmToken);
		
		if(notification != null) {
			
			return new BasePushNotificationResponse(true, message);
			
		}
		
		
		return new BasePushNotificationResponse(false, message);
	}

}
