package xsched.tests._1;

import org.junit.Assert;

import xsched.Activation;

public class SimpleConditional {
	
	public boolean firstTask() {
		return true;
	}
	
	public boolean secondTask() {
		return false;
	}
	
	public void finalTask(Activation<Boolean> a, Activation<String> b) {
		Assert.assertTrue(a.result().booleanValue());
		Assert.assertTrue(b.result().equals("howdy"));		
	}
	
	public void main() {
		
		Activation<Boolean> a;
		if(Math.random() > 0.5)
			a = Activation.schedule(this, "firstTask");
		else
			a = Activation.schedule(this, "secondTask");
		
		System.out.println(a);
	}
}
