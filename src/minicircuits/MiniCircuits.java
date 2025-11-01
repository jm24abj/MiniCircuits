
package minicircuits;

public class MiniCircuits {
    
    public static void testData() {
        AndGate andGate = new AndGate(0,0,false);
        AndGate andGate2 = new AndGate(0,0,false);
        AndGate andGate3 = new AndGate(0,0,true);  
        AndGate andGate4 = new AndGate(3,3,false);
        
        OrGate OrGate1 = new OrGate(0,0,true);
        OrGate OrGate2 = new OrGate(0,0,false);
        OrGate OrGate3 = new OrGate(0,0,false);  
        OrGate OrGate4 = new OrGate(3,3,false);
        
        andGate4.addGate(andGate);
        andGate4.addGate(andGate2);
        andGate4.addGate(andGate3);
        
        OrGate4.addGate(OrGate1);
        OrGate4.addGate(OrGate2);
        OrGate4.addGate(OrGate3);
        
        NotGate newNot = new NotGate(false);
        newNot.addGate(OrGate2);
        
        System.out.println("---NOT GATE---");
        System.out.println(newNot.generateOutput());
        System.out.println("---AND GATE---");
        System.out.println(andGate4.generateOutput());
        System.out.println("---OR GATE---");
        System.out.println(OrGate4.generateOutput());
    }
    
    public static void main(String[] args) {    
        testData();
    }
}
