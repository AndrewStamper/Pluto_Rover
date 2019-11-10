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
		var kata = new Rover((0,0),0,new map((10,10)))
		assert(kata.getLoc==(0,0))

	}



}
