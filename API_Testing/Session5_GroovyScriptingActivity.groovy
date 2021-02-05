	
//Declare objects
	
def testcase = testRunner.testCase
	
def testsuite = testRunner.testCase.testSuite
	
def project = testRunner.testCase.testSuite.project
	
 
	
//Get TestCase Label and print it
	
log.info testcase.getLabel()
	
//Get TestSuite Label and print it
	
log.info testsuite.getLabel()
	
//Get Project Label and print it
	
log.info project.name
	
 
	
//Controlling flow of TestSteps
	
for(i in 1..10)
	
{
	
    if(Math.random()*10 < 5.0) {
	
        testRunner.runTestStepByName("NumberToDollars - Request 1")
	
    } else {
	
        testRunner.runTestStepByName("NumberToWords - Request 1")
	
    }
	
}