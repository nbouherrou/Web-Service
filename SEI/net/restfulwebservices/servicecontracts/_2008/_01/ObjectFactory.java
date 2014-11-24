
package net.restfulwebservices.servicecontracts._2008._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.restfulwebservices.datacontracts._2008._01.GeoLocation;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.restfulwebservices.servicecontracts._2008._01 package. 
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

    private final static QName _AnalyseRequest_QNAME = new QName("http://www.restfulwebservices.net/ServiceContracts/2008/01", "request");
    private final static QName _AnalyseResponseAnalyseResult_QNAME = new QName("http://www.restfulwebservices.net/ServiceContracts/2008/01", "AnalyseResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.restfulwebservices.servicecontracts._2008._01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Analyse }
     * 
     */
    public Analyse createAnalyse() {
        return new Analyse();
    }

    /**
     * Create an instance of {@link AnalyseResponse }
     * 
     */
    public AnalyseResponse createAnalyseResponse() {
        return new AnalyseResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", name = "request", scope = Analyse.class)
    public JAXBElement<String> createAnalyseRequest(String value) {
        return new JAXBElement<String>(_AnalyseRequest_QNAME, String.class, Analyse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", name = "AnalyseResult", scope = AnalyseResponse.class)
    public JAXBElement<GeoLocation> createAnalyseResponseAnalyseResult(GeoLocation value) {
        return new JAXBElement<GeoLocation>(_AnalyseResponseAnalyseResult_QNAME, GeoLocation.class, AnalyseResponse.class, value);
    }

}
