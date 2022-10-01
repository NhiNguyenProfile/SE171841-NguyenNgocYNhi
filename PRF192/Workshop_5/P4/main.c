#include <stdio.h>
#include <stdlib.h>
#include <Math.h>

int main() {
	void printMenu();
	int getChoice();
	void calcQuadratic();
	void deposit();
	int choice;
	
	do {
		printMenu();
 		choice = getChoice();
		switch (choice) {
			case 1: 
					calcQuadratic();
					break;
			case 2:
					deposit();
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
	printf("1. Quadratic equation\n");
	printf("2. Bank deposit problem\n");
	printf("3. Quit\n");
}

int getChoice() {
	int choice;
	printf("Please enter number of your choice: ");
	scanf("%d", &choice);
	return choice;
}

void calcQuadratic() {
	double a , b , c;
	double delta; 
	printf("\nQuadratic equation: ax^2 + bx + c = 0\n");
	printf("Enter a: ");
	scanf("%lf", &a);
	printf("Enter b: ");
	scanf("%lf", &b);
	printf("Enter c: ");
	scanf("%lf", &c);
	delta = b*b - 4*a*c;
	printf("delta = %0.2lf\n", delta);
	if (delta < 0) {
		printf("Equation has no solution!!!\n\n");
	} else if (delta == 0) {
		printf("x1 = x2 = %0.2lf\n\n", -b/(2*a));
	} else {
		printf("x1 = %0.2lf\n", (-b + sqrt(delta))/(2*a));
		printf("x2 = %0.2lf\n\n", (-b - sqrt(delta))/(2*a));
	}
}

void deposit() {
	int deposit, y;
	double yRate;
	double P;
	do {
		printf("Deposit: ");
		scanf("%d", &deposit);
	} while (deposit <= 0);
	do {
		printf("Yearly rate: ");
		scanf("%lf", &yRate);	
	} while (yRate <= 0.0 || yRate >= 1.0);
	do {
		printf("Number of year: ");
		scanf("%d", &y);
	} while (y <= 0);
	P = deposit*pow(1+yRate, y);
	printf("Amount at the %d years: %0.1lf\n", y, P);
}
