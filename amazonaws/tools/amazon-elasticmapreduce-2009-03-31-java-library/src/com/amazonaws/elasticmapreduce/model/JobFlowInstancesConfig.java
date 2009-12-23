
package com.amazonaws.elasticmapreduce.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JobFlowInstancesConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JobFlowInstancesConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MasterInstanceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SlaveInstanceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InstanceCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Ec2KeyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Placement" type="{http://elasticmapreduce.amazonaws.com/doc/2009-03-31}PlacementType" minOccurs="0"/>
 *         &lt;element name="KeepJobFlowAliveWhenNoSteps" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * Generated by AWS Code Generator
 * <p/>
 * Tue Apr 21 15:28:27 PDT 2009
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobFlowInstancesConfig", propOrder = {
    "masterInstanceType",
    "slaveInstanceType",
    "instanceCount",
    "ec2KeyName",
    "placement",
    "keepJobFlowAliveWhenNoSteps"
})
public class JobFlowInstancesConfig {

    @XmlElement(name = "MasterInstanceType", required = true)
    protected String masterInstanceType;
    @XmlElement(name = "SlaveInstanceType", required = true)
    protected String slaveInstanceType;
    @XmlElement(name = "InstanceCount")
    protected int instanceCount;
    @XmlElement(name = "Ec2KeyName")
    protected String ec2KeyName;
    @XmlElement(name = "Placement")
    protected PlacementType placement;
    @XmlElement(name = "KeepJobFlowAliveWhenNoSteps")
    protected Boolean keepJobFlowAliveWhenNoSteps;

    /**
     * Default constructor
     * 
     */
    public JobFlowInstancesConfig() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public JobFlowInstancesConfig(final String masterInstanceType, final String slaveInstanceType, final int instanceCount, final String ec2KeyName, final PlacementType placement, final Boolean keepJobFlowAliveWhenNoSteps) {
        this.masterInstanceType = masterInstanceType;
        this.slaveInstanceType = slaveInstanceType;
        this.instanceCount = instanceCount;
        this.ec2KeyName = ec2KeyName;
        this.placement = placement;
        this.keepJobFlowAliveWhenNoSteps = keepJobFlowAliveWhenNoSteps;
    }

    /**
     * Gets the value of the masterInstanceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterInstanceType() {
        return masterInstanceType;
    }

    /**
     * Sets the value of the masterInstanceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterInstanceType(String value) {
        this.masterInstanceType = value;
    }

    public boolean isSetMasterInstanceType() {
        return (this.masterInstanceType!= null);
    }

    /**
     * Gets the value of the slaveInstanceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlaveInstanceType() {
        return slaveInstanceType;
    }

    /**
     * Sets the value of the slaveInstanceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlaveInstanceType(String value) {
        this.slaveInstanceType = value;
    }

    public boolean isSetSlaveInstanceType() {
        return (this.slaveInstanceType!= null);
    }

    /**
     * Gets the value of the instanceCount property.
     * 
     */
    public int getInstanceCount() {
        return instanceCount;
    }

    /**
     * Sets the value of the instanceCount property.
     * 
     */
    public void setInstanceCount(int value) {
        this.instanceCount = value;
    }

    public boolean isSetInstanceCount() {
        return true;
    }

    /**
     * Gets the value of the ec2KeyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEc2KeyName() {
        return ec2KeyName;
    }

    /**
     * Sets the value of the ec2KeyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEc2KeyName(String value) {
        this.ec2KeyName = value;
    }

    public boolean isSetEc2KeyName() {
        return (this.ec2KeyName!= null);
    }

    /**
     * Gets the value of the placement property.
     * 
     * @return
     *     possible object is
     *     {@link PlacementType }
     *     
     */
    public PlacementType getPlacement() {
        return placement;
    }

    /**
     * Sets the value of the placement property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlacementType }
     *     
     */
    public void setPlacement(PlacementType value) {
        this.placement = value;
    }

    public boolean isSetPlacement() {
        return (this.placement!= null);
    }

