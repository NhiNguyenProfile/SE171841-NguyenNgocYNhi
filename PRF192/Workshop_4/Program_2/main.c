#include <stdio.h>

double fibo (int n) 
{
	int t1=1, t2=1, f=1, i;
	for (i= 3; i<=n; i++) 
	{		
    	f= t1 + t2;
    	t1= t2;
    	t2=f;
   	}
   return f;
}

int validDate(int d, int m, int y)
{
	int maxd = 31; //max day of months 1,3,5,7,8,10,12
	
	if (d<1 || d>31 || m<1 || m>12) return 0; //basic checking
	if (m==4 || m==6 || m==9 || m==11)
	{
		maxd = 30;	
	}
	else if (m==2)
	{
		//leap year
		if (y%400==0 || y%4==0 && y%100!=0) maxd=29;
		else maxd=28;
	}
	return d<=maxd;
}

int main()
{
	int a;
	int d,m,y;
	int choice;
	do
	{
		printf("1.Fibonacci sequence\n");
		printf("2.Check a date\n");
		printf("3.Quit\n");
		printf("Select an operation: ");
		scanf("%d", &choice);
		
		switch (choice)
		{
			case 1: 
				do
				{
					printf("Input a positive integer: ");
					scanf("%d", &a);
				}while (a<0);
				printf("Fibonacci number %d is: %.2lf\n\n", a, fibo(a));
				break;
			
			case 2:
				
				do
				{
					printf("Input date/month/year: ");
					scanf("%d/%d/%d", &d, &m, &y);
				}while (d<=0 || m <=0 || y <=0);
				
				if (validDate(d,m,y)) printf("Valid date.\n\n");
				else printf("Invalid date.\n\n");
				break;
				
			case 3:
				printf("Good Bye!");
				return 0;
		}
	}while (choice > 0 && choice < 3);
	return 0;
}