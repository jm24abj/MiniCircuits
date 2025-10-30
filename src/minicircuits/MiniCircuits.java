
package minicircuits;


class Gate {
    
    boolean on;
    String name;
    
    Gate[] inputs;
    Gate[] outputs;
    
    public Gate(String name,int numOfInputs,int numOfOutputs) {
        this.on = true;
        this.name = name;
        inputs = new Gate[numOfInputs];
        outputs = new Gate[numOfOutputs];
    }

    public boolean generateOutput() {
        return false;
    }
    
    public void addGate(Gate newGate) {
        for (int i = 0; i < this.inputs.length; i++) {
            if (this.inputs[i] == null) {
                this.inputs[i] = newGate;
                System.out.println("Gate added");
                break;
            }
        }
    }
    
    @Override public String toString(){
        return "-------------------------\nGate Name: " + this.name 
                + "\nPower status: " + this.on 
                + "\nInputs: " + this.inputs.length
                + "\nOutputs: " + this.outputs.length
                + "\n-------------------------\n";
    }
}

class AndGate extends Gate {
    
    public AndGate(int numOfInputs,int numOfOutputs) {
        super("And",numOfInputs,numOfOutputs);
    }
    
    @Override public boolean generateOutput() {
        
        boolean output = true;
        
        for (int i = 0; i < super.inputs.length; i++) {
            Gate currentGate = super.inputs[i];
            
            if (currentGate != null) {
                output = output && currentGate.on;
            } else {
                System.out.println("empty input");
                break;
            }
        }
        
        return output;
    }
}
public class MiniCircuits {
    
    public static void main(String[] args) {
        
        AndGate andGate = new AndGate(0,0);
        AndGate andGate2 = new AndGate(0,0);
        AndGate andGate3 = new AndGate(0,0);  
        AndGate andGate4 = new AndGate(3,3);
        
        andGate4.addGate(andGate);
        andGate4.addGate(andGate2);
        andGate4.addGate(andGate3);
        
        System.out.println(andGate4.generateOutput());
    }
}
