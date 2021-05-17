# assignment_ppl
# SETUP FOR PROJECT<br/>
-Install Python environment<br/>
-Install Java JDK
-Go to https://www.antlr.org/ to dowload file antlr.jar<br/>
-In your D disk you create a folder named antlr and move file just dowloaded into this folder<br/>
-In antlr folder you create 3 files named antlr.bat;class.bat;grun.bat and content in each file is :<br/>
  +java org.antlr.v4.Tool %*<br/>
  +SET CLASSPATH=.;D:\antlr\antlr-4.9.1-complete.jar<br/>
  +java org.antlr.v4.gui.TestRig %*<br/>
-Add environtment variable for antlr:<br/>
![image](https://user-images.githubusercontent.com/53758183/118515455-9c7ac600-b75f-11eb-9b80-d51a1cc11bd4.png)<br/>
-Add file antlr you douwloaded and java jdk bin file to CLASSPATH variable:<br/>
![image](https://user-images.githubusercontent.com/53758183/118516086-32aeec00-b760-11eb-940b-a4acc7a7721d.png)<br/>
-Add folder antlr and CLASSPATH to PATH variable:<br/>
![image](https://user-images.githubusercontent.com/53758183/118516426-802b5900-b760-11eb-8a06-1e43d8b927f1.png)<br/>
-Download graphviz.zip and take folder bin and located it in D:\anhkiet\graphviz\Graphviz<br/>
![image](https://user-images.githubusercontent.com/53758183/118517445-68a0a000-b761-11eb-828b-bbdf805c4a80.png)<br/>
# Go to folder src of project use pip install antlr4-python3-runtime to install antlr runtime for python
Use py run.py gen to test status of project
# Test Scanner and Parser
Go to main\cosim\parser folder testFile have 4 files lexer.txt resultLexer.txt parser.txt resultParser.txt , you can update for lexer.txt and parser.txt <br/>
Use py testLexer.py to take scanner result form file lexer.txt and result will be writtern to resultLexer.txt<br\>
Use py testParser.py to take parser result form file parser.txt and result will be writtern to resulParser.txt<br\>
# Draw parse tree
Go to parsetre, in folder test have file 1.txt we can see it as input file type ./exe.sh 1 to visualize parse tree of 1.txt<br/>
# Draw AST
Type py visualizeAST.py it will visualize AST from testAst.txt<br/>
# Draw Symboltable
Go to symboltable type java CheckSymbols to visualize symboltable from kiet.cosim


