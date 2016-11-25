package stem.server;

public class BinaryTree {
	
	static Node _currNode;
	static Node _root; 
	static BinaryTree tree; 
	boolean end;
	
	private BinaryTree()
	{
		_root = new Node("Is this person female?");
		end = false;
	}
	
	public static BinaryTree getInstance()
	{
		if(tree == null)
		{
			tree = new BinaryTree();
			tree.Populate();
			_currNode = _root;
			return tree;
		}
		else
		{
			restart();
			return tree;
		}
	}
	
	//Restarts the game from the beginning of the tree
	public static void restart()
	{
		BinaryTree._currNode = BinaryTree._root;
	}
		
		
	/* This method will populate the tree with the appropriate questions and answers
	 * for the game.
	 */
	public void Populate()
	{
		_root._left = new Node("Was she born in the 1900's?");
		
		//right branch 
		_root._right = new Node("Was the scientist a physicist?");
		
		//left branch
		Node left1 = _root._left; 
		left1._left = new Node("Did she win a Nobel Prize?");
		left1._right = new Node("Was she American?");
		
		Node left2 = left1._left;
		left2._left = new Node("Was she a physicist?");
		left2._right = new Node("Was she a biologist?");
		
		Node left3 = left2._left;
		left3._left = new Node("Did she work on radioactivity?");
		left3._right = new Node("Did she discover nuclear fission of uranium?");
		
		Node left4 = left3._left;
		left4._left = new Node("Marie Sktodowska Curie");
		left4._right = new Node("Gerty Theresa Cori");
		
		Node left3right = left3._right;
		left3right._left = new Node("Lise Meitner");
		left3right._right = new Node("Dorathy Mary Hodgkin");
		
		Node left2right = left2._right;
		left2right._left = new Node("Did she travel in space?");
		left2right._right = new Node("Was she a nutritionist?");
		
		Node l2rleft = left2right._left;
		l2rleft._left = new Node("Mae Caroll Jemson");
		l2rleft._right = new Node("Inge Lehmann");
		
		Node l2rright = left2right._right;
		l2rright._right = new Node("Nettie Maria Stevens");
		l2rright._left = new Node("Ellen Henrietta Swallow Richards");
		
		Node left1r = left1._right;
		left1r._left= new Node("Did she win a Nobel Prize?");
		left1r._right = new Node("Was she English?");
		
		Node left1rleft = left1r._left;
		left1rleft._left = new Node("Did she develop aids medication?");
		left1rleft._right = new Node("Did she invent the Apgor Score?");
		
		Node l1rrleft = left1rleft._left;
		l1rrleft._left = new Node("Gertude Belle Elion");
		l1rrleft._right = new Node("Barbara McClintock");
		
		Node l1_2right = left1rleft._right;
		l1_2right._left = new Node("Virginia Apgor");
		l1_2right._right = new Node("Marie Maynard");
		
		Node l1_2r1 = left1r._right;
		l1_2r1._left = new Node("Was she a chemist?");
		l1_2r1._right = new Node("Was she a physicist");
		
		Node l1_2l2 = l1_2r1._left;
		l1_2l2._left = new Node("Rosalind Elise Franklin");
		l1_2l2._right = new Node("Mary Leaky");
		
		Node l1_2r2 = l1_2r1._right;
		l1_2r2._left = new Node("Chien-Shiung Wu");
		l1_2r2._right = new Node("Rita Levi-Montalcini");
		
		//Right branch of the tree
		Node right1 = _root._right;
		right1._left = new Node("Did he receive a Nobel Prize?");
		right1._right = new Node("Did he die in the 1900's?");
		
		Node r1_l1 = right1._left;
		r1_l1._left = new Node("Did he teach at CAL Tech?");
		r1_l1._right = new Node("Was he born in Italy?");
		
		Node r1_l1_1 = r1_l1._left;
		r1_l1_1._left = new Node("Was he born in Germany?");
		r1_l1_1._right = new Node("Was he born in Denmark?");
		
		Node r1_l1_2 = r1_l1_1._left;
		r1_l1_2._left = new Node("Alber Einstein");
		r1_l1_2._right = new Node("Richard Phillips Feynman");
		
		Node r1_l1_3 = r1_l1_1._right;
		r1_l1_3._left = new Node("Neils Henrik David Bohr");
		r1_l1_3._right = new Node("Erwin Rudolph Joseph Alexander");
		
		Node r1_l1_4 =  r1_l1._right;
		r1_l1_4._left = new Node("Was he and astronomer?");
		r1_l1_4._right = new Node("Did he invent laws of gravity?");
		
		Node r1_l1_5 = r1_l1_4._left;
		r1_l1_5._left = new Node("Galileo Galilei");
		r1_l1_5._right = new Node("Enrico Fermi");
		
		Node r1_l1_6 = r1_l1_4._right;
		r1_l1_6._left = new Node("Issac Newton");
		r1_l1_6._right = new Node("Micheal Faraday");
	
		Node r1_l1_7 = right1._right;
		r1_l1_7._left = new Node("Was he American?");
		r1_l1_7._right = new Node("Did he work in the medical field?");
		
		Node r1_l1_8 = r1_l1_7._left;
		r1_l1_8._left = new Node("Did he develop vaccines?");
		r1_l1_8._right = new Node("Did he work on the periodic table?");
		
		Node r1_l1_9 = r1_l1_8._left;
		r1_l1_9._left = new Node("Jonas Edward Salk");
		r1_l1_9._right = new Node("Thomas Alba Edisson");
		
		Node r1_l1_10 = r1_l1_8._right;
		r1_l1_10._left = new Node("Dimitri Evanovich Mendeleev");
		r1_l1_10._right = new Node("Alexander Graham Bell");
		
		Node r1_l1_11 = r1_l1_7._right;
		r1_l1_11._left = new Node("Was he an astronomer?");
		r1_l1_11._right = new Node("Was he a micro-biologist?");
		
		Node r1_l1_12 = r1_l1_11._left;
		r1_l1_12._left = new Node("Nicolaus Copernicus");
		r1_l1_12._right = new Node("Charles Darwin");
		
		Node r1_l1_13 = r1_l1_11._right;
		r1_l1_13._left = new Node("Louis Pasteur");
		r1_l1_13._right = new Node("George Johan Mendel");
	}
	
	/*Will return the next node in the tree depending on the answer.
	 * Will return the left node for a yes answer and the right 
	 * node for a no answer. 
	 */
	public Node next(String answer)
	{
		// always reset the end to false
		end = false;
		
		if(answer.toLowerCase().trim().equals("yes"))
		{
			_currNode = _currNode._left;
		}
		else
		{
			_currNode = _currNode._right;
		}
		
		return _currNode;
	}
}

