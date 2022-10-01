#include <stdio.h>
#include <stdlib.h>



int main() {
	int n;
	int min, max;
	do {
		printf("Enter a non-negative integer: ");
		scanf("%d", &n);	
		printMinMaxDigits(n, &max, &min);
	} while(n < 0);
	return 0;
}

void printMinMaxDigits(int n, int* reMax, int* reMin) {
	int digit;
	int* min, max;
	int remainder;
	digit = n%10;
	n = n/10;
	max = digit;
	min = digit;
	while (n > 0) {
		digit = n % 10;
		n = n /10;
		if (min > digit) {
			min = digit;
		} else if (max < digit) {
			max = digit;
		}
	}
	printf("Min = %d\n", min);
	printf("max = %d", max);
}           


