comp: Pollaxmud.java List.java Room.java List.java Creature.java World.java Player.java Connection.java Control.java Course.java NPC.java Student.java Teacher.java Item.java EqList.java
	@javac $^

comp_Xlint: Pollaxmud.java List.java Room.java List.java Creature.java World.java Player.java Connection.java Control.java Course.java NPC.java Student.java Teacher.java Item.java EqList.java
	@javac -Xlint $^


run: comp
	@java -ea Pollaxmud

force_run: comp
	@java Pollaxmud

clean:
	@rm -f *~
	@rm -f *#
	@rm -f *.class
