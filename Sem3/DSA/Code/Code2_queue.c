#include <stdio.h>
#include <stdlib.h>
//Implement queue using doubly linked list
typedef struct QNode
{
	int data;
	struct QNode * next;
	struct QNode * prev;
}QNode;

typedef struct MyQueue
{
	struct QNode * front;
	struct QNode * rear;
	int size;
}MyQueue;

QNode * getQNode(int data, QNode * prev)
{
	QNode * ref = (QNode * ) malloc(sizeof(QNode));
	if (ref == NULL)
	{
		return NULL;
	}
	ref->data = data;
	ref->next = NULL;
	ref->prev = prev;
	return ref;
}
MyQueue * getMyQueue()
{
	MyQueue * ref = (MyQueue * ) malloc(sizeof(MyQueue));
	if (ref == NULL)
	{
		return NULL;
	}
	ref->front = NULL;
	ref->rear = NULL;
	return ref;
}
void enqueue(MyQueue * ref, int data)
{
	QNode * node = getQNode(data, ref->rear);
	if (ref->front == NULL)
	{
		ref->front = node;
		ref->size = 1;
	}
	else
	{
		ref->rear->next = node;
		ref->size = ref->size + 1;
	}
	ref->rear = node;
}
int isEmpty(MyQueue * ref)
{
	if (ref->size == 0)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}
int peek(MyQueue * ref)
{
	if (isEmpty(ref) == 1)
	{
		printf("\n Empty Queue");
		return -1;
	}
	else
	{
		return ref->front->data;
	}
}
int isSize(MyQueue * ref)
{
	return ref->size;
}
int dequeue(MyQueue * ref)
{
	if (isEmpty(ref) == 1)
	{
		return -1;
	}
	else
	{
		int data = peek(ref);
		QNode * temp = ref->front;
		if (ref->front == ref->rear)
		{
			ref->rear = NULL;
			ref->front = NULL;
		}
		else
		{
			ref->front = ref->front->next;
			ref->front->prev = NULL;
		}
		ref->size--;
		return data;
	}
}

void printQdata(MyQueue * ref)
{
	QNode * node = ref->front;
	printf("\n Queue Element\n");
	while (node != NULL)
	{
		printf(" %d", node->data);
		node = node->next;
	}
	printf("\n");
}
int main()
{
    printf("Prerna Sunil Jadhav - 60004220127\n");
	MyQueue * q = getMyQueue();
	enqueue(q, 1);
	enqueue(q, 2);
	enqueue(q, 3);
	enqueue(q, 4);
	enqueue(q, 5);
	printQdata(q);
	printf(" Size : %d", isSize(q));
	printf("\n Dequeue Node : %d", dequeue(q));
	printf("\n Dequeue Node : %d", dequeue(q));
	printf("\n Dequeue Node : %d", dequeue(q));
	printQdata(q);
	printf(" Size : %d\n", isSize(q));
  	return 0;
}
