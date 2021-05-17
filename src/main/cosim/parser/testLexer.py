import sys,os
from antlr4 import *
from antlr4.error.ErrorListener import ConsoleErrorListener,ErrorListener
if not './main/cosim/parser/' in sys.path:
    sys.path.append('./main/cosim/parser/')
if os.path.isdir('../target/main/cosim/parser') and not '../target/main/cosim/parser/' in sys.path:
    sys.path.append('../target/main/cosim/parser/')
from cosimLexer import cosimLexer
from lexererr import *
Lexer = cosimLexer
def test():
    filename = "./testFile/lexer.txt"
    content=open("./testFile/lexer.txt", "r").read()
    file = open(filename,"w")
    file.write(content)
    file.close()
    input=FileStream(filename)


    dest = open("./testFile/resultLexer.txt","w")

    lexer = Lexer(input)
    try:
        printLexeme(dest,lexer)
    except (ErrorToken,UncloseString,IllegalEscape) as err:
        dest.write(err.message)
    finally:
        dest.close() 

def printLexeme(dest,lexer):
    tok = lexer.nextToken()
    if tok.type != Token.EOF:
        dest.write(tok.text+",")
        printLexeme(dest,lexer)
    else:
        dest.write("<EOF>") 
if __name__ == "__main__":
    test()