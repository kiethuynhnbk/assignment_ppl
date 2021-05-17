echo "Converting ANTLR target from Python to Java"

#node "../scripts/py2java.js"


echo "Searching ANTLR files"

alias antlr='java org.antlr.v4.Tool'

alias grun='java org.antlr.v4.gui.TestRig'

export ANTLR_LIB="D:\antlr\antlr-4.9.1-complete.jar"

export CLASSPATH=".;D:\antlr\antlr-4.9.1-complete.jar"

SET CLASSPATH=.;D:\antlr\antlr-4.9.1-complete.jar
echo "Generating ANTLR to Java Code"

antlr cosim.g4


echo "Generating Java Class files"

javac cosim*.java


echo "Drawing Parse Tree"
grun cosim program -f ./test/$1.txt

grun cosim program -f ./test/$1.txt -gui