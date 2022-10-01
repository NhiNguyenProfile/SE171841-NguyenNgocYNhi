#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_VALUE 100
#define MAX_CODE 9
#define MAX_NAME 21

int menu()
{
	int choice;
	printf("\n==================MENU===================");
	printf("\n| 1- Add a new employee                 |");
	printf("\n| 2- Search a data of employee          |");
	printf("\n| 3- Remove an employee                 |");
	printf("\n| 4- Print the list in descending order |");
	printf("\n| 5- Quit                               |");
	printf("\n=========================================\n");
	printf("\nEnter Your Choice: ");
	scanf("%d", &choice);
	fflush(stdin);
	return choice;
}

int isFull(int *pn)
{
	return *pn == MAX_VALUE;
}

int isEmpty(int *pn)
{
	return *pn == 0;
}

char* lTrim(char s[])
{
	int i = 0;
	while (s[i] == ' ')	i++;
	if (i > 0) strcpy(&s[0], &s[i]);
	return s;
}

char* rTrim(char s[])
{
	int i = strlen(s)-1;
	while (s[i] == ' ') i--;
	s[i+1] = '\0';
	return s;
}

char* trim(char s[])
{
	rTrim(lTrim(s));
	char *ptr = strstr(s, "  ");
	while (ptr != NULL)
	{
		strcpy(ptr, ptr+1);
		ptr = strstr(s, "  ");
	}
	return s;
}

char* nameStr (char s[])
{
	trim(s);
	strlwr(s);
	int L = strlen(s);
	int i;
	for (i = 0; i < L; i++)
		if (i == 0 || (i > 0 && s[i-1] == ' '))
			s[i] = toupper(s[i]);
	return s;
}

void addEmployee(char code[][MAX_CODE], char name[][MAX_NAME], int salaries[], int allowances[], int*pn)
{
	char codes[MAX_CODE], names[MAX_NAME];
	int salary, allowance, totals = 0;
	printf("\n!--Please Enter Employee Information--!\n");
	printf("Employee Code: ");
	gets(codes);
	printf("Employee Name: ");
	gets(names);
	printf("Employee Salary (VND): ");
	scanf("%d", &salary);
	printf("Employee Allowances(VND): ");
	scanf("%d", &allowance);
	trim(codes);
	nameStr(names);
	strcpy(code[*pn], codes);
	strcpy(name[*pn], names);
	salaries[*pn] = salary;
	allowances[*pn] = allowance;
	(*pn)++;
}

void printList(char code[][MAX_CODE], char name[][MAX_NAME], int salaries[], int allowances[], int n)
{
	printf("\nCode: %s\n", code[n]);
	printf("Name: %s\n", name[n]);
	printf("Salary: %d VND\n", salaries[n]);
	printf("Allowances: %d VND\n", allowances[n]);
}

void printBasedName(char code[][MAX_CODE], char name[][MAX_NAME], int salaries[], int allowances[], int n)
{
	char names[MAX_NAME];
	printf("\nEnter NAME of employee you wanna find the information: ");
	scanf("%[^\n]", names);
	nameStr(names);
	int check, i;
	check = 0;
	for (i = 0; i < n; i++)
	{
		if (strcmp(names, name[i]) == 0)
		{
			printf("\n-- Information of Employee --\n");
			printList(code, name, salaries, allowances, i);
			check = 1;
		}
	}
	if (check == 0)
		printf("\nNot found information of employee was entered!\n");
}

void removeEmployee(char code[][MAX_CODE], char name[][MAX_NAME], int salaries[], int allowances[], int*pn)
{
	int i;
	char codes[MAX_CODE];
	printf("Enter CODE of employee you wanna REMOVE: ");
	scanf("%[^\n]", codes);
	trim(codes);
	int check = 0;
	for (i = 0; i < *pn; i++)
	{
		if (strcmp(code[i], codes) == 0)
		{
			int j;
			for (j = i + 1; j < *pn; j++)
			{
				strcpy(code[j-1], code[j]);
				strcpy(name[j-1], name[j]);
				salaries[j-1] = salaries[j];
				allowances[j-1] = allowances[j];
			}
			check = 1;
			(*pn)--;
		}
	}
	if (check == 1)
		printf("\nRemoved!\n");
	else
		printf("\nUnremove!\n");
}

void printDec(char code[MAX_VALUE][MAX_CODE], char name[][MAX_NAME], int salaries[], int allowances[], int*pn)
{
	int i, j;
	for (i = 0; i < *pn-1; i++)
     	for (j = *pn-1; j > i; j--)
		{
			if ((salaries[j] + allowances[j]) > (salaries[j-1] + allowances[j-1]))
			{
				char trscode[MAX_CODE];
		        strcpy(trscode, code[j]);
		        strcpy(code[j], code[j-1]);
		        strcpy(code[j-1], trscode);
		        
				char trsname[MAX_NAME];
		        strcpy(trsname, name[j]);
		        strcpy(name[j], name[j-1]);
		        strcpy(name[j-1], trsname);
		        
		        int trssa;
		        trssa = salaries[j];
		        salaries[j] = salaries[j-1];
		        salaries[j-1] = trssa;
		        
		        int trsall;
		        trsall = allowances[j];
		        allowances[j] = allowances[j-1];
		        allowances[j-1] = trsall;
			}
		}
	printf("\n---List of employees---\n");
	for (i = 0; i < *pn; i++)
	{
		printList(code, name, salaries, allowances, i);
		printf("\n");
	}
}

int main()
{
	int userChoice, check = 1;
	char code[MAX_VALUE][MAX_CODE];
	char name[MAX_VALUE][MAX_NAME];
	int salaries[MAX_VALUE];
	int allowances[MAX_VALUE];
	int n = 0;
    do
    {
		userChoice = menu();
    	switch(userChoice)
		{
			case 1:
				if (isFull(&n))
					printf("\nSorry! The List is full!\n");
				else
					addEmployee(code, name, salaries, allowances, &n);			
					printf("\nAdded!\n");
		        break;
		    case 2:
		    	if (isEmpty(&n))
					printf("\nSorry! The List is empty!\n");
				else
					printBasedName(code, name, salaries, allowances, n);
			    break;
			case 3:
				if (isEmpty(&n))
					printf("\nSorry! The List is empty!\n");
				else
					removeEmployee(code, name, salaries, allowances, &n);
				break;
			case 4:
				if (isEmpty(&n))
					printf("\nSorry! The List is empty!\n");
				else
					printDec(code, name, salaries, allowances, &n);
				break;
		    default:
		    	if (userChoice == 5)
		    		check = 0;
		    	else 
					printf("\n>>>Wrong input!!!!\n");
				break;					
	    }
	}
	while (check == 1);
	printf("\nGood Bye!");
	getchar();
}