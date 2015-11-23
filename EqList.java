public class EqList<ET extends Object> extends List<ET>{

    @Override
    public void addElement(ET e){
	assert(!has(e));
	super.addElement(e);
    }
    
    public boolean has(ET e){
	Node<ET> curNode = first;
	while (curNode!=null){
	    if (curNode.elm.equals(e)){ //Bug: Does not refer to the right equals
		return true;
	    }
	    curNode=curNode.next;
	}
	return false;
    }

    public boolean equals(Object o){
	assert(o instanceof EqList);
	@SuppressWarnings("unchecked") //Ignore unchecked cast cause it is kinda checked. I tihnk.
	EqList<ET> eq = (EqList<ET>) o;
	if (size() != eq.size()){
	    return false;
	}
	Node<ET> curNode = first;
	while (curNode!=null){
	    eq.has(curNode.elm);
	}
	return true;
    }

    public ET take(ET e){
	Node<ET> curNode = first;
	for (int i = 0; curNode!=null; i++){
	    if (curNode.elm.equals(e)){
		ET r = takeNth(i);
		assert(r!=null);
		return r;
	    }
	    curNode=curNode.next;
	}
	return null;
    }

    //This is bullshit.
    public ET get(ET e){
	Node<ET> curNode = first;
	for (int i = 0; curNode!=null; i++){
	    if (curNode.elm.equals(e)){
		ET r = getNth(i);
		assert(r!=null);
		return r;
	    }
	    curNode=curNode.next;
	}
	return null;
    }

    public void remove(ET e){
	take(e);
    }

    @Override
    public int hashCode(){
	ErrorControl.error();
	return -1;
    }
}
