/*
fsc -cp ./scalatest_2.12-3.0.5.jar:./scalactic_2.12-3.0.5.jar Tests.scala Rover.scala

scala -cp ./scalatest_2.12-3.0.5.jar:./scalactic_2.12-3.0.5.jar org.scalatest.run Tests



git add README.md
git add Tests.scala
git add Rover.scala
git commit

git push -u origin master



*/

import org.scalatest._

class Tests extends FlatSpec {


	"Rover" must "return correct location" in{
		var kata = new Rover((1,1),0,new map((10,10)))
		assert(kata.getLoc==(1,1))

	}
	it should "give correct value if original location is outside of map(wraps around)" in{
		var kata = new Rover((7,7),0,new map((4,5)))
		assert(kata.getLoc==(3,2))
	}
	it should "return correct heading when facing each direction" in{
		var kataN = new Rover((7,7),0,new map((4,5)))
		assert(kataN.getRot=='N')
		var kataE = new Rover((7,7),1,new map((4,5)))
		assert(kataE.getRot=='E')
		var kataS = new Rover((7,7),2,new map((4,5)))
		assert(kataS.getRot=='S')	
		var kataW = new Rover((7,7),3,new map((4,5)))
		assert(kataW.getRot=='W')

	}
	it should "move North when facing north" in{
		var kata = new Rover((0,2),0,new map((10,10)))
		kata.move('F')
		assert(kata.getLoc==(0,3))
	
	}

	it should "move East when facing east" in{
		var kata = new Rover((0,2),1,new map((10,10)))
		kata.move('F')
		assert(kata.getLoc==(1,2))
	
	}

	"map" must "return correct size" in{
		var pluto = new map((10,10))
		assert(pluto.getSize==(10,10))

	}


	



}
