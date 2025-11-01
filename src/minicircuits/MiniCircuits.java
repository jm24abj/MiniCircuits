
package minicircuits;

public class MiniCircuits {
    
    public static void testData() {
        And andGate = new And(0,0,false);
        And andGate2 = new And(0,0,false);
        And  andGate3 = new And(0,0,true);  
        And andGate4 = new And(3,3,false);
        
        Or OrGate1 = new Or(0,0,true);
        Or OrGate2 = new Or(0,0,false);
        Or OrGate3 = new Or(0,0,false);  
        Or OrGate4 = new Or(3,3,false);
        
        andGate4.addGate(andGate);
        andGate4.addGate(andGate2);
        andGate4.addGate(andGate3);
        
        OrGate4.addGate(OrGate1);
        OrGate4.addGate(OrGate2);
        OrGate4.addGate(OrGate3);
        
        Not newNot = new Not(false);
        newNot.addGate(OrGate2);
        
        Xor xorTest = new Xor(3,1,false);
        xorTest.addGate(OrGate1);
        xorTest.addGate(OrGate1);
        xorTest.addGate(OrGate1);
        
        System.out.println("---NOT GATE---");
        System.out.println(newNot.generateOutput());
        System.out.println("---AND GATE---");
        System.out.println(andGate4.generateOutput());
        System.out.println("---OR GATE---");
        System.out.println(OrGate4.generateOutput());
        System.out.println("---XOR GATE---");
        System.out.println(xorTest.generateOutput());
    }
    
    public static void main(String[] args) {    
        testData();
    }
}
