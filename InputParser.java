/**
Insert(68,40,51)
GetNextRide()
Print(1,100)
UpdateTrip(53,15)
 */
public class InputParser {
    public static TestCase getParsedTestCase(final String testCaseStr) {
        // Create a new TestCase object
        final TestCase testCase = new TestCase();
        // Set the test command for the TestCase object
        testCase.setTestCommand(getTestCommand(testCaseStr));

        // Perform different actions based on the test command
        switch (testCase.getTestCommand()) {
            case INSERT:
                // For INSERT command, set ride number, ride cost, and trip duration
                testCase.setRideNumber(getNumber(testCaseStr, "(", ","));
                String rideCostStr = testCaseStr.substring(testCaseStr.indexOf(","));
                // Parse the ride cost from the input string
                testCase.setrideCost(Integer.parseInt(rideCostStr.substring(rideCostStr.indexOf(",") + 1, rideCostStr.substring(1).indexOf(",")+1)));
                String tripTimeStr = rideCostStr.substring(1);
                // Set the trip duration for the TestCase object
                testCase.setTripDuration(getNumber(tripTimeStr, ",", ")"));
                break;
            case PRINT:
                // For PRINT command, set start ride number
                testCase.setStartRideNumber(getNumber(testCaseStr, "(", ")"));
                break;
            case GETNEXTRIDE:
                // No action needed for GETNEXTRIDE command
                break;
            case PRINTBTW:
                // For PRINTBTW command, set start and end ride numbers
                testCase.setStartRideNumber(getNumber(testCaseStr, "(", ","));
                testCase.setEndRideNumber(getNumber(testCaseStr, ",", ")"));
                break;
            case CANCEL:
                // For CANCEL command, set ride number
                testCase.setRideNumber(getNumber(testCaseStr, "(", ")"));
                break;
            case UPDATE:
                // For UPDATE command, set ride number and trip duration
                testCase.setRideNumber(getNumber(testCaseStr, "(", ","));
                testCase.setTripDuration(getNumber(testCaseStr, ",", ")"));
                break;
        }

        // Return the parsed TestCase object
        return testCase;
    }

    // Helper method to get the TestCommand enum from the input string
    private static TestCommand getTestCommand(final String testCaseStr) {
        return testCaseStr.startsWith("I") ? TestCommand.INSERT :
                (testCaseStr.startsWith("G") ? TestCommand.GETNEXTRIDE :
                        (testCaseStr.startsWith("U") ? TestCommand.UPDATE :
                                (testCaseStr.startsWith("C") ? TestCommand.CANCEL : (testCaseStr.contains(",") ? TestCommand.PRINTBTW : TestCommand.PRINT))));
    }

    // Helper method to get the integer value from the input string
    private static int getNumber(final String testCaseStr, final String separator1, final String separator2) {
        return Integer.parseInt(testCaseStr.substring(testCaseStr.indexOf(separator1) + 1, testCaseStr.indexOf(separator2)));
    }
}
