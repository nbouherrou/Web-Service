
package net.restfulwebservices.servicecontracts._2008._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import net.restfulwebservices.datacontracts._2008._01.GeoLocation;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AnalyseResult" type="{http://www.restfulwebservices.net/DataContracts/2008/01}GeoLocation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "analyseResult"
})
@XmlRootElement(name = "AnalyseResponse")
public class AnalyseResponse {

    @XmlElementRef(name = "AnalyseResult", namespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", type = JAXBElement.class, required = false)
    protected JAXBElement<GeoLocation> analyseResult;

    /**
     * Obtient la valeur de la propriété analyseResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GeoLocation }{@code >}
     *     
     */
    public JAXBElement<GeoLocation> getAnalyseResult() {
        return analyseResult;
    }

    /**
     * Définit la valeur de la propriété analyseResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GeoLocation }{@code >}
     *     
     */
    public void setAnalyseResult(JAXBElement<GeoLocation> value) {
        this.analyseResult = value;
    }

}
