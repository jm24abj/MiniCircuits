package miniui;
import minicircuits.*;

public class CircuitFile {
    
    /*String[] categories = {"Core","Common","Custom","Misc"};
    String[] basicCompList = {"AND","OR","NOT","NAND","XOR","XNOR"};
    String[] commonCompList = {"ADDER","SUBTRACTOR","SPLITTER","MEMORY"};
    String[] miscCompList = {"LED","PROBE"};*/
        
    
    public void insertComponent(String id) {
        
        // checking for core components
        
        switch (id) { 
            case "AND":
                And andGate = new And(0,0,false);
                System.out.println(andGate.toString());
                break;
            case "OR":
                break;
            case "NOT":
                break;
            case "NAND":
                break;
            case "XOR":
                break;
            case "XNOR":
                break;
        }
        
        // checking for common components
        
        switch (id) { 
            case "ADDER":
                break;
            case "SUBTRACTOR":
                break;
            case "SPLITTER":
                break;
            case "MEMORY":
                break;
        }
        
        // checking for misc
        
        switch (id) { 
            case "MISC":
                break;
            case "PROBE":
                break;
        }
    }
}
