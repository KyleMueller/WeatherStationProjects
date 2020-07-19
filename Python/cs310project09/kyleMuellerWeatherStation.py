import sys
import re
import extras
import weatherMeasurement
import language

#start of execution
myFlagg = False;
language = language_t()
while(True):
    sys.stdout.write("Enter name of station:") #1
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
    print("\nNext Command") #2
    print("0 to exit") #3
    print("1 to input weather data")#4
    print("2 to print out last data input")#5
    print("3 to print up to the last " + str(size) + " histories")#6,7
    sys.stdout.write("Input:") #8
    mystr = input()
    repeatRegex = "[0-3]"
    if(extras.checkRegex(repeatRegex,mystr)):
        num = int(mystr)
        if(num == 0):
            sys.stdout.write("Goodbye Tom") #9
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
                print("No data to show\n")#10
        elif(num == 3):
            if(myFlagg):
                extras.printHistory(weatherHistory, historyIndex, historyCount, name, size)
            else:
                print("No data to show\n")#10
    else:
        continue
    
