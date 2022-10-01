#include <stdio.h>
#include <math.h>
#include <stdbool.h>

int prime(int n) {
	int m = sqrt(n);
	for (int i = 2; i <= m; i++) {
		if (n % i == 0) {
			return 0;
		}
	}
	return 1;
}

int main() {
	bool isNotOver;
	int n;
	do {
		printf("Please enter an integer n (n>=2): ");
		scanf("%d", &n);
		if (n < 2) {
			isNotOver = true;
		} else {
			isNotOver = false;
		}
	} while(isNotOver);
	for (int i = 2; i <= n; i++) {
		if (prime(i) == 1) {
			printf("%d\t", i);
		}
	}
	return 0;
}

