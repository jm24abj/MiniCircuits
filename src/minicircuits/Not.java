package minicircuits;

public class Not extends Gate {
    
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