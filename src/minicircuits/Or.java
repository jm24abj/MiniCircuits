package minicircuits;

public class Or extends Gate {
    
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
