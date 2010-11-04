package xsched.analysis.test_benchmarks;

import xsched.analysis.ScheduleAnalysis;
import xsched.analysis.db.Cheater;
import junit.framework.TestCase;


public class RunJGFMontecarlo extends TestCase {

	public void testJGFMontecarlo() {
		Cheater cheater = new TestCheater();
		ScheduleAnalysis analysis = new ScheduleAnalysis();
		analysis.runScheduleAnalysis("bin/jgfmt", "analysis.out", cheater);
	}
}