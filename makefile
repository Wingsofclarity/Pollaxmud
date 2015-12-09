TEXTFILES=resources/roomData.txt resources/creatureData.txt resources/connectionData.txt resources/courseData.txt resources/questionData.txt


comp: Pollaxmud.java Room.java Creature.java World.java Player.java Connection.java Control.java Course.java NPC.java Student.java Teacher.java Item.java Book.java Sphinx.java
	@javac $^

comp_Xlint: Pollaxmud.java Room.java Creature.java World.java Player.java Connection.java Control.java Course.java NPC.java Student.java Teacher.java Item.java Book.java Sphinx.java 
	@javac -Xlint $^

test: comp
	javac -cp .:junit-4.12.jar TestPlayer.java
	java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar org.junit.runner.JUnitCore TestPlayer


run: comp
	@java -ea Pollaxmud 

force_run: comp
	@java Pollaxmud 

clean:
	@rm -f *~
	@rm -f *#
	@rm -f *.class
