import sys
import re
import weatherMeasurement
def checkRegex(reg, checked):
    match = re.fullmatch(reg, checked)
    if match:
        return True
    else:
        print("Invalid Input, try again.")
        return False
def getListSize():
    while(True):
        sys.stdout.write("Enter in the size of the History List:")
        temporary = str(input())
        listRegex = "[1-9]|[0-9]{2,3}"
        if(checkRegex(listRegex, temporary)):
            return int(temporary)
        else:
            continue
def printData(n, t, w, d):
    sys.stdout.write("\nWeather Station: " + n + "\n")
    print("Temperature: " + t)
    sys.stdout.write("Wind: " + w + " " + d + "\n")
def printHistory(wData, histInd, histCount, nombre, size):
    print("Displaying up to last " + str(size) + " readings: #1 as the most recent.")
    if(histCount > size):
        k = 1
        m = 0
        while(m < size):
            histInd -= 1
            if(histInd == -1):
                histInd = size - 1
                
            print("\nReading #" + str(k))
            k += 1
            printData(nombre, wData[histInd].temperature.temperature, wData[histInd].wind.speed, wData[histInd].wind.direction)
            m += 1
            
    else:
        j = 1
        if(histInd == 0):
            histInd = size
        i = histInd - 1
        while(i > -1):
            print("\nReading #" + str(j))
            j += 1
            printData(nombre, wData[i].temperature.temperature, wData[i].wind.speed, wData[i].wind.direction)
            i -= 1
def nonZeroInput(a):
    if(len(a) == 0):
        print("Invalid Input. Try Again")
        return False
    else:
        return True
def checkForTomSawyer(a):
    if(len(a) >= 50):
        print("Tom! Go back to Missouri!")
        return False
    else:
        return True
