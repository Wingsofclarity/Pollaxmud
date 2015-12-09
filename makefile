TEXTFILES=resources/roomData.txt resources/creatureData.txt resources/connectionData.txt resources/courseData.txt resources/questionData.txt


comp: Pollaxmud.java Room.java Creature.java World.java Player.java Connection.java Control.java Course.java NPC.java Student.java Teacher.java Item.java Book.java Sphinx.java
	@javac $^

comp_Xlint: Pollaxmud.java Room.java Creature.java World.java Player.java Connection.java Control.java Course.java NPC.java Student.java Teacher.java Item.java Book.java Sphinx.java 
	@javac -Xlint $^

comp_test: comp
	javac -cp .:junit-4.12.jar TestPlayer.java TestCourse.java

test: comp_test
	java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar org.junit.runner.JUnitCore TestPlayer TestCourse

test_player: comp_test
	java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar org.junit.runner.JUnitCore TestPlayer

test_course: comp_test
	java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar org.junit.runner.JUnitCore TestCourse


run: comp
	@java -ea Pollaxmud 

force_run: comp
	@java Pollaxmud 

clean:
	@rm -f *~
	@rm -f *#
	@rm -f *.class
