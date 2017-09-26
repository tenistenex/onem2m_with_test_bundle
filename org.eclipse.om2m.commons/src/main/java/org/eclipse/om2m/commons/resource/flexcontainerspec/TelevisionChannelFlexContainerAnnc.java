/*
ModuleClass : TelevisionChannelAnnc



This ModuleClass provides capabilities to set and get channels  of a device that has a channel list.

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


@XmlRootElement(name = TelevisionChannelFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = TelevisionChannelFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class TelevisionChannelFlexContainerAnnc extends AbstractFlexContainerAnnc {
	
	public static final String LONG_NAME = "televisionChannelAnnc";
	public static final String SHORT_NAME = "telClAnnc";
	
	public TelevisionChannelFlexContainerAnnc () {
		setContainerDefinition("org.onem2m.home.moduleclass." + TelevisionChannelFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
	public void finalizeSerialization() {
		getUpChannelAnnc();
		getDownChannelAnnc();
	}
	
	public void finalizeDeserialization() {
		if (this.upChannelAnnc != null) {
			setUpChannelAnnc(upChannelAnnc);
		}
		if (this.downChannelAnnc != null) {
			setDownChannelAnnc(downChannelAnnc);
		}
	}
	
	@XmlElement(name=UpChannelFlexContainerAnnc.SHORT_NAME, required=true, type=UpChannelFlexContainerAnnc.class)
	private UpChannelFlexContainerAnnc upChannelAnnc;
	
	
	public void setUpChannelAnnc(UpChannelFlexContainerAnnc upChannelAnnc) {
		this.upChannelAnnc = upChannelAnnc;
		getFlexContainerOrContainerOrSubscription().add(upChannelAnnc);
	}
	
	public UpChannelFlexContainerAnnc getUpChannelAnnc() {
		this.upChannelAnnc = (UpChannelFlexContainerAnnc) getResourceByName(UpChannelFlexContainerAnnc.SHORT_NAME);
		return upChannelAnnc;
	}
	
	@XmlElement(name=DownChannelFlexContainerAnnc.SHORT_NAME, required=true, type=DownChannelFlexContainerAnnc.class)
	private DownChannelFlexContainerAnnc downChannelAnnc;
	
	
	public void setDownChannelAnnc(DownChannelFlexContainerAnnc downChannelAnnc) {
		this.downChannelAnnc = downChannelAnnc;
		getFlexContainerOrContainerOrSubscription().add(downChannelAnnc);
	}
	
	public DownChannelFlexContainerAnnc getDownChannelAnnc() {
		this.downChannelAnnc = (DownChannelFlexContainerAnnc) getResourceByName(DownChannelFlexContainerAnnc.SHORT_NAME);
		return downChannelAnnc;
	}
	
}