package minicircuits;

/*     

    Gates included in this file 

    . AND
    . NAND
    . OR
    . XOR
    . XNOR
    . NOT 
     
*/

// 'Gate' is the super class that all of the basic gates inherit from

enum GateTypes {AND, NAND, OR, XOR, XNOR, NOT};

class Gate {
    
    boolean on; 
    GateTypes name;
    
    Gate[] inputs;
    Gate[] outputs;
    
    public Gate(GateTypes name,int numOfInputs,int numOfOutputs,boolean startPower) {
        this.on = startPower;
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
                //System.out.println("Gate added");
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

// ----------------------------------------------------------------------------


class AndGate extends Gate {
    
    public AndGate(int numOfInputs,int numOfOutputs,boolean defaultPower) {
        super(GateTypes.AND,numOfInputs,numOfOutputs,defaultPower);
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

class OrGate extends Gate {
    
    public OrGate(int numOfInputs,int numOfOutputs,boolean defaultPower) {
        super(GateTypes.OR,numOfInputs,numOfOutputs,defaultPower);
    }
    
    @Override public boolean generateOutput() {
        for (int i = 0; i < super.inputs.length; i++) {
            Gate currentGate = super.inputs[i];
            if (currentGate.on) { return true; }
        }
        return false;
    }
}

class NotGate extends Gate {
    
    public NotGate(boolean defaultPower) {
        super(GateTypes.NOT,1,1,defaultPower);
    }
    
    @Override public boolean generateOutput() {  
        if (super.inputs.length >= 1) { 
            return !super.inputs[0].on;
        }
        return false; // error
    }
}

public class BasicGates {
    
}
