#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main() {
	int N[10];
	int i, j;
	long int input;
	long int T = 0;
	do
	{
		printf("ISBN Validator ========== ISBN(0 to quit): ");
		scanf("%ld", &input);
		if (input == 0) {
			break;
		}
		
		for (i=9; i>=0; i--) {
			N[i] = input % 10;
			input /= 10;
		}
		
		for (i = 0; i < 9; i++) {
			T += N[i] * (10 - i);
		}
		
		T += N[9];
		printf("%ld\n", T);
		
		if (T % 11==0) {
			printf("This is a valid ISBN\n\n");
		} else {
			printf("This is not a valid ISBN\n\n");
		}
			
	} while (1);
	
	printf("Have a nice day!");
	return 0;
}