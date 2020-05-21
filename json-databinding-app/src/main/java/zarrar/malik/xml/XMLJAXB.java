package zarrar.malik.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

public class XMLJAXB {

    public static void main(String[] args) throws JsonProcessingException {
       XmlMapper xmlMapper = new XmlMapper();
       xmlMapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector(xmlMapper.getTypeFactory()));
       
      //can use 2nd way as well:  xmlMapper.registerModule(new JaxbAnnotationModule());
       
      System.out.println(xmlMapper.writeValueAsString(new XmlData()));

      XmlData xml = xmlMapper.readValue("<xml attribute=\"attribute value\"><name>tuna tore</name><name2/><name4/></xml>", XmlData.class);
      
      System.out.println("attribute: " + xml.getAttribute1());
      System.out.println("property1: " + xml.getProperty1());
      System.out.println("property2: " + xml.getProperty2());     
      System.out.println("property4: " + xml.getProperty4());
    }

}
