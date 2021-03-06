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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.15 at 03:56:27 PM CEST 
//

package org.eclipse.om2m.commons.resource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.eclipse.om2m.commons.constants.ShortName;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}announceableResource">
 *       &lt;sequence>
 *         &lt;element name="cseType" type="{http://www.onem2m.org/xml/protocols}cseTypeID" minOccurs="0"/>
 *         &lt;element name="pointOfAccess" type="{http://www.onem2m.org/xml/protocols}pOAList" minOccurs="0"/>
 *         &lt;element name="CSEBase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="CSE-ID" type="{http://www.onem2m.org/xml/protocols}ID"/>
 *         &lt;element name="M2M-Ext-ID" type="{http://www.onem2m.org/xml/protocols}externalID" minOccurs="0"/>
 *         &lt;element name="Trigger-Recipient-ID" type="{http://www.onem2m.org/xml/protocols}triggerRecipientID" minOccurs="0"/>
 *         &lt;element name="requestReachability" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nodeLink" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="childResource" type="{http://www.onem2m.org/xml/protocols}childResourceRef" maxOccurs="unbounded"/>
 *           &lt;choice maxOccurs="unbounded">
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}AE"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}container"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}group"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}accessControlPolicy"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}subscription"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}pollingChannel"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}schedule"/>
 *           &lt;/choice>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = ShortName.REMOTE_CSE)
public class RemoteCSE extends AnnounceableResource {
	@XmlElement(name=ShortName.CSE_TYPE, required=false, namespace="")
	protected BigInteger cseType;
	@XmlList
	@XmlElement(name=ShortName.POA, required=false, namespace="")
	protected List<String> pointOfAccess;
	@XmlElement(name = ShortName.REMOTE_CSE_CSEBASE, required = true, namespace="")
	@XmlSchemaType(name = "anyURI")
	protected String cseBase;
	@XmlElement(name = ShortName.CSE_ID, required = true, namespace="")
	protected String cseid;
	@XmlElement(name = ShortName.M2M_EXT_ID, required=false, namespace="")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String m2MExtID;
	@XmlElement(name = ShortName.TRIGGER_RECIPIENT_ID, required=false, namespace="")
	protected Long triggerRecipientID;
	@XmlElement(name=ShortName.REQUEST_REACHABILITY, required=true, namespace="")
	protected Boolean requestReachability;
	@XmlSchemaType(name = "anyURI")
	@XmlElement(name=ShortName.NODE_LINK, required=false, namespace="")
	protected String nodeLink;
	@XmlElement(name=ShortName.CHILD_RESOURCE, namespace="")
	protected List<ChildResourceRef> childResource;
	@XmlElements({
			@XmlElement(name = ShortName.AE, namespace = "http://www.onem2m.org/xml/protocols", type = AE.class),
			@XmlElement(name = ShortName.AE_ANNC, namespace = "http://www.onem2m.org/xml/protocols", type = AEAnnc.class),
			@XmlElement(name = ShortName.CNT, namespace = "http://www.onem2m.org/xml/protocols", type = Container.class),
			@XmlElement(name = ShortName.GROUP, namespace = "http://www.onem2m.org/xml/protocols", type = Group.class),
			@XmlElement(name = ShortName.ACP, namespace = "http://www.onem2m.org/xml/protocols", type = AccessControlPolicy.class),
			@XmlElement(name = ShortName.SUB, namespace = "http://www.onem2m.org/xml/protocols", type = Subscription.class),
			@XmlElement(name = ShortName.PCH, namespace = "http://www.onem2m.org/xml/protocols", type = PollingChannel.class),
			@XmlElement(name = ShortName.SCHEDULE, namespace = "http://www.onem2m.org/xml/protocols", type = Schedule.class) })
	protected List<Resource> aeOrContainerOrGroup;

	/**
	 * Gets the value of the cseType property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getCseType() {
		return cseType;
	}

	/**
	 * Sets the value of the cseType property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setCseType(BigInteger value) {
		this.cseType = value;
	}

	/**
	 * Gets the value of the pointOfAccess property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the pointOfAccess property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPointOfAccess().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getPointOfAccess() {
		if (pointOfAccess == null) {
			pointOfAccess = new ArrayList<String>();
		}
		return this.pointOfAccess;
	}

	/**
	 * Gets the value of the cseBase property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCSEBase() {
		return cseBase;
	}

	/**
	 * Sets the value of the cseBase property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCSEBase(String value) {
		this.cseBase = value;
	}

	/**
	 * Gets the value of the cseid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCSEID() {
		return cseid;
	}

	/**
	 * Sets the value of the cseid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCSEID(String value) {
		this.cseid = value;
	}

	/**
	 * Gets the value of the m2MExtID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getM2MExtID() {
		return m2MExtID;
	}

	/**
	 * Sets the value of the m2MExtID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setM2MExtID(String value) {
		this.m2MExtID = value;
	}

	/**
	 * Gets the value of the triggerRecipientID property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getTriggerRecipientID() {
		return triggerRecipientID;
	}

	/**
	 * Sets the value of the triggerRecipientID property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setTriggerRecipientID(Long value) {
		this.triggerRecipientID = value;
	}

	/**
	 * Gets the value of the requestReachability property.
	 * 
	 */
	public Boolean isRequestReachability() {
		return requestReachability;
	}

	/**
	 * Sets the value of the requestReachability property.
	 * 
	 */
	public void setRequestReachability(Boolean value) {
		this.requestReachability = value;
	}

	/**
	 * Gets the value of the nodeLink property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNodeLink() {
		return nodeLink;
	}

	/**
	 * Sets the value of the nodeLink property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNodeLink(String value) {
		this.nodeLink = value;
	}

	/**
	 * Gets the value of the childResource property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the childResource property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getChildResource().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ChildResourceRef }
	 * 
	 * 
	 */
	public List<ChildResourceRef> getChildResource() {
		if (childResource == null) {
			childResource = new ArrayList<ChildResourceRef>();
		}
		return this.childResource;
	}

	/**
	 * Gets the value of the aeOrContainerOrGroup property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the aeOrContainerOrGroup property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAEOrContainerOrGroup().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link AE }
	 * {@link Container } {@link Group } {@link AccessControlPolicy }
	 * {@link Subscription } {@link PollingChannel } {@link Schedule }
	 * 
	 * 
	 */
	public List<Resource> getAEOrContainerOrGroup() {
		if (aeOrContainerOrGroup == null) {
			aeOrContainerOrGroup = new ArrayList<Resource>();
		}
		return this.aeOrContainerOrGroup;
	}

}
