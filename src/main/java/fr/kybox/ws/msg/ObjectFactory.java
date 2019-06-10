
package fr.kybox.ws.msg;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.kybox.ws.msg package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.kybox.ws.msg
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddRoleReq }
     * 
     */
    public AddRoleReq createAddRoleReq() {
        return new AddRoleReq();
    }

    /**
     * Create an instance of {@link AddRoleResp }
     * 
     */
    public AddRoleResp createAddRoleResp() {
        return new AddRoleResp();
    }

    /**
     * Create an instance of {@link AddEmployeeReq }
     * 
     */
    public AddEmployeeReq createAddEmployeeReq() {
        return new AddEmployeeReq();
    }

    /**
     * Create an instance of {@link AddEmployeeResp }
     * 
     */
    public AddEmployeeResp createAddEmployeeResp() {
        return new AddEmployeeResp();
    }

    /**
     * Create an instance of {@link SearchEmployeeReq }
     * 
     */
    public SearchEmployeeReq createSearchEmployeeReq() {
        return new SearchEmployeeReq();
    }

    /**
     * Create an instance of {@link SearchEmployeeResp }
     * 
     */
    public SearchEmployeeResp createSearchEmployeeResp() {
        return new SearchEmployeeResp();
    }

    /**
     * Create an instance of {@link GetRoleListReq }
     * 
     */
    public GetRoleListReq createGetRoleListReq() {
        return new GetRoleListReq();
    }

    /**
     * Create an instance of {@link GetRoleListResp }
     * 
     */
    public GetRoleListResp createGetRoleListResp() {
        return new GetRoleListResp();
    }

}
