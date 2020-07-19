import sys
import extras
from pprint import pprint
class language_t():
    instances = {}
    knownLang = {}
    d = {}
    def getInstance():
        if cls not in instances:
            instances[cls] = langauge()
            return instances[cls]
        return getInstance

    def loadLanguage():
        with open("known.lang") as f:
            i = int(0)
            choice = int(-1)
            for line in f:
                i+=1
                print (line)
                (key, val) = line.split()
                knownLang[int(key)] = val
            while(True):
                sys.stdout.write("Choice language(int):")
                temporary = str(input)
                tempRegex = "[1-9]|[0-9]{2,3}"
                if(extras.checkRegex(tempRegex,temporary)):
                    if(int(temporary) > i):
                        print("Not valid station")
                    else:
                        choice = int(temporary)
                        loadChoice(choice)
                        break
                else:
                    continue

    def loadChoice(choice):
        mystr = knownLang.get(choice,"")
        name = mystr + ".lang"
        with open(name) as f:
            for line in f:
                (key,val) = line.split()
                d[int(key)] = val
    def get(num):
        return d.get(num, "")
        

            
