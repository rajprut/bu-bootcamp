# BU CS Foundations Bootcamp
 
Prior to the masters program, this repository contains my work for the Boston University
Online AI Programs CS Foundations Bootcamp.

There are 7 modules for the bootcamp.
 
## Structure
- module1/ : Development environment and first Java programs(Hello World)
- module2/ : Programming fundamentals (variables, control flow, methods, files)
- module3/ : Data structures and object-oriented basics
 
## Programs
Each module folder contains the Java source files from that module’s activity. Some screenshots and additional activities prior to the final module assignment is also included.

## JUnit

For module 2 what was needed to compile and run tests:

To compile: javac -cp ".;lib/junit-platform-console-standalone-6.1.3.jar" module2/GradeAnalyzer.java module2/GradeAnalyzerTest.java

To Run and pass tests: java -jar lib/junit-platform-console-standalone-6.1.3.jar execute --class-path "module2" --select-class GradeAnalyzerTest
