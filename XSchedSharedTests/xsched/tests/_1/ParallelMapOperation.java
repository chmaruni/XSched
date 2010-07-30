package xsched.tests._1;
import java.util.Vector;
import xsched.Activation;

public class ParallelMapOperation {
	Vector<Object> out;
    
    public Object process(Object data) {
        return new Object();
    }
    public void write(Activation<Object> processActivation) {
        out.add(processActivation.result()); 
    }    
    public void writeToOut(Vector<Object> input) {
        Activation<Object> lastProcess = Activation.now();
        Activation<Void> lastWrite = Activation.now();
        
        for(Object data : input) {
            Activation<Object> process = Activation.after(this, "process", data);
            Activation<Void> write = Activation.after(this, "write", process);
    
            lastProcess.hb(process);
            process.hb(write);
            lastWrite.hb(write);
            
            lastProcess = process;
            lastWrite = write;
        }
    }
}
