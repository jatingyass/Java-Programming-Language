// Java code to demonstrate the working.

import java.util.*;

class GFG {

// Function to print alternating
// rectangles of 0 and X
static void fill0X(int m, int n)
{
	/* k - starting row index
		m - ending row index
		l - starting column index
		n - ending column index
		i - iterator */
	int k = 0, l = 0;


	// Store given number of rows
		// and columns for later use
	int r = m, c = n;

	// A 2D array to store
		// the output to be printed
	char a[][] = new char[m][n];

		// Initialize the character
		// to be stored in a[][]
	 char x = 'X';

	// Fill characters in a[][] in spiral
		// form. Every iteration fills
	// one rectangle of either Xs or Os
	while(k<m && l<n){

		/* Fill the first row from the remaining rows */
	for(int i=l; i<n; i++){
		a[k][i] = x;
	}
	  k++;

		/* Fill the last column from the remaining columns */
	for(int i=k; i<m; i++){
		a[i][n-1] = x;
	}
	n--;

	/* Fill the last row from the remaining rows */
	if(l<n){
		for(int i=n-1; i>=l; i--){
           a[m-1][i] = x;
		}
		m--;
	}

		/* Print the first column
				// from the remaining columns */
		if(k < m){
			for(int i=m-1; i>=k; i--){
               a[i][l] = x;
			}
			l++;
		}

		// Flip character for next iteration
		x = (x == 'O')? 'x' : 'O';
	}

	// Print the filled matrix
	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
			System.out.print(a[i][j] + " ");
		System.out.println();
	}
}

/* Driver program to test above functions */
public static void main (String[] args) {

	System.out.println("Output for m = 5, n = 6");
	fill0X(6, 6);

	System.out.println("Output for m = 4, n = 4");
	fill0X(7, 7);

	System.out.println("Output for m = 3, n = 4");
	fill0X(3, 4);
		
	}
}

// This code is contributed by jatin gyass
