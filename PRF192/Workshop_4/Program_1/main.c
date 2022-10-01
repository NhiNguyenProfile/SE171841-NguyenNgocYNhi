#include <stdio.h>
#include <math.h>

int isPrime(int n)
{
	if (n<2) return 0;
	int i;
	for (i=2; i<=sqrt(n); i++)
	{
		if (n%i==0) return 1;
	}
	return 0;
}

void printMinMaxDigits (int n)
{
	int digit;
	int min, max;
	digit = n%10;
	n /= 10;
	min = max = digit;
	while (n>0)
	{
		digit = n%10;
		n /= 10;
		if(digit < min) min = digit;
		if(digit > max) max = digit;
	}
	printf("Min = %d\n", min);
	printf("Max = %d\n\n", max);
}

int main() {
	int choice, n, p;;
	do
	{
		printf("1. Process Primes\n");
		printf("2. Print min, max digit in an integer \n");
		printf("3. Quit\n");
		printf("Select an operation: ");
		scanf("%d", &choice);
		
		switch (choice)
		{
			case 1:
				do
				{
					printf("Input a positive integer: ");
					scanf("%d", &n);
				}while(n<0);
					
				if(isPrime(n) == 0)
				{
					printf("%d is prime\n\n", n);
				}	
				else printf("%d is not prime\n\n", n);
				break;
			
			case 2: 
				do
				{
					printf("Input a positive integer: ");
					scanf("%d", &p);
				}while (p<0);
				
				printMinMaxDigits(p);
				break;
			
			case 3: printf("Good Bye!"); 
					return 0;
		}
	}while (choice >0 && choice <3);
	return 0;
}