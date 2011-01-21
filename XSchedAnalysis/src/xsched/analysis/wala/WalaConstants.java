package xsched.analysis.wala;

import com.ibm.wala.ssa.SSAInvokeInstruction;
import com.ibm.wala.ssa.SSANewInstruction;
import com.ibm.wala.types.ClassLoaderReference;
import com.ibm.wala.types.MethodReference;
import com.ibm.wala.types.Selector;
import com.ibm.wala.types.TypeReference;

public final class WalaConstants {
			
	private static final TypeReference TaskType = TypeReference.findOrCreate(ClassLoaderReference.Application, "Lxsched/Task");
	//private static final String HappensBeforeSignature = "xsched.Task.hb(Lxsched/Task;)V";
	private static final Selector HappensBeforeSelector = Selector.make("hb(Lxsched/Task;)V");	
	private static final MethodReference HappensBeforeMethod = MethodReference.findOrCreate(TaskType, HappensBeforeSelector);
	
	public static boolean isHappensBeforeCall(SSAInvokeInstruction instruction) {
		return instruction.getDeclaredTarget().equals(WalaConstants.HappensBeforeMethod);
	}
	
	public static boolean isNewTaskSite(SSANewInstruction instruction) {
		return instruction.getConcreteType().equals(TaskType);
	}
	
	public static boolean isTaskMethod(MethodReference reference) {
		String name = reference.getName().toString();
		if(name.startsWith("xschedTask_")) {
			assert reference.getReturnType().equals(TypeReference.Void);
			assert reference.getNumberOfParameters() > 0;
			assert reference.getParameterType(0).equals(TaskType);
			return true;
		} else {
			return false;
		}
	}
}
