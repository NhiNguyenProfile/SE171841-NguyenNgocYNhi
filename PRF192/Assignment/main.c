#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

/*
Purpose: One Two Three Game
Creator: Nguyen Ngoc Y Nhi
Date: 7/13/2022
Version: 1.0
*/


//int random() {
//	const int min = 1;
//	const int max = 3;
//        time_t t;
//		srand((unsigned) time(&t)); 
//        return (rand() % 3) + 1;
//    }

void changer(int number) {
        if (number == 1) {
        	printf("Computer: PAPER\n");
        } else if (number == 2) {
        	printf("Computer: SCISSORS\n");
        } else {
        	printf("Computer: ROCK\n");
    }
}

void menu() {
		printf("\n\n\t===== ONE TWO THREE =====");
        printf("\n\t=\t0. Quit\t\t=\n");
        printf("\t=\t1. Paper\t=\n");
        printf("\t=\t2. Scissors\t=\n");
        printf("\t=\t3. Rock\t\t=\n");
        printf("\t=========================");
    }

int input() {
	int player;
    printf("\n\nPlease choose number of option: ");
    scanf("%d", &player);
    return player;
}

int handler(int p, int c) {
        int result = 0;
        if (p == c) {
            printf("DRAW !!!");
            result = 0;
        } else if (p == 1 && c == 2) {
            printf("COMPUTER WIN !!!");
            result = -1;
        } else if (p == 1 && c == 3) {
            printf("PLAYER WIN !!!");
            result = 1;
        } else if (p == 2 && c == 1) {
            printf("PLAYER WIN !!!");
            result = 1;
        } else if (p == 2 && c == 3) {
            printf("COMPUTER WIN !!!");
            result = -1;
        } else if (p == 3 && c == 1) {
            printf("COMPUTER WIN !!!");
            result = -1;
        } else if (p == 3 && c == 2) {
            printf("PLAYER WIN !!!");
            result = 1;
        }
        return result;
    }
    
    void printResult(int compuScore, int playerScore) {
        printf("\n\n======================== RESULT ========================\n");
        printf("= Player %45d =\n", playerScore);
        printf("= Computer%44d =\n", compuScore);
        printf("========================================================");
    }
    
    void main() {
    	const int max = 3;
    	time_t t;
		srand((unsigned) time(&t)); 
        bool isContinue = true;
        int compuScore = 0;
        int playerScore = 0;
        do {
            menu();
            int playerChoice = input();
            if (playerChoice == 1 || playerChoice ==  2 || playerChoice ==  3 ) {
                int number = (rand() % max) + 1;
                changer(number);
                int result = handler(playerChoice, number);
                if (result == 1) {
                    playerScore++;
                } else if (result == -1) {
                    compuScore++;
                }
                isContinue = true;
                
            }else if (playerChoice == 0) {
            	isContinue = false;
                printResult(compuScore, playerScore);
			} else {
                isContinue = true;
                printf("\nPlease choose option form 0 to 3 !!!!\n");
            }

        } while (isContinue);

    }
