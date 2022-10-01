#include <stdio.h>
#include <stdlib.h>

int main() {
	void printMenu();
	int getChoice();
	int checkDate();
	void validOrNot(int n);
	void printASCII();
	int choice, date;
	
	do {
		printMenu();
 		choice = getChoice();
		switch (choice) {
			case 1: 
					date = checkDate();
					validOrNot(date);
					break;
			case 2:
					printASCII();
					break;
			case 3: 
					printf("Thank you !!!");
					break;
			default:
					printf("\nPlease enter number between 1 to 3!!!\n\n");
		}
	} while (choice != 3);
	
	return 0;
}

void printMenu() {
	printf("1. Processing date data\n");
	printf("2. Charater data\n");
	printf("3. Quit\n");
}

int getChoice() {
	int choice;
	printf("Please enter number of your choice: ");
	scanf("%d", &choice);
	return choice;
}

int checkDate() {
	int d, m, y;
	int maxD = 31;
	printf("Date (d/m/yyyy): ");
	scanf("%d/%d/%d",&d, &m, &y);
	if (d < 1 || d > 31 || m < 1 || m > 12) {
		return 0;
	}
	if (m == 4 || m == 6 || m == 9 || m == 11) {
		maxD = 30;
	} else if (m == 2) {	
		// Năm nhuận là năm chia hết cho 400 hoặc chia hết cho 4 và không chia hết cho 100
		if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
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

void validOrNot(int n) {
	if (n == 0) {
		printf("\nInvalid Date!!!\n\n");
	} else {
		printf("\nValid Date!!!\n\n");
	}
}

void printASCII() {
	char c;
	char c1, c2;
	printf("Enter two character: ");
	// Sử dụng getchar ở đây để loại bỏ kí tự trống
	getchar();
	scanf("%c%c", &c1, &c2);
	getchar();
	if (c1 > c2) {
		for (c = c1; c >= c2; c--) {
			printf("%c: %d, %Xh\n", c, c, c);
		}
	} else {
		for (c = c1; c <= c2; c++) {
			printf("%c: %d, %Xh\n", c, c, c);
		}
	}
	printf("\n");
	
}
 