
package faultcontracts.gotlservices._2008._01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour DefaultFaultContract complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="DefaultFaultContract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CorrelationId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DefaultFaultContract", propOrder = {
    "errorId",
    "errorMessage",
    "correlationId"
})
public class DefaultFaultContract {

    @XmlElement(name = "ErrorId")
    protected int errorId;
    @XmlElement(name = "ErrorMessage", required = true, nillable = true)
    protected String errorMessage;
    @XmlElement(name = "CorrelationId", required = true)
    protected String correlationId;

    /**
     * Obtient la valeur de la propriété errorId.
     * 
     */
    public int getErrorId() {
        return errorId;
    }

    /**
     * Définit la valeur de la propriété errorId.
     * 
     */
    public void setErrorId(int value) {
        this.errorId = value;
    }

    /**
     * Obtient la valeur de la propriété errorMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Définit la valeur de la propriété errorMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Obtient la valeur de la propriété correlationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Définit la valeur de la propriété correlationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

}
