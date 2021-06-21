import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class Tests {	

	public static void main(String[] args) throws Throwable {
    for (int i = 1; i <= 6; ++i) {      
      Class<?> clazz = Class.forName("Tests");
      Method method = clazz.getMethod("TestTree" + i);
      method.invoke(null);
    }
	}
  
  
  public static void TestTree1() {
    Node n = new Node(1, null, new Node(20));
    n.display();
  }
  
  public static void TestTree2() {
    Node n = 
      new Node(1, 
               new Node(2, 
                        new Node(4), 
                        new Node(5)
               ), 
               new Node(3, 
                        new Node(6), 
                        new Node(70)
               )
      );
    n.display();
  }  
  
  public static void TestTree3() {
    Node n = 
      new Node(1, 
      null, 
      new Node(3, 
        new Node(2), 
        new Node(7)
      )
      );
    n.display();
  }    
  
  public static void TestTree4() {
		Node n = 
      new Node(101, 
        new Node(22, 
          new Node(40, 
            new Node(8321), 
            new Node(922224)
          ), 
          new Node(5, 
            new Node(224), 
            new Node(3, 
              new Node(22), 
              new Node(43, 
                new Node(22), 
                new Node(43)
              )
            )
          )
        ), 
        new Node(321209, 
          new Node(6109, 
            new Node(82367, 
              new Node(20), 
              new Node(13)
            ), 
            new Node(9097)
          ), 
          new Node(709)
        )
    );
    n.display();
  }      
  
  public static void TestTree5() {
    Node n = 
      new Node(14894,
        new Node (265,
          new Node (4111, 
              new Node (1444),
              new Node (5232)
          ),
          new Node (3112,
              new Node (8112,
                  new Node (755),
                  new Node (96)
              ),
              new Node(6456))),
        new Node(844,
           new Node (12),
           new Node (1756)
        )
    );	
    n.display();         
  }  
  
  public static void TestTree6() {
    Node n = 
      new Node(101, 
        new Node(22, 
          new Node(40, 
            new Node(8321), 
            new Node(922224)
          ), 
          new Node(5, 
            new Node(224), 
            new Node(3, 
              new Node(22), 
              new Node(43, 
                new Node(22), 
                new Node(43)
              )
            )
          )
        ), 
        new Node(321209, 
          new Node(6109, 
            new Node(82367, 
              new Node(20), 
              new Node(13)
            ), 
            new Node(9097)
          ), 
          new Node(709)
        )
      );	
    n.display();         
  }    
}