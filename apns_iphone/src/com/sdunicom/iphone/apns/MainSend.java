package com.sdunicom.iphone.apns;

import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

public class MainSend {
	public static void main(String[] args) throws Exception {
		try {
			  String deviceToken = "fc57ea64a6f56a9d16c20932a0abb3ec25e00a78dde845b52d6e350d9fe4a9a9";

			  PayLoad payLoad = new PayLoad();
			  payLoad.addAlert("Œ“µƒpush≤‚ ‘");
			  payLoad.addBadge(4);
			  payLoad.addSound("default");
						
			  PushNotificationManager pushManager = PushNotificationManager.getInstance();
			  pushManager.addDevice("iPhone", deviceToken);
						
			  //Connect to APNs
			  String host= "gateway.sandbox.push.apple.com";
			  int port = 2195;
			  String certificatePath= "D:/aps_allen.p12";
			  String certificatePassword= "sunlg";
			  pushManager.initializeConnection(host,port, certificatePath,certificatePassword, SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
						
			  //Send Push
			  Device client = pushManager.getDevice("iPhone");
			  pushManager.sendNotification(client, payLoad);
			  pushManager.stopConnection();

			  pushManager.removeDevice("iPhone");
			 }
			 catch (Exception e) {
			  e.printStackTrace();
			 }

	}
}
