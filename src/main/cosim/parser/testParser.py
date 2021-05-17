import sys,os
from antlr4 import *
from antlr4.error.ErrorListener import ConsoleErrorListener,ErrorListener
if not './main/cosim/parser/' in sys.path:
    sys.path.append('./main/cosim/parser/')
if os.path.isdir('../target/main/cosim/parser') and not '../target/main/cosim/parser/' in sys.path:
    sys.path.append('../target/main/cosim/parser/')
from cosimLexer import cosimLexer
from cosimParser import cosimParser
from lexererr import *
Lexer = cosimLexer
Parser=cosimParser
class NewErrorListener(ConsoleErrorListener):
    INSTANCE = None
    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        raise SyntaxException("Error on line "+ str(line) + " col " + str(column)+ ": " + offendingSymbol.text)
NewErrorListener.INSTANCE = NewErrorListener()

class SyntaxException(Exception):
    def __init__(self,msg):
        self.message = msg
def createErrorListener():
         return NewErrorListener.INSTANCE
def test():
    filename = "./testFile/parser.txt"
    content=open("./testFile/parser.txt", "r").read()
    file = open(filename,"w")
    file.write(content)
    file.close()
    input=FileStream(filename)
    dest = open("./testFile/resultParser.txt","w")
    lexer = Lexer(input)
    listener =createErrorListener()
    tokens = CommonTokenStream(lexer)
    parser = Parser(tokens)
    parser.removeErrorListeners()
    parser.addErrorListener(listener)
    try:
        parser.program()
        dest.write("successful")
    except SyntaxException as f:
        dest.write(f.message)
    except Exception as e:
        dest.write(str(e))
    finally:
        dest.close()
if __name__ == "__main__":
    test()