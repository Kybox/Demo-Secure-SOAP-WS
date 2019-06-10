
package fr.kybox.ws.msg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import fr.kybox.ws.model.Employee;


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
 *         &lt;element ref="{http://model.ws.kybox.fr}Employee" maxOccurs="unbounded"/&gt;
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
    "employeeList"
})
@XmlRootElement(name = "SearchEmployeeResp", namespace = "http://msg.ws.kybox.fr")
public class SearchEmployeeResp {

    @XmlElement(name = "Employee", namespace = "http://model.ws.kybox.fr", required = true)
    protected List<Employee> employeeList;

    /**
     * Default no-arg constructor
     * 
     */
    public SearchEmployeeResp() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SearchEmployeeResp(final List<Employee> employeeList) {
        this.employeeList = employeeList;
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
     * {@link Employee }
     * 
     * 
     */
    public List<Employee> getEmployeeList() {
        if (employeeList == null) {
            employeeList = new ArrayList<Employee>();
        }
        return this.employeeList;
    }

    public SearchEmployeeResp withEmployeeList(Employee... values) {
        if (values!= null) {
            for (Employee value: values) {
                getEmployeeList().add(value);
            }
        }
        return this;
    }

    public SearchEmployeeResp withEmployeeList(Collection<Employee> values) {
        if (values!= null) {
            getEmployeeList().addAll(values);
        }
        return this;
    }

}
