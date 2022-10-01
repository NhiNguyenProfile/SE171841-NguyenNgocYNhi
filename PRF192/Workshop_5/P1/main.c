#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int randomNum(int min, int max) {
	// Khi thực hiện hàm srand sẽ trả về kết quả có kiểu time_t
	// Cách khái báo hàm time => time_t time(time_t *t)
	// khai báo biến t kiểu time_t
	//		time_t t;
	// Khai báo hàm time trước khi sử dụng
	//		time_t time(time_t *t);
	//		srand((int) time(&t)); 
	// Sử dụng cách trên khiến cho hàm khi chạy sẽ trả về 2 số giống nhau;
	return (min + rand() % (max + 1 - min));
}

int main() {
	const int min = 1;
	const int max = 6;
	int total, count = 1;
	int x, y;
	printf("Dice Thrower\n");
	printf("============\n");
	do {
		printf("Total sought: ");
		// thiếu &
		scanf("%d", &total);
		if (total < 2 || total > 12) {
			printf("Please enter number between 2 and 12 !!!\n\n");
		}
	} while(total < 2 || total > 12);
	do {
		x = randomNum(min, max);
		y = randomNum(min, max);
		printf("Result of throw %d: %d + %d\n",count , x, y);
		count++;
	} while(x + y != total);
	printf("You got your total in %d throws!", count - 1);
	return 0;
}