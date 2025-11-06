package minicircuits;

public class Xor extends Gate {
    
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
