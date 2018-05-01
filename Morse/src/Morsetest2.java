import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Morsetest2 {
	
	public static void main(String[] args) {
		possibilities("?-?");
	}
	
	public static List<String> possibilities( String word ) {
		
		ArrayList<String> result = null;
		
		// get data
		List<NodeTwo> data = getMorseData();
		
		// get array out of word and obtain the length
		String[] arrayWord = word.split("");
		int lenght = arrayWord.length;
				
		// Obtain desired result based on word
		String currentWord = null;
		List<NodeTwo> currentLevel = null;
		int index = 1;
		
		while(index <= lenght) {
			currentWord = arrayWord[index-1];
			currentLevel = new ArrayList<>();
			
			for(NodeTwo n : data) {
				if(n.getLevel() == index)
					currentLevel.add(n);
			}
			
			result = getElements(currentWord, currentLevel, result);
			
			index++;
		}
		
		
		return result;
		
	}
	
	public static ArrayList<String> getElements(String currentWord, List<NodeTwo> currentLevel, ArrayList result){
		
		ArrayList<String> listToReturn = new ArrayList<>();
		
		if(result==null) {
			
			if(currentWord.equals("?")) {
				for(NodeTwo node : currentLevel) {
					listToReturn.add(node.getLetter());
				}
			} else {
				for(NodeTwo node : currentLevel) {
					if(node.getCode().equals(currentWord)) {
						listToReturn.add(node.getLetter());
					}
				}
			}
			
			
		} else { // result not equal to null
			if(currentWord.equals("?")) {
				for(NodeTwo node : currentLevel) {
					if(result.contains(node.getParent().getLetter()))
						listToReturn.add(node.getLetter());
				}
			} else {
				for(NodeTwo node : currentLevel) {
					if(node.getCode().equals(currentWord) && result.contains(node.getParent().getLetter())) {
						listToReturn.add(node.getLetter());
					}
				}
			}
		}
		
		return listToReturn;
	}
	
	
	public static List getMorseData() {
		  
		  // Level 1
		  NodeTwo E = new NodeTwo("E", ".", 1);
		  NodeTwo T = new NodeTwo("T", "-", 1);
		  		  
		  // Level 2
		  NodeTwo I = new NodeTwo("I", ".", 2); I.setParent(E);
		  NodeTwo A = new NodeTwo("A", "-", 2); A.setParent(E);
		  
		  NodeTwo N = new NodeTwo("N", ".", 2); N.setParent(T);
		  NodeTwo M = new NodeTwo("M", "-", 2); M.setParent(T);
		  
		  
		  // Level 3
		  NodeTwo S = new NodeTwo("S", ".", 3);  S.setParent(I);
		  NodeTwo U = new NodeTwo("U", "-", 3);  U.setParent(I);
		  
		  NodeTwo R = new NodeTwo("R", ".", 3);  R.setParent(A);
		  NodeTwo W = new NodeTwo("W", "-", 3);  W.setParent(A);
		  
		  NodeTwo D = new NodeTwo("D", ".", 3);  D.setParent(N);
		  NodeTwo K = new NodeTwo("K", "-", 3);  K.setParent(N);
		  
		  NodeTwo G = new NodeTwo("G", ".", 3);  G.setParent(M);
		  NodeTwo O = new NodeTwo("O", "-", 3);  O.setParent(M);
		  
		  return Arrays.asList(E,T,I,A,N,M,S,U,R,W,D,K,G,O);
	  }
	  
	   
	}


	class NodeTwo {
		
		private String letter;
		private String code;
		private NodeTwo parent;
		private int level;

		public NodeTwo(String letterP, String codeP, int level) {
			letter = letterP;
			code = codeP;
			this.level = level;
		}
		
		
		public String getLetter() {
			return letter;
		}

		public void setLetter(String letter) {
			this.letter = letter;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}


		public NodeTwo getParent() {
			return parent;
		}


		public void setParent(NodeTwo parent) {
			this.parent = parent;
		}


		public int getLevel() {
			return level;
		}


		public void setLevel(int level) {
			this.level = level;
		}
				

}

