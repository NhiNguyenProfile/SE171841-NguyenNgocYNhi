#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int randomNum(int min, int max) {
	return (min + rand() % (max + 1 - min));
}

int main() {
	const int min = 1;
	const int max = 10;
	int total, count = 1;
	int x, y;
	printf("Ball Lottery\n");
	printf("============\n");
	do {
		printf("Total sought: ");
		// thi?u &
		scanf("%d", &total);
		if (total < 2 || total > 20) {
			printf("Please enter number between 2 and 20 !!!\n\n");
		}
	} while(total < 2 || total > 20);
	do {
		x = randomNum(min, max);
		y = randomNum(min, max);
		printf("Result of picks %d and %d: %d + %d\n",count, count + 1, x, y);
		count += 2;
	} while(x + y != total);
	printf("You got your total in %d throws!", count-1);
	return 0;
}