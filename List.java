public class List<ET>{
    protected class Node<ET>{
	ET elm;
	Node<ET> next=null;

	Node(ET elm){
	    this.elm=elm;
	}

	public String toString(){
	    return elm.toString();
	}
    }
    
    protected Node<ET> first = null;
    protected Node<ET> last = null;

    public void addElement(ET elm){
	Node<ET> newLast =  new Node<ET>(elm);

	if (size()!=0 && last==null) {
	    System.out.println("Debug critcal error. add_element");
	    return;
	}
	if (size()==0){
	    first = newLast;
	}
	else {
	    if (last==null){}
	    last.next = newLast;
	}
	last = newLast;
    }

    public ET takeFirst() {
	if (first==null) return null;
	ET elm = first.elm;
	first = first.next;
	if (first==null) last=null;
	return elm;
    }

    public ET takeLast(){
	if (last==null) return null;
	ET elm = last.elm;

	Node<ET> curnode = first;
	if (curnode.next!=null){
	    while (curnode.next.next!=null){
		curnode=curnode.next;
	    }
	    last = curnode;
	    curnode.next=null;
	}
	else {
	    last = null;
	    first = null;
	}
	return elm;
    }

    public ET takeNth(int a){
	assert(a<=size()-1 && a>=0);
	//Cheat
	if(a==0){
	    return takeFirst();
	}
	else if (a==size()-1){
	    return takeLast();
	}
	
	//Cheat end
	Node<ET> curNode = first;
	for (int i = 0; i+1!=a; i++){
	    curNode=curNode.next;
	}
	ET r = curNode.next.elm;
	curNode.next=curNode.next.next;
	return r;
    }

    public ET  getNth(int a){
	Node<ET> curNode = first;
	for (int i = 0; i!=a; i++){
	    curNode=curNode.next;
	}
	return curNode.elm;
    }
    
    public ET head(){
	if (first == null) return null;
	return first.elm;
    }

    public String toString(){
	return toString("   ","\n");
    }

    public String toString(String prefix, String subfix){
	if (size()==0) return prefix+"'Empty'"+subfix;
	
	Node<ET> curNode = first;
	String s = prefix+curNode.toString() + subfix;
	
	while (curNode.next!=null) {
	    curNode=curNode.next;
	    s+=prefix+curNode.toString() + subfix;
	}
	return s;
    }
    
    public int size(){
	Node<ET> curNode = first;
	if (first==null) return 0;
	int i = 1;
	while (curNode.next!=null) {
	    curNode=curNode.next;
	    i++;
	}
	return i;
    }
}
