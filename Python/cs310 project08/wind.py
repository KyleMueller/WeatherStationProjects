import sys
import extras
class wind_t:
    def __init__(self):
        self.speed = wind_t.setWindSpeed()
        self.direction = wind_t.setWindDirection()
    def setWindSpeed():
        while(True):
            sys.stdout.write("Enter the wind speed:")
            temporary = str(input())
            windRegex = "[1-9]|[0-9]{1,3}"
            if(extras.checkRegex(windRegex, temporary)):
                return temporary
            else:
                continue

    def setWindDirection():   
        while(True):
            sys.stdout.write("Enter the wind direction:")
            windDirection = str(input())
            directionRegex = "n|e|w|s|N|W|S|E|NE|SE|SW|NW|ne|sw|sw|nw"
            if(extras.checkRegex(directionRegex, windDirection)):
                return windDirection
            else:
                continue
    def getSpeed():
        return speed
    def getDirection():
        return direction
