
import nu.xom.*;
public class parseurXom2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   
		    Element root = new Element("root");    
		    root.appendChild("Correction bug test !");
		    Document doc = new Document(root);
		    String result = doc.toXML();
		    System.out.println(result);
		    
		  }


}