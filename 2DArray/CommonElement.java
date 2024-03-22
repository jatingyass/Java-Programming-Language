// Java implementation of the approach 
import java.util.*; 

class CommonElement
{ 

// Returns common element in all rows of mat[M][N]. 
// If there is no common element, then -1 is returned 
static int findCommon(int mat[][]) 
{ 
	// A hash map to store count of elements 
	HashMap<Integer, Integer> cnt = new HashMap<>();
	int n = mat.length;
	int m = mat[0].length;
	for(int i=0; i<m; i++){
	    cnt.put(mat[0][i], 1);
	}
	
	for(int i=1; i<n; i++){
	    for(int j=0; j<m; j++){
	       if((cnt.containsKey(mat[i][j])) && (cnt.get(mat[i][j])== i)){
	            cnt.put(mat[i][j], cnt.get(mat[i][j])+1);
	        }
	        
	        if(i==n-1 && cnt.containsKey(mat[i][j]) &&  cnt.get(mat[i][j])== n){
	            return mat[i][j];
	        }
	    }
	}
	    return -1;
} 

// Driver Code 
public static void main(String[] args) 
{ 
	int mat[][] = {{ 1, 2, 3, 4, 5 }, 
				{ 2, 4, 5, 8, 10 }, 
				{ 3, 5, 7, 9, 11 }, 
				{ 1, 3, 5, 7, 9 }}; 
	int result = findCommon(mat); 
	if (result == -1) 
		System.out.println("No common element"); 
	else
		System.out.println("Common element is " + result); 
	} 
} 


