import sys
import extras
class temperature_t:
    def __init__(self):
        self.temperature = temperature_t.setTemp()
    def setTemp():
        while(True):
            sys.stdout.write("\nEnter the temperature:")
            temporary = str(input())
            tempRegex = "[-]?[0-9]{1,3}"
            if(extras.checkRegex(tempRegex, temporary)):
                if(temporary == "0"):
                    print("Invalid input")
                    continue
                else:
                    return temporary
            else:
                continue

    def getTemp():
        return temperature
