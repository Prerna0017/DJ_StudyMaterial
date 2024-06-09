#include <stdio.h>
#include <stdlib.h>
typedef struct node
{
    int data;
    struct node *left, *right;
} node;

void btree(int a[], int n);
node *create_tree(int a[], int n);
void inorder(struct node *root);
void preorder(struct node *root);
void posorder(struct node *root);

void main()
{
    printf("Prerna Sunil Jadhav - 60004220127\n");

    int n, i;
    int a[100];
    printf("Enter number of nodes: \n");
    scanf("%d", &n);
    printf("Enter elements: \n");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    btree(a, n);
}

void btree(int a[], int n)
{
    node *root;
    root = create_tree(a, n);
    printf("\nInorder: ");
    inorder(root);
    printf("\nPostorder: ");
    posorder(root);
    printf("\nPreorder: ");
    preorder(root);
}
node * create_tree(int a[], int n)
{
    node *p, *prev, *ptr, *root;
    int i, flag;
    root = (node *)malloc(sizeof(node));
    root->data = a[0];
    root->left = NULL;
    root->right = NULL;
    for (i = 1; i < n; i++)
    {
        ptr = (node *)malloc(sizeof(node));
        ptr->data = a[i];
        ptr->left = NULL;
        ptr->right = NULL;
        p = root;
        while (p != NULL)
        {
            prev = p;
            if (a[i] < p->data)
            {
                p = p->left;
                flag = 1;
            }
            else
            {
                p = p->right;
                flag = 0;
            }
        }
        if (flag == 1)
            prev->left = ptr;
        else
            prev->right = ptr;
    }
    return (root);
}

void inorder(node *root)
{
    if (root != NULL)
    {
        inorder(root->left);
        printf("%d\t", root->data);
        inorder(root->right);
    }
}

void preorder(node *root)
{
    if (root != NULL)
    {
        printf("%d\t", root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

void posorder(node *root)
{
    if (root != NULL)
    {
        posorder(root->left);
        posorder(root->right);
        printf("%d\t", root->data);
    }
}
