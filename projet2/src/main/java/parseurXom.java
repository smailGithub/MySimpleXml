

import java.io.File;
import java.io.IOException;
import java.io.*;
import com.sun.istack.internal.Builder;
import com.sun.xml.internal.txw2.Document;

import nu.xom.*;

public class parseurXom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			    if (args.length == 0) {
			      System.out.println("Usage: java nu.xom.samples.NodeLister URL");
			      return;
			    } 
			      
			    Builder builder = new Builder();
			     
			    try {
			      File file=new File("/hom/etu5/GitrepositorieMaven/gitMaven/projet2/book.xml");
			      Document doc = builder.build();
			      Element root = doc.getRootElement();
			      listChildren(root, 0);      
			    }
			    // indicates a well-formedness error
			    catch (ParsingException ex) { 
			      System.out.println(args[0] + " is not well-formed.");
			      System.out.println(ex.getMessage());
			    }  
			    catch (IOException ex) { 
			      System.out.println(ex);
			    }  
			  
			  }
			  
			  public static void listChildren(Node current, int depth) {
			   
			    printSpaces(depth);
			    String data = "";
			    if (current instanceof Element) {
			        Element temp = (Element) current;
			        data = ": " + temp.getQualifiedName();   
			    }
			    else if (current instanceof ProcessingInstruction) {
			        ProcessingInstruction temp = (ProcessingInstruction) current;
			        data = ": " + temp.getTarget();   
			    }
			    else if (current instanceof DocType) {
			        DocType temp = (DocType) current;
			        data = ": " + temp.getRootElementName();   
			    }
			    else if (current instanceof Text || current instanceof Comment) {
			        String value = current.getValue();
			        value = value.replace('\n', ' ').trim();
			        if (value.length() <= 20) data = ": " + value;
			        else data = ": " + current.getValue().substring(0, 17) + "...";   
			    }
			    // Attributes are never returned by getChild()
			    System.out.println(current.getClass().getName() + data);
			    for (int i = 0; i < current.getChildCount(); i++) {
			      listChildren(current.getChild(i), depth+1);
			    }
			    
			  }
			  
			  private static void printSpaces(int n) {
			    
			    for (int i = 0; i < n; i++) {
			      System.out.print(' '); 
			    }
			    
			  }

}