    /**
     * Gets the value of the keepJobFlowAliveWhenNoSteps property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isKeepJobFlowAliveWhenNoSteps() {
        return keepJobFlowAliveWhenNoSteps;
    }

    /**
     * Sets the value of the keepJobFlowAliveWhenNoSteps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setKeepJobFlowAliveWhenNoSteps(Boolean value) {
        this.keepJobFlowAliveWhenNoSteps = value;
    }

    public boolean isSetKeepJobFlowAliveWhenNoSteps() {
        return (this.keepJobFlowAliveWhenNoSteps!= null);
    }

    /**
     * Sets the value of the MasterInstanceType property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public JobFlowInstancesConfig withMasterInstanceType(String value) {
        setMasterInstanceType(value);
        return this;
    }

    /**
     * Sets the value of the SlaveInstanceType property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public JobFlowInstancesConfig withSlaveInstanceType(String value) {
        setSlaveInstanceType(value);
        return this;
    }

    /**
     * Sets the value of the InstanceCount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public JobFlowInstancesConfig withInstanceCount(int value) {
        setInstanceCount(value);
        return this;
    }

    /**
     * Sets the value of the Ec2KeyName property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public JobFlowInstancesConfig withEc2KeyName(String value) {
        setEc2KeyName(value);
        return this;
    }

    /**
     * Sets the value of the Placement property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public JobFlowInstancesConfig withPlacement(PlacementType value) {
        setPlacement(value);
        return this;
    }

    /**
     * Sets the value of the KeepJobFlowAliveWhenNoSteps property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public JobFlowInstancesConfig withKeepJobFlowAliveWhenNoSteps(Boolean value) {
        setKeepJobFlowAliveWhenNoSteps(value);
        return this;
    }
    

    /**
     * 
     * XML fragment representation of this object
     * 
     * @return XML fragment for this object. Name for outer
     * tag expected to be set by calling method. This fragment
     * returns inner properties representation only
     */
    protected String toXMLFragment() {
        StringBuffer xml = new StringBuffer();
        if (isSetMasterInstanceType()) {
            xml.append("<MasterInstanceType>");
            xml.append(escapeXML(getMasterInstanceType()));
            xml.append("</MasterInstanceType>");
        }
        if (isSetSlaveInstanceType()) {
            xml.append("<SlaveInstanceType>");
            xml.append(escapeXML(getSlaveInstanceType()));
            xml.append("</SlaveInstanceType>");
        }
        if (isSetInstanceCount()) {
            xml.append("<InstanceCount>");
            xml.append(getInstanceCount() + "");
            xml.append("</InstanceCount>");
        }
        if (isSetEc2KeyName()) {
            xml.append("<Ec2KeyName>");
            xml.append(escapeXML(getEc2KeyName()));
            xml.append("</Ec2KeyName>");
        }
        if (isSetPlacement()) {
            PlacementType  placement = getPlacement();
            xml.append("<Placement>");
            xml.append(placement.toXMLFragment());
            xml.append("</Placement>");
        } 
        if (isSetKeepJobFlowAliveWhenNoSteps()) {
            xml.append("<KeepJobFlowAliveWhenNoSteps>");
            xml.append(isKeepJobFlowAliveWhenNoSteps() + "");
            xml.append("</KeepJobFlowAliveWhenNoSteps>");
        }
        return xml.toString();
    }

    /**
     * 
     * Escape XML special characters
     */
    private String escapeXML(String string) {
        StringBuffer sb = new StringBuffer();
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
            case '&':
                sb.append("&amp;");
                break;
            case '<':
                sb.append("&lt;");
                break;
            case '>':
                sb.append("&gt;");
                break;
            case '\'':
                sb.append("&#039;");
                break;
            case '"':
                sb.append("&quot;");
                break;
            default:
                sb.append(c);
            }
        }
        return sb.toString();
    }



    /**
     *
     * JSON fragment representation of this object
     *
     * @return JSON fragment for this object. Name for outer
     * object expected to be set by calling method. This fragment
     * returns inner properties representation only
     *
     */
    protected String toJSONFragment() {
        StringBuffer json = new StringBuffer();
        boolean first = true;
        if (isSetMasterInstanceType()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("MasterInstanceType"));
            json.append(" : ");
            json.append(quoteJSON(getMasterInstanceType()));
            first = false;
        }
        if (isSetSlaveInstanceType()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SlaveInstanceType"));
            json.append(" : ");
            json.append(quoteJSON(getSlaveInstanceType()));
            first = false;
        }
        if (isSetInstanceCount()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("InstanceCount"));
            json.append(" : ");
            json.append(quoteJSON(getInstanceCount() + ""));
            first = false;
        }
        if (isSetEc2KeyName()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("Ec2KeyName"));
            json.append(" : ");
            json.append(quoteJSON(getEc2KeyName()));
            first = false;
        }
        if (isSetPlacement()) {
            if (!first) json.append(", ");
            json.append("\"Placement\" : {");
            PlacementType  placement = getPlacement();


            json.append(placement.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetKeepJobFlowAliveWhenNoSteps()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("KeepJobFlowAliveWhenNoSteps"));
            json.append(" : ");
            json.append(quoteJSON(isKeepJobFlowAliveWhenNoSteps() + ""));
            first = false;
        }
        return json.toString();
    }

    /**
     *
     * Quote JSON string
     */
    private String quoteJSON(String string) {
        StringBuffer sb = new StringBuffer();
        sb.append("\"");
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
            case '"':
                sb.append("\\\"");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '/':
                sb.append("\\/");
                break;
            case '\b':
                sb.append("\\b");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\n':
                sb.append("\\n");
                break;
            case '\r':
                sb.append("\\r");
                break;
            case '\t':
                sb.append("\\t");
                break;
            default:
                if (c <  ' ') {
                    sb.append("\\u" + String.format("%03x", Integer.valueOf(c)));
                } else {
                sb.append(c);
            }
        }
        }
        sb.append("\"");
        return sb.toString();
    }


}
