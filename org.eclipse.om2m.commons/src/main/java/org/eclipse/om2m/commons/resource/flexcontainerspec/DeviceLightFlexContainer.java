/*
Device : DeviceLight



A light is a device that is used to control the state of an illumination device.

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


@XmlRootElement(name = DeviceLightFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = DeviceLightFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class DeviceLightFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "deviceLight";
	public static final String SHORT_NAME = "devLt";
	
	public DeviceLightFlexContainer () {
		setContainerDefinition("org.onem2m.home.device." + DeviceLightFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
	public void finalizeSerialization() {
		getFaultDetection();
		getBinarySwitch();
		getRunMode();
		getColour();
		getColourSaturation();
		getBrightness();
	}
	
	public void finalizeDeserialization() {
		if (this.faultDetection != null) {
			setFaultDetection(this.faultDetection);
		}
		if (this.binarySwitch != null) {
			setBinarySwitch(this.binarySwitch);
		}
		if (this.runMode != null) {
			setRunMode(this.runMode);
		}
		if (this.colour != null) {
			setColour(this.colour);
		}
		if (this.colourSaturation != null) {
			setColourSaturation(this.colourSaturation);
		}
		if (this.brightness != null) {
			setBrightness(this.brightness);
		}
	}
	
	@XmlElement(name="fauDn", required=true, type=FaultDetectionFlexContainer.class)
	private FaultDetectionFlexContainer faultDetection;
	
	
	public void setFaultDetection(FaultDetectionFlexContainer faultDetection) {
		this.faultDetection = faultDetection;
		getFlexContainerOrContainerOrSubscription().add(faultDetection);
	}
	
	public FaultDetectionFlexContainer getFaultDetection() {
		this.faultDetection = (FaultDetectionFlexContainer) getResourceByName(FaultDetectionFlexContainer.SHORT_NAME);
		return faultDetection;
	}
	
	@XmlElement(name="binSh", required=true, type=BinarySwitchFlexContainer.class)
	private BinarySwitchFlexContainer binarySwitch;
	
	
	public void setBinarySwitch(BinarySwitchFlexContainer binarySwitch) {
		this.binarySwitch = binarySwitch;
		getFlexContainerOrContainerOrSubscription().add(binarySwitch);
	}
	
	public BinarySwitchFlexContainer getBinarySwitch() {
		this.binarySwitch = (BinarySwitchFlexContainer) getResourceByName(BinarySwitchFlexContainer.SHORT_NAME);
		return binarySwitch;
	}
	
	@XmlElement(name="runMe", required=true, type=RunModeFlexContainer.class)
	private RunModeFlexContainer runMode;
	
	
	public void setRunMode(RunModeFlexContainer runMode) {
		this.runMode = runMode;
		getFlexContainerOrContainerOrSubscription().add(runMode);
	}
	
	public RunModeFlexContainer getRunMode() {
		this.runMode = (RunModeFlexContainer) getResourceByName(RunModeFlexContainer.SHORT_NAME);
		return runMode;
	}
	
	@XmlElement(name="color", required=true, type=ColourFlexContainer.class)
	private ColourFlexContainer colour;
	
	
	public void setColour(ColourFlexContainer colour) {
		this.colour = colour;
		getFlexContainerOrContainerOrSubscription().add(colour);
	}
	
	public ColourFlexContainer getColour() {
		this.colour = (ColourFlexContainer) getResourceByName(ColourFlexContainer.SHORT_NAME);
		return colour;
	}
	
	@XmlElement(name="colSn", required=true, type=ColourSaturationFlexContainer.class)
	private ColourSaturationFlexContainer colourSaturation;
	
	
	public void setColourSaturation(ColourSaturationFlexContainer colourSaturation) {
		this.colourSaturation = colourSaturation;
		getFlexContainerOrContainerOrSubscription().add(colourSaturation);
	}
	
	public ColourSaturationFlexContainer getColourSaturation() {
		this.colourSaturation = (ColourSaturationFlexContainer) getResourceByName(ColourSaturationFlexContainer.SHORT_NAME);
		return colourSaturation;
	}
	
	@XmlElement(name="brigs", required=true, type=BrightnessFlexContainer.class)
	private BrightnessFlexContainer brightness;
	
	
	public void setBrightness(BrightnessFlexContainer brightness) {
		this.brightness = brightness;
		getFlexContainerOrContainerOrSubscription().add(brightness);
	}
	
	public BrightnessFlexContainer getBrightness() {
		this.brightness = (BrightnessFlexContainer) getResourceByName(BrightnessFlexContainer.SHORT_NAME);
		return brightness;
	}
	
}