import sys
import re
import extras
import weatherMeasurement

#start of execution
myFlagg = False;
while(True):
    sys.stdout.write("Enter name of station:")
    name = str(input())
    if(extras.nonZeroInput(name) & extras.checkForTomSawyer(name)):
        break
    else:
        continue

size = extras.getListSize()
print(size)

num = 42
mystr = ""
temp = ""
wind = ""
direction = ""


weatherHistory = [None] * size
historyCount = 0
historyIndex = 0
while(True):
    print("\nNext Command")
    print("0 to exit")
    print("1 to input weather data")
    print("2 to print out last data input")
    print("3 to print up to the last " + str(size) + " histories")
    sys.stdout.write("Input:")
    mystr = input()
    repeatRegex = "[0-3]"
    if(extras.checkRegex(repeatRegex,mystr)):
        num = int(mystr)
        if(num == 0):
            sys.stdout.write("Goodbye Tom")
            break
        elif(num == 1):
            current = weatherMeasurement.weatherMeasurement_t()
            #print("History Index: " + str(historyIndex))
            
            weatherHistory[historyIndex] = current
            temp = current.temperature.temperature
            wind = current.wind.speed
            direction = current.wind.direction
            
            
            myFlagg = True
            historyCount += 1
            historyIndex += 1
            historyIndex = historyIndex % size
        elif(num == 2):
            if(myFlagg):
                extras.printData(name, temp, wind, direction)
            else:
                print("No data to show\n")
        elif(num == 3):
            if(myFlagg):
                extras.printHistory(weatherHistory, historyIndex, historyCount, name, size)
            else:
                print("No data to show\n")
    else:
        continue
    
