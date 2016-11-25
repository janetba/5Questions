package stem.server;

public class Node{
	
	Node _right; 
	Node _left; 
	private String _data; 
	
	public Node(String data){
		this._data = data;
	}
	
    public String getData()
    {
    	return _data;
    }
}