import sys,os
sys.path.append('./test/')
sys.path.append('./main/cosim/parser/')
#sys.path.append('./main/mp/utils/')
#sys.path.append('./main/mp/astgen/')
import subprocess
import unittest
from antlr4 import *

ANTLR_JAR = os.environ.get('ANTLR_LIB')
TARGET_DIR = '../target'
GENERATE_DIR = 'main/cosim/parser'

def main(argv):
    if len(argv) < 1:
        printUsage()
    elif argv[0] == 'gen':
        subprocess.run(["java","-jar",ANTLR_JAR,"-o","../target","-no-listener","-visitor","main/cosim/parser/cosim.g4"])
        if not os.path.isdir(TARGET_DIR + "/" + GENERATE_DIR):
            subprocess.run(["java","-jar",ANTLR_JAR,"-o",GENERATE_DIR,"-no-listener","-visitor","main/cosim/parser/cosim.g4"])
        if not (TARGET_DIR + "/" + GENERATE_DIR) in sys.path:
            sys.path.append(TARGET_DIR + "/" + GENERATE_DIR)
        printUsage()

def printUsage():
    print("py run.py gen")

if __name__ == "__main__":
    main(sys.argv[1:])