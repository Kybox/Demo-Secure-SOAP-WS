
package fr.kybox.ws.msg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import fr.kybox.ws.model.Role;


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
 *         &lt;element ref="{http://model.ws.kybox.fr}Role" maxOccurs="unbounded"/&gt;
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
    "roleList"
})
@XmlRootElement(name = "GetRoleListResp", namespace = "http://msg.ws.kybox.fr")
public class GetRoleListResp {

    @XmlElement(name = "Role", namespace = "http://model.ws.kybox.fr", required = true)
    protected List<Role> roleList;

    /**
     * Default no-arg constructor
     * 
     */
    public GetRoleListResp() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetRoleListResp(final List<Role> roleList) {
        this.roleList = roleList;
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
     * {@link Role }
     * 
     * 
     */
    public List<Role> getRoleList() {
        if (roleList == null) {
            roleList = new ArrayList<Role>();
        }
        return this.roleList;
    }

    public GetRoleListResp withRoleList(Role... values) {
        if (values!= null) {
            for (Role value: values) {
                getRoleList().add(value);
            }
        }
        return this;
    }

    public GetRoleListResp withRoleList(Collection<Role> values) {
        if (values!= null) {
            getRoleList().addAll(values);
        }
        return this;
    }

}
