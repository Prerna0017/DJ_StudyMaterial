#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

//stack by doubly linked list
typedef struct Node {
	int data;
	struct Node *prev;
	struct Node *next;
}node;
node *start = NULL;
node *top = NULL;

void push(int d)
{
	node *n;
	n = (node *) malloc(sizeof(node));
	n->data = d;
	if (start == NULL) {
		n->prev = NULL;
		n->next = NULL;
		start = n;
		top = n;
	}
	else {
		top->next = n;
		n->next = NULL;
		n->prev = top;
		top = n;
	}
}

void topelement()
{
    if (start == NULL)
        printf("Stack is empty");
    else
        printf(
            "The element at top of the stack is : %d   \n",
            top->data);
}

void stacksize()
{
    int c = 0;
    if (start == NULL)
        printf("Stack is empty");
    else {
        struct Node* ptr = start;
        while (ptr != NULL) {
            c++;
            ptr = ptr->next;
        }
    }
    printf("Size of the stack is : %d \n ", c);
}

void pop()
{
	struct Node* n;
	n = top;
	if (start == NULL)
		printf("Stack is empty");
	else if (top == start) {
		top = NULL;
		start = NULL;
		free(n);
	}
	else {
		top->prev->next = NULL;
		top = n->prev;
		free(n);
	}
}

void display()
{
	if (start == NULL)
		printf("Stack is empty");
	else {
		struct Node* ptr = start;
		printf("Stack is : ");
		while (ptr != NULL) {
			printf("%d ", ptr->data);
			ptr = ptr->next;
		}
		printf("\n");
	}
}

void main()
{ 
    printf("Prerna Sunil Jadhav - 60004220127\n");
	int ch,n;
	display();
	A:printf("\nEnter The operation you want to perform \n1) PUSH \n2) POP \n3) Exit \n");
    scanf("%d", &ch);
    switch (ch)
    {
        case 1:
        {
            printf("\nEnter an element:");
			scanf("%d", &n);
			push(n);
            printf("\nAfter Pushing ");
			topelement();
			stacksize();
            display();
            goto A;
        }

        case 2:
        {
            pop();
            printf("\nAfter deletion ");
           	display();
            goto A;
        }
    }
} 
