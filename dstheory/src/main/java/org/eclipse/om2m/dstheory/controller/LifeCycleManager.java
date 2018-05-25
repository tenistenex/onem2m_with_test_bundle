/*******************************************************************************
 * Copyright (c) 2013-2016 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial Contributors:
 *     Thierry Monteil : Project manager, technical co-manager
 *     Mahdi Ben Alaya : Technical co-manager
 *     Samir Medjiah : Technical co-manager
 *     Khalil Drira : Strategy expert
 *     Guillaume Garzone : Developer
 *     François Aïssaoui : Developer
 *
 * New contributors :
 *******************************************************************************/
package org.eclipse.om2m.dstheory.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.constants.MimeMediaType;
import org.eclipse.om2m.commons.constants.ResponseStatusCode;
import org.eclipse.om2m.commons.resource.AE;
import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.eclipse.om2m.commons.resource.ResponsePrimitive;
import org.eclipse.om2m.dstheory.RequestSender;
import org.eclipse.om2m.dstheory.constant.SampleConstants;


public class LifeCycleManager {

	private static Log LOGGER = LogFactory.getLog(LifeCycleManager.class); 

	/**
	 * Handle the start of the plugin with the resource representation and the GUI
	 */
	public static void start(){
		
		Map<String, Integer> sensor = new HashMap<String, Integer>();
		
		/////////------------------sensor initial value------------///////////////
		
		sensor.put("Clock", 0);
		sensor.put("Light", 0);
		sensor.put("Bed", 0);
		sensor.put("Card", 0);
		sensor.put("Tv", 0);
		
		/////////------------------create sensor application resource------------**********
		
		
		createSensorResources("Clock", false, SampleConstants.POA);
		createSensorResources("Light", false, SampleConstants.POA);
		createSensorResources("Bed", false, SampleConstants.POA);
		createSensorResources("Card", false, SampleConstants.POA);
		createSensorResources("Tv", false, SampleConstants.POA);
		
	///////--------------------create IN application resource---------------***********
		
		    String targetId, content;
		    
			AE ae = new AE();
			ae.setRequestReachability(true);
			ae.setAppID(SampleConstants.IN_NAME);
			ae.setName(SampleConstants.IN_NAME);
			ae.getPointOfAccess().add(SampleConstants.POA);
			ResponsePrimitive response = RequestSender.createINAE(ae);  //////application name? ipeId
			
			if(response.getResponseStatusCode().equals(ResponseStatusCode.CREATED)){
				targetId = SampleConstants.RemoteCSE_PREFIX + "/" + SampleConstants.IN_NAME;   //container target url
				Container cnt = new Container();
				cnt.setMaxNrOfInstances(BigInteger.valueOf(10));
				cnt.setName("DESCRIPTOR");
				// Create the DESCRIPTOR container
				RequestSender.createContainer(targetId, cnt);
				// Create the DATA container
				cnt.setName("DATA");
				RequestSender.createContainer(targetId , cnt);
				// Create the description contentInstance
		/*		content = ObixUtil.getSensorDescriptorRep(applicationNAME, applicationNAME);
				targetId = "/" + RemoteCSE_PREFIX + "/" + applicationNAME + "/" + DESCRIPTOR;
				*/
				targetId = targetId + "/" + "DESCRIPTOR";
				content = "The D-S Theory result";
				ContentInstance cin = new ContentInstance();
				cin.setContent(content);
			//	cin.setContentInfo(MimeMediaType.OBIX);
				RequestSender.createContentInstance(targetId, cin);
			}
		
	
	}
	
	    
	/**
	 * Creates all required resources.
	 * @param appId - Application ID
	 * @param initValue - initial lamp value
	 * @param poa - lamp Point of Access
	 */
	private static void createSensorResources(String appId, boolean initValue, String poa) {
		// Create the Application resource
		Container container = new Container();
		container.getLabels().add("Sensor");
		container.setMaxNrOfInstances(BigInteger.valueOf(0));
		

		AE ae = new AE();
		ae.setRequestReachability(true);
		ae.getPointOfAccess().add(poa);
		ae.setAppID(appId);
		ae.setName(appId);

		ResponsePrimitive response = RequestSender.createAE(ae);
		// Create Application sub-resources only if application not yet created
		if(response.getResponseStatusCode().equals(ResponseStatusCode.CREATED)) {
			container = new Container();
			container.setMaxNrOfInstances(BigInteger.valueOf(10));
			// Create DESCRIPTOR container sub-resource
			container.setName(SampleConstants.DESC);
			LOGGER.info(RequestSender.createContainer(response.getLocation(), container));
			// Create STATE container sub-resource
			container.setName(SampleConstants.DATA);
			LOGGER.info(RequestSender.createContainer(response.getLocation(), container));

			String content;
			// Create DESCRIPTION contentInstance on the DESCRIPTOR container resource
			content = "This is the " + appId + " Sensor";
			ContentInstance contentInstance = new ContentInstance();
			contentInstance.setContent(content);
			contentInstance.setContentInfo(MimeMediaType.OBIX);
			
			RequestSender.createContentInstance(
					SampleConstants.CSE_PREFIX + "/" + appId + "/" + SampleConstants.DESC, contentInstance);

			// Create initial contentInstance on the STATE container resource
			content = "no value";
			contentInstance.setContent(content);
			RequestSender.createContentInstance(
					SampleConstants.CSE_PREFIX + "/" + appId + "/" + SampleConstants.DATA, contentInstance);
		}
	}

	/**
	 * Create the LAMP_ALL container
	 * @param poa
	 */

}
