
package fr.kybox.ws.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://model.ws.kybox.fr}Employee" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "name"
})
@XmlRootElement(name = "Role", namespace = "http://model.ws.kybox.fr")
@Entity
@Table(name = "tb_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @XmlElement(required = true)
    @NotBlank
    @Column(name = "role_name", length = 50)
    protected String name;
    @XmlTransient
    @ManyToMany(mappedBy = "roleList", fetch = FetchType.EAGER, targetEntity = Employee.class)
    protected List<fr.kybox.ws.model.Employee> employeeList;

    /**
     * Default no-arg constructor
     * 
     */
    public Role() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public Role(final Long id, final String name, final List<fr.kybox.ws.model.Employee> employeeList) {
        this.id = id;
        this.name = name;
        this.employeeList = employeeList;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the employeeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the employeeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmployeeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link fr.kybox.ws.model.Employee }
     * 
     * 
     */
    public List<fr.kybox.ws.model.Employee> getEmployeeList() {
        if (employeeList == null) {
            employeeList = new ArrayList<fr.kybox.ws.model.Employee>();
        }
        return this.employeeList;
    }

    public Role withId(Long value) {
        setId(value);
        return this;
    }

    public Role withName(String value) {
        setName(value);
        return this;
    }

    public Role withEmployeeList(fr.kybox.ws.model.Employee... values) {
        if (values!= null) {
            for (fr.kybox.ws.model.Employee value: values) {
                getEmployeeList().add(value);
            }
        }
        return this;
    }

    public Role withEmployeeList(Collection<fr.kybox.ws.model.Employee> values) {
        if (values!= null) {
            getEmployeeList().addAll(values);
        }
        return this;
    }

}
