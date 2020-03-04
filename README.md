# rainwatertrap
This is a "trap rain water calculator", pass the inputs and it return the correct rain water trapped!

## business
To make the rain water trap i choose the following decision/assumpion:
  - if pass none params 0 is returned (no errors)
  - if pass 1 element 0 is returned
  - max block height is 5

## development
Rain water trap is developed in Java and Junit framework to test business class.

The project have a Trap class to calculate the rain water having in input an array of non-negative int.

Main class invoke the service class passing the sequence of borders, the class returns the value of water trapper and print to the console.
It is not imported any java utility libraries. Only maven is used to import junit dependency and runs the unit tests.

## testing
To test the rainwatertrap:
 - clone the repository with command ```git clone https://github.com/rinaudosal/rainwatertrap.git ```
 - ```cd rainwatertrap``` to pass into sub-folder of project
 - run command with your preferred values of building blocks ```java -cp rainwatertrap-1.0.jar com.rinaudo.rainwatertrap.RainWaterExecutor 3 1 3 ```

That's all!


  
  


