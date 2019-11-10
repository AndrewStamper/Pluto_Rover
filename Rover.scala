trait RoverTrait{

	def input(c:Char):Boolean//input system to interpret the commands given, return if command was completed

	def move(c:Char):Boolean//system to move fowward and backward, return if command was completed

	def rotate(c:Char)//code to rotate in current position, command is always possible so no need to return

	def getLoc:(Int,Int)//return current location

	def getRot:(Char)//return current heading

}


trait mapTrait{
	
	def isClear(loc:(Int,Int)):Boolean//returns if location has an obstacle or not

	def getSize:(Int,Int)//returns dimensions of map

}



class Rover  (Location:(Int,Int),Heading:Int,planet:map) extends RoverTrait{

	def input(c:Char):Boolean={return false}

	def move(c:Char):Boolean={return false}

	def rotate(c:Char)={}

	def getLoc:(Int,Int)={return (1,1)}

	def getRot:(Char)=(return (0))

}

class map (Dimensions:(Int,Int)) extends mapTrait {

	def isClear(loc:(Int,Int)):Boolean={return false}

	def getSize:(Int,Int)={return (1,1)}


}

