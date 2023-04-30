import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XMLReader {
    public static void main(String[] args) {

        try {
           File xmlFile=new File("sample.xml");
           DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
           DocumentBuilder db= dbf.newDocumentBuilder();
           Document doc=db.parse(xmlFile);
           doc.getDocumentElement().normalize();
            System.out.println("root element: "+doc.getDocumentElement().getNodeName());
            NodeList nodeList=doc.getElementsByTagName("book");
            for(int i=0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element element=(Element) node;
                    System.out.println("Book id: "+element.getAttribute("id"));
                    System.out.println("Author: "+element.getElementsByTagName("author").item(0).getTextContent());
                    System.out.println("Title: "+element.getElementsByTagName("title").item(0).getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}