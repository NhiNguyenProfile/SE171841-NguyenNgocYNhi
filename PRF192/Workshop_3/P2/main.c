#include <stdio.h>
#include <stdlib.h>


int main() {
	int d, m, y;
	printf("Enter day: ");
	scanf("%d", &d);
	printf("Enter month: ");
	scanf("%d", &m);
	printf("Enter year: ");
	scanf("%d", &y);
	if (checkDate(d, m, y) != 0) {
		printf("Valid Date!");
	} else {
		printf("Invalid Date!");
	}
	return 0;
}

int checkDate(int d, int m, int y) {
	int maxD = 31;
	if (d < 1 || d > 31 || m < 1 || m > 12) {
		return 0;
	}
	if (m == (4 || 6 || 9 || 11)) {
		maxD = 30;
	} else if (m == 2) {
//		leap year?
		if ( y%400==0 || ( y%4==0 && y%100!=0)) {
			maxD = 29;
		} else {
			maxD = 28;
		}
	}
	if (d <= maxD) {
		return d;
	}	
	return 0;
}