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


class And extends Gate {
    
    public And(int numOfInputs,int numOfOutputs,boolean defaultPower) {
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

class Nand extends Gate {
    
    public Nand(int numOfInputs,int numOfOutputs,boolean defaultPower) {
        super(GateTypes.NAND,numOfInputs,numOfOutputs,defaultPower);
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
        
        return !output;
    }
}

class Or extends Gate {
    
    public Or(int numOfInputs,int numOfOutputs,boolean defaultPower) {
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

class Xor extends Gate {
    
    public Xor(int numOfInputs,int numOfOutputs,boolean defaultPower) {
        super(GateTypes.XOR,numOfInputs,numOfOutputs,defaultPower);
    }
    
    @Override public boolean generateOutput() {
        boolean isOr = false;
        boolean isAnd = true;
        for (int i = 0; i < super.inputs.length; i++) {
            Gate currentGate = super.inputs[i];
            if (currentGate != null) { isAnd = isAnd && currentGate.on; }
            if (currentGate.on) { isOr = true; }
        }
        return isOr && !isAnd;
    }
}

class Xnor extends Gate {
    
    public Xnor(int numOfInputs,int numOfOutputs,boolean defaultPower) {
        super(GateTypes.XOR,numOfInputs,numOfOutputs,defaultPower);
    }
    
    @Override public boolean generateOutput() {
        boolean isOr = false;
        boolean isAnd = true;
        for (int i = 0; i < super.inputs.length; i++) {
            Gate currentGate = super.inputs[i];
            if (currentGate != null) { isAnd = isAnd && currentGate.on; }
            if (currentGate.on) { isOr = true; }
        }
        return !(isOr && !isAnd);
    }
}


class Not extends Gate {
    
    public Not(boolean defaultPower) {
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
