
package fr.kybox.ws.msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="keyword" type="{http://www.w3.org/2001/XMLSchema}string" default="all" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "SearchEmployeeReq", namespace = "http://msg.ws.kybox.fr")
public class SearchEmployeeReq {

    @XmlAttribute(name = "keyword")
    protected String keyword;

    /**
     * Default no-arg constructor
     * 
     */
    public SearchEmployeeReq() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SearchEmployeeReq(final String keyword) {
        this.keyword = keyword;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyword() {
        if (keyword == null) {
            return "all";
        } else {
            return keyword;
        }
    }

    /**
     * Sets the value of the keyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyword(String value) {
        this.keyword = value;
    }

    public SearchEmployeeReq withKeyword(String value) {
        setKeyword(value);
        return this;
    }

}
