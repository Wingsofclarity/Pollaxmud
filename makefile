TEXTFILES=resources/roomData.txt resources/creatureData.txt resources/connectionData.txt resources/courseData.txt resources/questionData.txt


comp: Pollaxmud.java Room.java Creature.java World.java Player.java Connection.java Control.java Course.java NPC.java Student.java Teacher.java Item.java Book.java Sphinx.java Key.java 
	@javac -Xlint $^

comp_Xlint: Pollaxmud.java Room.java Creature.java World.java Player.java Connection.java Control.java Course.java NPC.java Student.java Teacher.java Item.java Book.java Sphinx.java Key.java 
	@javac -Xlint $^


run: comp
	@java -ea Pollaxmud 

force_run: comp
	@java Pollaxmud 

clean:
	@rm -f *~
	@rm -f *#
	@rm -f *.class
