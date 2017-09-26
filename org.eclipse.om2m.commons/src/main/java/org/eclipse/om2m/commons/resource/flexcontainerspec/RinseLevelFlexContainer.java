/*
ModuleClass : RinseLevel



This ModuleClass provides capabilities to control and monitor  the level of rinse. It is intended to be part of object which uses  rinse such as a washing machine.

Created: 2017-09-26 14:17:12
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;


@XmlRootElement(name = RinseLevelFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = RinseLevelFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class RinseLevelFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "rinseLevel";
	public static final String SHORT_NAME = "rinLl";
	
	public RinseLevelFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + RinseLevelFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}