package minicircuits;

public class Gate {
    
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
