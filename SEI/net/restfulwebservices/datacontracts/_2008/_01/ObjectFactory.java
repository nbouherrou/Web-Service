
package net.restfulwebservices.datacontracts._2008._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.restfulwebservices.datacontracts._2008._01 package. 
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

    private final static QName _GeoLocation_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "GeoLocation");
    private final static QName _GeoLocationRegistry_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Registry");
    private final static QName _GeoLocationCountry_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Country");
    private final static QName _GeoLocationCountryCode_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "CountryCode");
    private final static QName _GeoLocationAssigned_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Assigned");
    private final static QName _GeoLocationISOCountryCode_QNAME = new QName("http://www.restfulwebservices.net/DataContracts/2008/01", "ISOCountryCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.restfulwebservices.datacontracts._2008._01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GeoLocation }
     * 
     */
    public GeoLocation createGeoLocation() {
        return new GeoLocation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "GeoLocation")
    public JAXBElement<GeoLocation> createGeoLocation(GeoLocation value) {
        return new JAXBElement<GeoLocation>(_GeoLocation_QNAME, GeoLocation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Registry", scope = GeoLocation.class)
    public JAXBElement<String> createGeoLocationRegistry(String value) {
        return new JAXBElement<String>(_GeoLocationRegistry_QNAME, String.class, GeoLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Country", scope = GeoLocation.class)
    public JAXBElement<String> createGeoLocationCountry(String value) {
        return new JAXBElement<String>(_GeoLocationCountry_QNAME, String.class, GeoLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "CountryCode", scope = GeoLocation.class)
    public JAXBElement<String> createGeoLocationCountryCode(String value) {
        return new JAXBElement<String>(_GeoLocationCountryCode_QNAME, String.class, GeoLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "Assigned", scope = GeoLocation.class)
    public JAXBElement<String> createGeoLocationAssigned(String value) {
        return new JAXBElement<String>(_GeoLocationAssigned_QNAME, String.class, GeoLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.restfulwebservices.net/DataContracts/2008/01", name = "ISOCountryCode", scope = GeoLocation.class)
    public JAXBElement<String> createGeoLocationISOCountryCode(String value) {
        return new JAXBElement<String>(_GeoLocationISOCountryCode_QNAME, String.class, GeoLocation.class, value);
    }

}
