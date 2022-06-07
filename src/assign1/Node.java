package assign1;



public class Node implements Comparable<Node> {

    public final int freq;
    private Node leftNode;
    private Node rightNode;
    private char character;
    

    public Node(Node leftNode, Node rightNode) {
    	if (compareTo2(leftNode , rightNode) <= 0) {		
    		this.leftNode = leftNode;
            this.rightNode = rightNode;}
    	else {this.leftNode = rightNode;
        this.rightNode = leftNode; }
    	this.character = character;
        this.freq = leftNode.getFreq() + rightNode.getFreq();
    }
    
    public Node(char character , int freq) {
    	this.character = character;
    	this.freq = freq;
    }
    

    

	public int compareTo2(Node node ,  Node node2) {
        return Integer.compare(node.getFreq(), node2.getFreq());
    }
	
	@Override
    public int compareTo(Node node) {
        return Integer.compare(freq, node.getFreq());
    }

	public int getFreq() {
		// TODO Auto-generated method stub
		return this.freq;
	}
	
	public Node getLeftNode() {
		return leftNode;
	}
	
	public Node getRightNode() {
		return rightNode;
	}

	public Character getCharacter() {
		// TODO Auto-generated method stub
		return this.character;
	}
	

}