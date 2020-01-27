# Software Engineering
## Name: Aditya Mohan Gupta Roll No: 2019201047

## 1. Outline :
This JAVA program takes input a schema of characters and the corresponding command line argument string which contains the respective character values.

## 2. Program Structure and Description of classes :
- ArgsMain.java : The schema and command line arguments are passed to Args Class to check the values that is set for the corresponding character.
- Args.java : This class supports operations for three other classes and their functionalities. The functionalities are as follows :\
                1. To parse the given schema and populating the map with the different character values.\
                2. Parsing the user input to set different variable values.\
                3. To find the the values of different variables and check whether it is set or not.
- ParseSchema.java : 1. Population of map, Schema is split and each character is associated with corresponding                                       ArgumentMarshaler class.\
                     2. returns populated Map to Args.java.
- ParseArgument.java :1. It populates the Map with character and its respective datatype objects defined by given schema.\
                      2. returns this map to Args.java. 
- BooleanArgumentMarshaler : If Character present value=true else false.
- IntegerArgumentMarshaler : Intitalizes the Integer corresponding to character passed.
- DoubleArgumentMarshaler : Intitalizes the Double corresponding to character passed.
- StringArgumentMarshaler : Intitalizes the String corresponding to character passed.
- StringArrayArgumentMarshaler : Intitalizes Multiplte Strings corresponding to character passed as Array.
- MapArgumentMarshaler : Intitalizes String Map corresponding to character passed.

## 3. Schema Description : 
Schema: f,s*,a##,n#,p[\*]

Schema description :
 - char    - Boolean arg
 - char*   - String arg
 - char#   - Integer arg
 - char##  - double arg
 - char[\*] - one element of a string array
 
Command Line Argument: -f -s apple -n 12 -a 42.5 -p abc -p fgh

## 4. Implemented features
- Exception handling
- User Input Dynamic Processing
- Inheritance                    
- Code Modularity
- Interface Overriding
- Classes with default Constructor

## 5. Clean code attributes included
 
   1. Clear understanding of the code with proper flow.
   2. Reusability of Code : Naming convention is done which gives understanding of the functionality and used single word per       module.
   3. Modularity: Short sized methods and classes to enhance modularity.Methods with atmost 3 arguments performing single           task and also maintained low level of Nesting in code. 
   4. Naming Convention: Proper naming of classes, methods and variables have been done to facilitate easy understanding of         the the code.
   5. Commenting : Comments used only where required.
   6. Less Code Redundancy : Writing code in functions and classes.
   7. Access Specifiers : public, private, protected for security of data.
   8. Error Handling : Throwing exceptions is better than returning different codes dependent on errors.
