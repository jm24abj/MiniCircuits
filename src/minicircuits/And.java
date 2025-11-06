package minicircuits;

public class And extends Gate {
    
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