#include <stdio.h>
#include <stdlib.h>


int main() {
	int a, b;
	do {
		printf("Enter first positive integer: ");
		scanf("%d", &a);
		printf("Enter second positive integer: ");
		scanf("%d", &b);
	} while(a <= 0 || b <= 0);
	printf("Greatest common divisor: %d\n", gcd(a, b));
	printf("Least common multiple: %d", lcm(a, b));
	return 0;
}

int gcd(int a, int b) {
	while (a != b) {
		if (a > b) {
			a = a - b;
		} else if (a < b) {
			b = b - a;
		}
	}
	return a;
}

int lcm(int a, int b) {
	return a*b / gcd(a, b);
}