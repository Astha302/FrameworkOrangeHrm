package testscript;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public  class RetryAnalyzerr implements IRetryAnalyzer {
	
	private int retryCount = 0;
    private int maxRetryCount = 2;  // retry 2 times
 
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;   // retry test
        }
 
        return false;      // stop retryi
}
}