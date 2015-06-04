(60 * 60 * 24 * 365).toString();         // invalid Java

int secondsPerYear = 60 * 60 * 24 * 365;
secondsPerYear.toString();               // invalid Java

new Integer(secondsPerYear).toString();

assert "abc" - "a" == "bc"               // invalid Java