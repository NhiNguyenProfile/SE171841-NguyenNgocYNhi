#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100
#define MAXs 30


/*
Purpose: Handle list of Student Name
Creator: Nguyen Ngoc Y Nhi
Date: 7/3/2022
Version: 1.0
*/

int listIsFull(char listName[MAX][MAXs], int *index) {
	return (*index == MAX);
}

int listIsEmpty(char listName[MAX][MAXs], int *index) {
	return (*index == 0);
}

void addStudent (char listName[MAX][MAXs],int *index) {
	char studentName [MAX][MAXs];
	char name[MAXs];
	fflush(stdin); // đặt trước khi nhập chuỗi để xóa '\n' trong bộ đệm
	printf("Please enter your name here: ");
	gets(listName[*index]);
	// or
		//	scanf("%s[^\n]", name);
		//	strcpy(listName[*index], name);
		//	printf("\nADD SUCCESSFULLY!!\n");
}

void removeStudent(char listName[MAX][MAXs], int *index) {
	int rPosition, i;
	do {
		printf("What position do you want to delete the number in? (Enter a number) => ");
		scanf("%d", &rPosition);
		if (rPosition <= 0 || rPosition > *index) {
			printf("Please enter position existed in the list!!!");
		}
	} while (rPosition <= 0 || rPosition > *index);
	
	for (i = rPosition; i < *index; i++) {
		strcpy(listName[i - 1], listName[i]);
	}
}

void printStudent (char listName[MAX][MAXs],int *index) {
//	printf("%d", *index);
	int i, j;
		for (i = 0 ; i < *index-1; i++) {
     	for (j = i + 1; j < *index; j++) {
     		if (strcmp(listName[i] , listName[j]) < 0)
     			{
     				char t[MAXs];
		            strcpy(t, listName[j]);
		            strcpy(listName[j], listName[i]);
		            strcpy(listName[i], t);
				}
		 }
	}
	for (i = 0; i < (*index); i++) {
		printf("%d. %s \n", i + 1, listName[i]);
	}
}

void searchStudent(char listName[MAX][MAXs], int *index)
{
	int i;
	char st[MAXs];
	printf("Searching for : ");
	fflush(stdin);
    scanf("%20[^\n]", &st);
	for (i = 0; i < *index; i++)
		{
			char * ptr = strstr(listName[i], st);
			if (ptr != '\0') printf("RESULT : Name[%d] : %s\n", i, listName[i]);
		}
}

int getChoice() {
	int choice;
	const int minList = 1;
	const int maxList = 5;
	do {
		printf("Please enter your choice (1-5): ");
		scanf("%d", &choice);
		if (choice < minList || choice > maxList) {
			printf("Please choose option from %d to %d!!!", minList, maxList);
		}
	} while (choice < minList || choice > maxList);
	
	return choice;
}

void printMenu() {
	printf("\t1. Add a Student\n");
	printf("\t2. Remove a Student\n");
	printf("\t3. Search a Student\n");
	printf("\t4. Print the list in ascending order\n");
	printf("\t5. Quit\n");
}

int main() {
	char listName[MAX][MAXs];
	int index = 0;
	int choice;
	do {
		printMenu(); 
		choice = getChoice();
		switch (choice) {
			case 1: 
				if (listIsFull(listName, &index) == 1) {
					printf("List is full! Please remove to add more name to list!!\n");
				} else {
					addStudent(listName, &index);
					index++;
				}
				
				
				break;
			case 2: 
				if (listIsEmpty(listName, &index) == 1) {
					printf("List is Empty! Please add name first!!\n");
				} else {
					removeStudent(listName, &index);
					index--;
				}
				break;
			case 3:
				if (listIsEmpty(listName, &index) == 1) {
					printf("List is Empty! Please add name first!!\n");
				} else {
					searchStudent(listName, &index);
				}
				break;
			case 4:
				if (listIsEmpty(listName, &index) == 1) {
					printf("List is Empty! Please add name first!!\n");
				} else {
					printStudent(listName, &index);
				}
				break;
			case 5:
				printf("Thank you for using!\n");
				break;
		} 
	}while (choice != 5);
	
	
	return 0;
}


