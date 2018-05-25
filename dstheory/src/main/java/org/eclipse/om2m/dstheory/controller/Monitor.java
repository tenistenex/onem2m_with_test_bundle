package org.eclipse.om2m.dstheory.controller;
 
import java.math.BigInteger;
 




import org.eclipse.om2m.commons.constants.Constants;
import org.eclipse.om2m.commons.constants.MimeMediaType;
import org.eclipse.om2m.commons.constants.ResponseStatusCode;
import org.eclipse.om2m.commons.resource.AE;
import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.eclipse.om2m.commons.resource.ResponsePrimitive;
import org.eclipse.om2m.core.service.CseService;
import org.eclipse.om2m.dstheory.RequestSender;

 
public class Monitor {
 
	static CseService CSE;
	static String CSE_ID = Constants.CSE_ID;
	static String CSE_NAME = Constants.CSE_NAME;
	static String REQUEST_ENTITY = Constants.ADMIN_REQUESTING_ENTITY;
	//static String ipeId = "sample";
	static String applicationNAME = "D-S_theory";
	static String DESCRIPTOR = "DESCRIPTOR";
	static String DATA = "DATA";
	public static String RemoteCSE_ID = "/" + Constants.REMOTE_CSE_ID;
	public static String RemoteCSE_PREFIX = RemoteCSE_ID + "/" + Constants.REMOTE_CSE_NAME;
	
	
 
//	private SensorListener sensorListener;
//	private ActuatorListener actuatorListener;
 
	public Monitor(CseService cseService){
		CSE = cseService;
	}
 
	public void start(){
		// Create sensor resources
		createSensorResources();
		// Listen for the sensor data
	//	listenToSensor();
 
		// Create required resources for the Actuator
		//createActuatorResource();
		// Listen for the Actuator data
	//	listenToActuator();
	}
 
	public void stop(){
		//if(sensorListener != null && sensorListener.isAlive()){
			//sensorListener.stopThread();
		}
	/*	if(actuatorListener != null && actuatorListener.isAlive()){
			actuatorListener.stopThread();
		}
	}
 */
	public void createSensorResources(){
		String targetId, content;
 
		//targetId = "/" + CSE_ID + "/" + CSE_NAME;
		AE ae = new AE();
		ae.setRequestReachability(true);
		ae.setAppID(applicationNAME);
		ae.setName(applicationNAME);
		ae.getPointOfAccess().add(applicationNAME);
		ResponsePrimitive response = RequestSender.createINAE(ae);  //////application name? ipeId
		if(response.getResponseStatusCode().equals(ResponseStatusCode.CREATED)){
			targetId = RemoteCSE_PREFIX + "/"+ applicationNAME;   //container target url
			Container cnt = new Container();
			cnt.setMaxNrOfInstances(BigInteger.valueOf(10));
			cnt.setName("IN-ESCRIPTOR-Container");
			// Create the DESCRIPTOR container
			RequestSender.createContainer(targetId, cnt);
			// Create the DATA container
			cnt.setName("IN-DATA-Container");
			RequestSender.createContainer(targetId , cnt);
			// Create the description contentInstance
	/*		content = ObixUtil.getSensorDescriptorRep(applicationNAME, applicationNAME);
			targetId = "/" + RemoteCSE_PREFIX + "/" + applicationNAME + "/" + DESCRIPTOR;
			*/
			targetId = targetId + "/" + "IN-DATA-Container";
			content = "test IN-CSE DATA";
			ContentInstance cin = new ContentInstance();
			cin.setContent(content);
		//	cin.setContentInfo(MimeMediaType.OBIX);
			RequestSender.createContentInstance(targetId, cin);
		}
	}
 // only need one createResource
	/*public void createActuatorResource(){   
		String targetId, content;
 
		targetId = "/" + CSE_ID + "/" + CSE_NAME;
		AE ae = new AE();
		ae.setRequestReachability(true);
		ae.setAppID(ipeId);
		ae.getPointOfAccess().add(ipeId);
		ResponsePrimitive response = RequestSender.createAE(ae); //////application name?
 
		if(response.getResponseStatusCode().equals(ResponseStatusCode.CREATED)){
			targetId = "/" + CSE_ID + "/" + CSE_NAME + "/" + actuatorId;
			Container cnt = new Container();
			cnt.setMaxNrOfInstances(BigInteger.valueOf(10));
			// Create the DESCRIPTOR container
			RequestSender.createContainer(targetId + DESCRIPTOR, cnt);
 
			// Create the DATA container
			RequestSender.createContainer(targetId + DATA, cnt);
 
			// Create the description contentInstance
			content = ObixUtil.getActuatorDescriptorRep(actuatorId);
			targetId = "/" + CSE_ID + "/" + CSE_NAME + "/" + actuatorId + "/" + DESCRIPTOR;
			ContentInstance cin = new ContentInstance();
			cin.setContent(content);
			cin.setContentInfo(MimeMediaType.OBIX);
			RequestSender.createContentInstance(targetId, cin);
		}
	}*/
 
/*	public void listenToSensor(){
		sensorListener = new SensorListener();
		sensorListener.start();
	}
*/	
 /*
	public void listenToActuator(){
		actuatorListener = new ActuatorListener();
		actuatorListener.start();
	}
 
*/ 
/*	private static class SensorListener extends Thread{
 
		private boolean running = true;
 
		@Override
		public void run() {
			while(running){
				// Simulate a random measurement of the sensor
				sensorValue = 10 + (int) (Math.random() * 100);
 
				// Create the data contentInstance
				String content = "IN-contentinstance";
				String targetId = RemoteCSE_PREFIX + "/"+ applicationNAME + "/" + "IN-DATA-Container";
				ContentInstance cin = new ContentInstance();
				cin.setContent(content);
			//	cin.setContentInfo(MimeMediaType.OBIX);
				RequestSender.createContentInstance(targetId, cin);
 
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
 
		}
 
		public void stopThread(){
	//		running = false;
		}
 
	}
 
/*	private static class ActuatorListener extends Thread{
 
		private boolean running = true;
		private boolean memorizedActuatorValue = false;
 
		@Override
		public void run() {
			while(running){
				// If the actuator state has changed
				if(memorizedActuatorValue != actuatorValue){
					// Memorize the new actuator state
					memorizedActuatorValue = actuatorValue;
 
					// Create a data contentInstance
					String content = ObixUtil.getActuatorDataRep(memorizedActuatorValue);
					String targetId = "/" +  RemoteCSE_PREFIX + "/" + applicationNAME + "/" + DATA;
					ContentInstance cin = new ContentInstance();
					cin.setContent(content);
					cin.setContentInfo(MimeMediaType.OBIX);
					RequestSender.createContentInstance(targetId, cin);
				}
 
				// Wait for 2 seconds
				try{
					Thread.sleep(2000);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}
 
		public void stopThread(){
			running = false;
		}
 
	}*/
 
}