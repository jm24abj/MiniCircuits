package minicircuits;

public class Nand extends Gate {
    
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
