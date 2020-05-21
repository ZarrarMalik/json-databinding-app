package zarrar.malik.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="xml")
@XmlType(propOrder={"name4", "name2", "name","name3"})
public class XmlData {
    
    @XmlElement(name ="name")
    private String property1;
    
    @XmlElement(name ="name2")
    private String property2;
    
    @XmlTransient
    private String property3;
    
    @XmlElement(name ="name4")
    private String property4;
    
    @XmlAttribute(name ="attribute")
    private String attribute1;
    private String attribute2;
    public String getProperty1() {
        return property1;
    }
    public void setProperty1(String property1) {
        this.property1 = property1;
    }
    public String getProperty2() {
        return property2;
    }
    public void setProperty2(String property2) {
        this.property2 = property2;
    }
    public String getAttribute1() {
        return attribute1;
    }
    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }
    public String getAttribute2() {
        return attribute2;
    }
    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }
    public String getProperty3() {
        return property3;
    }
    public void setProperty3(String property3) {
        this.property3 = property3;
    }
    public String getProperty4() {
        return property4;
    }
    public void setProperty4(String property4) {
        this.property4 = property4;
    }

}
