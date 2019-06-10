
package fr.kybox.ws.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://model.ws.kybox.fr}Role" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "firstName",
    "lastName",
    "roleList"
})
@XmlRootElement(name = "Employee", namespace = "http://model.ws.kybox.fr")
@Entity
@Table(name = "tb_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @XmlElement(required = true)
    @NotBlank
    protected String firstName;
    @XmlElement(required = true)
    @NotBlank
    protected String lastName;
    @XmlElement(name = "Role", namespace = "http://model.ws.kybox.fr")
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class, cascade = {
        CascadeType.ALL
    })
    @JoinTable(name = "tb_employee_role", joinColumns = {
        @JoinColumn(name = "employee_id")
    }, inverseJoinColumns = {
        @JoinColumn(name = "role_id")
    })
    protected List<fr.kybox.ws.model.Role> roleList;

    /**
     * Default no-arg constructor
     * 
     */
    public Employee() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public Employee(final Long id, final String firstName, final String lastName, final List<fr.kybox.ws.model.Role> roleList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleList = roleList;
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
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the roleList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link fr.kybox.ws.model.Role }
     * 
     * 
     */
    public List<fr.kybox.ws.model.Role> getRoleList() {
        if (roleList == null) {
            roleList = new ArrayList<fr.kybox.ws.model.Role>();
        }
        return this.roleList;
    }

    public Employee withId(Long value) {
        setId(value);
        return this;
    }

    public Employee withFirstName(String value) {
        setFirstName(value);
        return this;
    }

    public Employee withLastName(String value) {
        setLastName(value);
        return this;
    }

    public Employee withRoleList(fr.kybox.ws.model.Role... values) {
        if (values!= null) {
            for (fr.kybox.ws.model.Role value: values) {
                getRoleList().add(value);
            }
        }
        return this;
    }

    public Employee withRoleList(Collection<fr.kybox.ws.model.Role> values) {
        if (values!= null) {
            getRoleList().addAll(values);
        }
        return this;
    }

}
