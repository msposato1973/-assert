# -assert
Terms of the Exercise:

- The purpose is to save both candidates and ourselves from wasting time in interviews - it is therefore not in your interest to cheat. 
- You can take as long as you like to complete the exercise, but for an indicative timescale we expect a senior developer can accomplish this in 1 or 2 hours. 
- You may use Google etc. to assist you with specific techniques, syntax etc. but please don't just copy somebody else's solution. 
- DO NOT share this exercise with any third party - this will undermine the use of the exercise with future candidates. 

Instructions:

The aim of the exercise is to demonstrate your understanding of Java objects by implementing something found in every unit testing tool - an "assertEquals" method.

- Build the project using Maven using the included pom file, this will also run the unit tests. (You're also free to use other build tools if you wish)
- Initially we are EXPECTING all of the tests to fail, so the overall build will also fail
- These tests are there to verify your implementation can correctly detect the differences between two Objects - in a fully completed exercise, all of the tests should pass.
- Fill in the "assertEquals" method in the "Assertions" class so that it will correctly find the differences for each of the unit tests. 
- In the case that two objects are different, you will need to update the test (in AssertionsTest) with your failure message to get the test to pass  
- The output messages must be clear enough to show the correct result has been found, although the exact text doesn't matter it should clearly identify what is different, examples:
- - Expected '1' but found 1
- - Expected type Hashmap but found type Array
- - Expected Array length 4 but found Array length 5
- - Expected Array[2] = 3 but found Array[2] = '3'
- - Expected "Item1.1" = 0 but found "Item1.1" = '0'
- When an object is different, the output message needs to state what was different. 
- To fail an assertion call the "fail" method already contained within the "Assertions" class.
- You may add more methods if necessary. 
- Nested Objects within the Objects must also be compared to ensure these methods can report the differences. 
- Please avoid the use of the Array.equals() and Arrays.deepEquals() Java system methods.
- Your code should respect the coding style found in the existing code; pay attention to spaces and naming conventions. 
- Credit will be given for correctly identifying the differences, "clean" code and coding style. 

Once you have completed the exercise send it back to together with a note on how long you spent on it.
