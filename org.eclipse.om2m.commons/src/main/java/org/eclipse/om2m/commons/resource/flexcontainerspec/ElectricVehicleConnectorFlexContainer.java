/*
********************************************************************************
 * Copyright (c) 2014, 2017 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ********************************************************************************

ModuleClass : ElectricVehicleConnector

This ModuleClass provides the information about  charging/discharging devices for electric vehicles.

Created: 2017-09-28 17:26:40
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;


@XmlRootElement(name = ElectricVehicleConnectorFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = ElectricVehicleConnectorFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class ElectricVehicleConnectorFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "electricVehicleConnector";
	public static final String SHORT_NAME = "elVCr";
	
	public ElectricVehicleConnectorFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + ElectricVehicleConnectorFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}