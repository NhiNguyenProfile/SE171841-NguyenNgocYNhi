#include <stdio.h>
#include <stdlib.h>

double fibo(int n) {
	int t1 = 1, t2 = 1, f = 1;
	for (int i = 3; i <= n; i++) {
		f = t1 + t2;
		t1 = t2;
		t2 = f;
	}
	return f;
}

int main() {
	int n;
	printf("What position do you want to find in the Fibonacci sequence ? => ");
	scanf("%d", &n);  
	printf("Result = %0.0lf", fibo(n));                                                        
	return 0;   
}

