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
		var kata = new Rover((1,1),0,new map((10,10),Set()))
		assert(kata.getLoc==(1,1))

	}
	it should "give correct value if original location is outside of map(wraps around)" in{
		var kata = new Rover((7,7),0,new map((4,5),Set()))
		assert(kata.getLoc==(3,2))
	}
	it should "return correct heading when facing each direction" in{
		var kataN = new Rover((7,7),0,new map((4,5),Set()))
		assert(kataN.getRot=='N')
		var kataE = new Rover((7,7),1,new map((4,5),Set()))
		assert(kataE.getRot=='E')
		var kataS = new Rover((7,7),2,new map((4,5),Set()))
		assert(kataS.getRot=='S')	
		var kataW = new Rover((7,7),3,new map((4,5),Set()))
		assert(kataW.getRot=='W')

	}
	it should "move forwads North when facing north" in{
		var kata = new Rover((0,2),0,new map((10,10),Set()))
		kata.move('F')
		assert(kata.getLoc==(0,3))
	
	}

	it should "move forwads East when facing east" in{
		var kata = new Rover((0,2),1,new map((10,10),Set()))
		kata.move('F')
		assert(kata.getLoc==(1,2))
	}
	it should "move forwads West and south as required" in{
		var kataS = new Rover((0,2),2,new map((10,10),Set()))
		kataS.move('F')
		assert(kataS.getLoc==(0,1))
	
		var kataW = new Rover((2,2),3,new map((10,10),Set()))
		kataW.move('F')
		assert(kataW.getLoc==(1,2))
	
	}
	it should "move BACKWARDS in all directions as required" in{
		var kataN = new Rover((7,7),0,new map((10,10),Set()))
		kataN.move('B')
		assert(kataN.getLoc==(7,6))
		var kataE = new Rover((7,7),1,new map((10,10),Set()))
		kataE.move('B')
		assert(kataE.getLoc==(6,7))
		var kataS = new Rover((7,7),2,new map((10,10),Set()))
		kataS.move('B')
		assert(kataS.getLoc==(7,8))	
		var kataW = new Rover((7,7),3,new map((10,10),Set()))
		kataW.move('B')
		assert(kataW.getLoc==(8,7))
	
	}

	it should "use move command when input is F" in{
		var kataN = new Rover((7,7),0,new map((10,10),Set()))
		kataN.input('B')
		assert(kataN.getLoc==(7,6))
	}
	it should "rotate R" in{
		var kataL = new Rover((7,7),0,new map((10,10),Set()))
		assert(kataL.getRot=='N')
		kataL.input('R')
		assert(kataL.getRot=='E')
		kataL.input('R')
		assert(kataL.getRot=='S')
		kataL.input('R')
		assert(kataL.getRot=='W')
		kataL.input('R')
		assert(kataL.getRot=='N')
	}
	it should "rotate L" in{
		var kataL = new Rover((7,7),0,new map((10,10),Set()))
		assert(kataL.getRot=='N')
		kataL.input('L')
		assert(kataL.getRot=='W')
		kataL.input('L')
		assert(kataL.getRot=='S')
		kataL.input('L')
		assert(kataL.getRot=='E')
		kataL.input('L')
		assert(kataL.getRot=='N')
	}
	it should "wrap if move is off board" in{
		var kataN = new Rover((7,7),0,new map((8,8),Set()))
		kataN.move('F')
		assert(kataN.getLoc==(7,0))

		var kataE = new Rover((7,7),1,new map((8,8),Set()))
		kataE.move('F')
		assert(kataE.getLoc==(0,7))

		var kataS = new Rover((7,0),2,new map((8,8),Set()))
		kataS.move('F')
		assert(kataS.getLoc==(7,7))	

		var kataW = new Rover((0,7),3,new map((8,8),Set()))
		kataW.move('F')
		assert(kataW.getLoc==(7,7))
	}
	it should "not move if obstacle in the way" in{
		var kata = new Rover((4,4),0,new map((8,8),Set((4,5))))
		kata.move('F')
		assert(kata.getLoc==(4,4))

		
	}
	it should "allow multiple inputs" in{
		var kata = new Rover((0,0),0,new map((8,8),Set()))
		kata.input("FFF")
		assert(kata.getLoc==(0,3))

	}
	it should "allow multiple inputs but stop after first unsuccessfull" in{
		var kata = new Rover((0,0),0,new map((8,8),Set((0,2))))
		kata.input("FFFLF")
		assert(kata.getLoc==(0,1))

	}
	




	"map" must "return correct size" in{
		var pluto = new map((10,10),Set())
		assert(pluto.getSize==(10,10))

	}


	



}
