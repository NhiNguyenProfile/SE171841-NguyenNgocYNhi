#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main() {
	int n;
	printf("Please enter a positive integer: ");
	scanf("%d", &n);
	if (isFibonacci(n) == 1) {
		printf("It is a Fibonacci element.");
	} else {
		printf("It is not a Fibonacci element.");
	}
	return 0;
}

int isFibonacci(int n) {
	int t1 = 1, t2 = 1, f = 1;
	if (n == 1) {
		return 1;
	}
	while (f < n) {
		f = t1 + t2;
		t1 = t2;
		t2 = f;
	}
	if (n == f) {
		return 1;
	}
	return 0;
}