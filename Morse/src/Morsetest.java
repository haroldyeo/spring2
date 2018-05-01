import java.util.ArrayList;
import java.util.List;

public class Morsetest {
	
	public static void main(String[] args) {
		possibilities("?-?");
	}
		
  public static List<String> possibilities( String word ) {
	  
	  // get morseData
	  Node[][] data = getMorseData();
	  
	  // Get word as an array
	  String[] arrayW = word.split("");
	  
	  // Get length of array ==> level of morse data
	  int lengthArrW = arrayW.length;
	  int index = 1;
	  
  
	  
	  Node[] currentLevel = null;
	  String currentWord = null;
	  ArrayList<String> result = null;
	  
	  while(index <= lengthArrW) { // loop through levels 
		  
		  currentWord = arrayW[index-1];
		  currentLevel = data[index];		  
		  
		  if (result == null)
			  result  = getElement(currentLevel, currentWord);
		  else
			  result  = getElement(currentLevel, currentWord, result);
			  
		  index++;
	  } 
	  
   	  
	return result;
   
   }
  
  private static ArrayList<String> getElement(Node[] currentLevel, String currentWord, ArrayList<String> result) {

	  ArrayList<String> listToReturn = new ArrayList<>();  
	  if(currentWord.equals("?")) {
		  for(Node n : currentLevel) {
			  if(n!=null && result.contains(n.getParent().getLetter()))
				  listToReturn.add(n.getLetter());
		  }
	  } else {
		  for(Node n : currentLevel) {
			  if(n!=null && n.getCode().equals(currentWord) && result.contains(n.getParent().getLetter()))
				  listToReturn.add(n.getLetter());
		  }
	  }
	  
	  return listToReturn;
}

// returns arraylist of letters
  public static ArrayList<String> getElement(Node[] currentLevel, String currentWord) {
	  
	  ArrayList<String> listToReturn = new ArrayList<>();  
	  if(currentWord.equals("?")) {
		  for(Node n : currentLevel) {
			  if(n!=null)
				  listToReturn.add(n.getLetter());
		  }
	  } else {
		  for(Node n : currentLevel) {
			  if(n!=null && n.getCode().equals(currentWord))
				  listToReturn.add(n.getLetter());
		  }
	  }
	  
	  return listToReturn;
	  
  }
  
  public static Node[][] getMorseData() {
	  
	  Node[][] morseData = new Node[4][20];
	  
	  // Level 1
	  Node E = new Node("E", ".");
	  Node T = new Node("T", "-");
	  morseData[1][0] = E;
	  morseData[1][1] = T;
	  
	  
	  // Level 2
	  Node I = new Node("I", "."); I.setParent(E);
	  Node A = new Node("A", "-"); A.setParent(E);
	  morseData[2][0] = I;
	  morseData[2][1] = A;
	  
	  Node N = new Node("N", "."); N.setParent(T);
	  Node M = new Node("M", "-"); M.setParent(T);
	  morseData[2][2] = N;
	  morseData[2][3] = M;
	  
	  
	  // Level 3
	  Node S = new Node("S", "."); morseData[3][0] = S; S.setParent(I);
	  Node U = new Node("U", "-"); morseData[3][1] = U; U.setParent(I);
	  
	  Node R = new Node("R", "."); morseData[3][2] = R; R.setParent(A);
	  Node W = new Node("W", "-"); morseData[3][3] = W; W.setParent(A);
	  
	  Node D = new Node("D", "."); morseData[3][4] = D; D.setParent(N);
	  Node K = new Node("K", "-"); morseData[3][5] = K; K.setParent(N);
	  
	  Node G = new Node("G", "."); morseData[3][6] = G; G.setParent(M);
	  Node O = new Node("O", "-"); morseData[3][7] = O; O.setParent(M);
	  
	  return morseData;
  }
  
   
}


class Node {
	
	private String letter;
	private String code;
	private Node parent;

	public Node(String letterP, String codeP) {
		letter = letterP;
		code = codeP;
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


	public Node getParent() {
		return parent;
	}


	public void setParent(Node parent) {
		this.parent = parent;
	}

		
	
	
}