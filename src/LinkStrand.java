

public class LinkStrand implements IDnaStrand {
	
	private class Node {
		String info;
		Node next;
		public Node(String s) {
			info = s;
			next = null;
		}
	}
	
	private Node myFirst,myLast;
	private long mySize;
	private StringBuilder myInfo;
	private int myAppends;
	private int myIndex;
	private int myLocalIndex;
	private Node myCurrent;
	
	
	public LinkStrand() {
		this ("");
		
	}
	public LinkStrand(String s) {
		initialize (s);
	}
	
	
	public void initialize(String source) {
		myFirst=new Node(source);
		myLast=myFirst;
		mySize = source.length();
		myIndex = 0;
		myLocalIndex = 0;
		myCurrent = myFirst;
	}
	
	public long size() {
		return mySize;
	}
	
	
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}
	
	public int getAppendCount() {
		return myAppends;
	}
	
	public IDnaStrand append(String dna) {
		if (myFirst == null) {
			initialize(dna);
			myAppends++;
			mySize += dna.length();
			return this;
		}
		else {
			Node a = new Node(dna);
			myLast.next = a;
			myLast = a;
			mySize += dna.length();
			myAppends++;
			return this;
		}
		
		}
	
	public String toString() {
		myInfo = new StringBuilder();
		Node a = myFirst;
		myInfo.append(a.info);
		while(a.next != null) {
			a = a.next;
			myInfo.append(a.info);
		}
		String finished = myInfo.toString();
		return finished;
	}
	
	public IDnaStrand reverse() {
		myLast = myFirst;
		if (myLast == null) {
			return this;
		}
		Node first = myFirst;
		Node second = myFirst.next;
		Node third = null;
		if (first.next == null) {
			StringBuilder info = new StringBuilder (first.info);
			info.reverse();
			first.info = info.toString();
			return this;
		}
		while (first.next != null) {
			StringBuilder info = new StringBuilder (first.info);
			info.reverse();
			first.info = info.toString();
			first.next = third;
			third = first;
			first = second;
			second = first.next;
		}
		myFirst = first;
		return this;

	}
	public char charAt(int index) {
		
		if (index < 0 || index >= mySize) {
			throw new IndexOutOfBoundsException();
		}
		
		if (myIndex > index) {
			myIndex = 0;
			myLocalIndex = 0;
			myCurrent = myFirst;
		}
		
		
		
		
		while (myIndex != index) {
			
			myIndex++;
			myLocalIndex++;
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
			}
		}
		return myCurrent.info.charAt(myLocalIndex);
	}
	}
	

	

