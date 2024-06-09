#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
typedef struct link
{
    int data;
    struct link *next;
} node;

void insert_begin(node **temp, int num);
void insert_mid(node **temp, int num, int index);
void insert_end(node **temp, int num);

void delete_beg(node **temp);
void delete_mid(node **temp, int index);
void delete_end(node **temp);

void sort(node *start); 
void swap(node *a, node *b);
void search_link(node **temp,int x);

void dis(node *ptr);

void main()
{
    int num, ch,x ,n, i, index;
    char chh;
    node *start, *ptr, *temp;
    printf("Prerna Jadhav - 60004220127\n");
    printf("Enter the number of nodes you want to insert: \n");
    scanf("%d", &n);
    printf("Values for nodes:");
    for (i = 0; i < n; i++)
    {
        if (i == 0)
        {
            scanf("%d", &num);
            start = (node *)malloc(sizeof(node));
            start->data = num;
            start->next = NULL;
            temp = start;
        }
        else
        {
            scanf("%d", &num);
            ptr = (node *)malloc(sizeof(node));
            ptr->data = num;
            ptr->next = NULL;
            temp->next = ptr;
            temp = ptr;
        }
    }
    dis(start);
A:
    printf("\nEnter The operation you want to perform \n1) Insertion \n2) Deletion \n3) Search \n4) Sort \n5) Exit \n");
    scanf("%d", &ch);
    switch (ch)
    {
    case 1:
    {
        printf("\n\nWhere to perform operation \na) Begining \nb) Middle \nc) End \n");
        scanf("%s", &chh);
        switch (chh)
        {
        case 'a':
        {
            printf("\nEnter the element to be inserted at begining:\n");
            scanf("%d", &num);
            insert_begin(&start, num);
            dis(start);
            goto A;
        }

        case 'b':
        {
            printf("\nEnter the index where to put the node: ");
            scanf("%d", &index);
            printf("Enter the element to be inserted at that index:\n");
            scanf("%d", &num);
            insert_mid(&start, num, index);
            dis(start);
            goto A;
        }

        case 'c':
        {
            printf("\nEnter the element to be inserted at end:\n");
            scanf("%d", &num);
            insert_end(&start, num);
            dis(start);
            goto A;
        }
        }
    }
    case 2:
    {
        printf("\n\nWhere to perform operation \na) Begining \nb) Middle \nc) End \n");
        scanf("%s", &chh);
        switch (chh)
        {
        case 'a':
        {
            delete_beg(&start);
            printf("\nLink list after deletion at begining: \n");
            dis(start);
            goto A;
        }

        case 'b':
        {
            printf("\nEnter the number of node to be deleted:\n");
            scanf("%d", &index);
            delete_mid(&start, index);
            dis(start);
            goto A;
        }

        case 'c':
        {
            delete_end(&start);
            printf("\nLink list after deletion at end: \n");
            dis(start);
            goto A;
        }
        }
    }
    case 3:
    {
        printf("Enter the number to be searched; ");
        scanf("%d", &x);
        search_link(&start, x);
        goto A;
    }
    case 4:{
    sort(start); 
    printf("\n Linked list after sorting "); 
    dis(start); 
    }

    }
    getch();
}

void insert_begin(node **temp, int num)
{
    node *ptr;
    ptr = (node *)malloc(sizeof(node));
    ptr->data = num;
    if (*temp == NULL)
        ptr->next = NULL;
    else
        ptr->next = *temp;
    *temp = ptr;
}
void insert_mid(node **temp, int num, int index)
{
    node *ptr, *loc;
    int i;
    ptr = (node *)malloc(sizeof(node));
    ptr->data = num;
    if (*temp == NULL)
    {
        ptr->next = NULL;
        *temp = ptr;
        return;
    }
    loc = *temp;
    while (i < index - 1)
    {
        *temp = (*temp)->next;
        if (*temp == NULL)
        {
            printf("array size exceeded");
            return;
        }
        i++;
    }
    ptr->next = loc->next;
    loc->next = ptr;
}
void insert_end(node **temp, int num)
{
    node *ptr, *loc;
    ptr = (node *)malloc(sizeof(node));
    ptr->data = num;
    ptr->next = NULL;

    loc = *temp;
    while (loc->next != NULL)
    {
        loc = loc->next;
    }
    loc->next = ptr;
}

void delete_mid(node **temp, int index)
{
    int i = 0;
    node *loc, *prev;
    loc = *temp;
    if (*temp == NULL)
    {
        printf("THERE ARE NO NODES-");
        return;
    }
    while (i < index - 1)
    {
        prev = loc;
        loc = loc->next;
        i++;
    }
    prev->next = loc->next;
    free(loc);
}
void delete_end(node **temp)
{
    node *loc, *prev;
    loc = *temp;
    if (*temp == NULL)
    {
        printf("THERE ARE NO NODES-");
        return;
    }
    while (loc->next != NULL)
    {
        prev = loc;
        loc = loc->next;
    }
    prev->next = loc->next;
    free(loc);
}
void delete_beg(node **temp)
{
    node *loc;
    if (*temp == NULL)
    {
        printf("THERE ARE NO NODES-");
        return;
    }
    loc = *temp;
    *temp = loc->next;
    free(loc);
}

void search_link(node **temp, int x)
{
    node *loc;
    loc = *temp;
    while (loc != NULL)
    {
        if (loc->data == x)
        {
            printf("Element is present.");
            return;
        }
        loc = loc->next;
    }
    printf("Element is not present.");
}

void dis(node *ptr)
{
    while (ptr != NULL)
    {
        printf("%d\t", ptr->data);
        ptr = ptr->next;
    }
}

void sort(node *start) 
{ 
    int swapped, i; 
    node *ptr1; 
    node *lptr = NULL; 
    if (start == NULL) 
        return; 
    do
    { 
        swapped = 0; 
        ptr1 = start; 
  
        while (ptr1->next != lptr) 
        { 
            if (ptr1->data > ptr1->next->data) 
            { 
                swap(ptr1, ptr1->next); 
                swapped = 1; 
            } 
            ptr1 = ptr1->next; 
        } 
        lptr = ptr1; 
    } 
    while (swapped); 
} 
  
void swap(node *a,node *b) 
{ 
    int temp = a->data; 
    a->data = b->data; 
    b->data = temp; 
}
