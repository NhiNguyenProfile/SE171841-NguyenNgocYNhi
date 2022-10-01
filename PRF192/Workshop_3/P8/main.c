#include <stdio.h>
#include <stdlib.h>

double makeDouble(int ipart, int fraction) {
	double dF = fraction;
	do {
		dF = dF / 10;
	} while (dF >= 1);
	if (ipart < 0) {
		return ipart - dF;
	} else {
		return ipart + dF;
	}
} 

int main() {
	int ipart, fraction;
	printf("Enter integral part: ");
	scanf("%d", &ipart);
	do{
		printf("Enter fraction: ");
		scanf("%d", &fraction);
	} while (fraction < 0);
	double value = makeDouble(ipart, fraction);
	printf("Result = %lf", value);
	return 0;
}

