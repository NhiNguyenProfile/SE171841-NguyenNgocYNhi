#include <stdio.h>
#include <stdlib.h>

int main()
{
	int choice;
	int arr[100] = {0}, size = 0;
	int i, k, count;
	int min, max;
	do {
		printf("1. Add a value ");
		printf("\n2. Search a value ");
		printf("\n3. Print out the array ");
		printf("\n4. Print out the values in a range ");
		printf("\n5. Print out the array in ascending order ");
		printf("\n6. Quit.");
		printf("\nSelect an operation: ");
		scanf("%d", &choice);
		switch (choice)
		{
			case 1: 
				printf("Enter size of array: ");
				scanf("%d", &size);
				for (i=0; i<size; i++)
				{
					printf("arr[%d] ", i);
					scanf("%d", &arr[i]);
				}
				printf("Add value completed!\n\n");
				break;
			
			case 2:
			{
				count = 0;
				printf("What value? ");
				scanf("%d", &k);
				
				for (i=0; i<size; ++i)
				{
					if (k == arr[i])
					{
						count = 1;
						break;
					}
				}
				
				if (count == 0) printf("Value not found.\n\n");
				else printf("Value %d has position %d\n\n", k, i);
				break;
			}
			
			case 3:
				for (i=0; i<size; i++)
				{
					printf("%4d", arr[i]);
				}
				printf("\n\n");
				break;
			
			case 4: 

    			printf("\nInput min: ");
    			scanf("%d", &min);
    			printf("\nInput max: ");
    			scanf("%d", &max);

    			printf("\nValues in min-max range: ");
    			for(i = 0; i <= size -1; i++)
				{
					if(arr[i] >= min && arr[i] <= max)
					{
						printf("%4d", arr[i]);
					}
				}
				printf("\n\n");
				break;
			
			case 5:
				int *temp;
				int *adds =  (int*)malloc(size* sizeof(int*));
				for (int i=0; i<size; i++) adds[i] = &arr[i];
				
				for (int i=0; i<size-1; i++)
				{
					for (int j=i+1; j<size; j++)
					{
						if (*adds[i] > *adds[j])
						{
							temp = adds[i];
							adds[i] = adds[j];
							adds[j] = temp;
						}
					}
				}
				for (int i=0; i<size; i++)
				{
					printf("%4d", *adds[i]);
				}
				printf("\n\n");
		}
	} while (choice >0 && choice <6);
	
	return 0;
}