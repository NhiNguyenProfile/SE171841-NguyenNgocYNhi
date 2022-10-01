#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int n, S;
	do {
		printf("Enter a nonnegative integer: ");
		scanf("%d", &n);
		if (n >= 0) {
			S = sumDigits(n);
			printf("Result = %d\n", S);
		}
	} while (n >= 0);
	
	return 0;
}

int sumDigits(int n) {
	int sum = 0;
	do {
		int remainer = n%10;
		n = n/10;
		sum += remainer;
	} while (n > 0);
	return sum;
}
	
	