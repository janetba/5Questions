package stem.server;

import stem.client.GreetingService;
import stem.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	private BinaryTree tree = BinaryTree.getInstance();
	
	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			System.out.println("THERE WAS AN ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			throw new IllegalArgumentException("Please enter a yes or a no");
		}
		
		return tree.next(input).getData();
	}
	
	public String restart()
	{
		tree.restart();
		return tree._root.getData();
	}
}
