      /*
      THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
      CODE WRITTEN BY OTHER STUDENTS. Melanie Dauber
      */

package hw5;

public class BSTIndex {

	private class Node{
		private MovieInfo value;
		private String key;
		private Node left, right;
		
		public Node (MovieInfo val){
			value = val;
			key = value.shortName;
		}
	}
	
		private Node root = null;
		
		private Node insert(MovieInfo value, Node t){
			
			if (t == null){
				t = new Node (value);
			} else if (value.shortName.compareToIgnoreCase(t.key) > 0){
				t.right = insert(value, t.right);
			} else if (value.shortName.compareToIgnoreCase(t.key) < 0){
				t.left = insert(value, t.left);
			} else {
				return t;
			}
			return t;
		}

		
		private MovieInfo findPrefix (Node t, String pre){
			
			if (t == null){
				return null;
			} if (t.key.toLowerCase().contains(pre.toLowerCase().substring(0,pre.length()-1))){
				return t.value;
			} else if (pre.compareToIgnoreCase(t.key) < 0){
				return findPrefix(t.left, pre);
			} else if (pre.compareToIgnoreCase(t.key) > 0){
				return findPrefix(t.right, pre);
			} else{
				return null;
			}
		}
		
		
		public MovieInfo findExact(Node t, String key){
			
			if (t == null){
				return null;
			} if (key.compareToIgnoreCase(t.key) < 0){
				return findExact(t.left, key);
			} else if (key.compareToIgnoreCase(t.key) > 0){
				return findExact (t.right, key);
			} else {
				return t.value;
			}
		}
		
		public void insert(MovieInfo value){
			root = insert(value, root);
		}
		
		public MovieInfo findExact (String key){
			return findExact(root, key);
		}
		
		public MovieInfo findPrefix(String pre){
			return findPrefix (root, pre);
		}
		
}

		
		
	
	
	


		
		
