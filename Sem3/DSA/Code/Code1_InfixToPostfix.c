#include <stdio.h>
#include <string.h>
#include <ctype.h>
// program to convert infix to postfix
int top = -1;
char stack[100];

void push(char a)
{
    top++;
    stack[top] = a;
}

char pop()
{
    if (top == -1)
        return -1;
    else
        return stack[top--];
}

int prior(char a)
{
    if (a == '(')
        return 0;
    if (a == '+' || a == '-')
        return 1;
    if (a == '*' || a == '/')
        return 2;
    if (a == '^')
        return 3;
    return 0;
}

int main()
{
    printf("Prerna Jadhav - 60004220127\n");
    char expr[100];
    char x;
    int i;
    printf("Enter your exprression: ");
    scanf("%s", expr);
    for (i = 0; i < strlen(expr); i++)
    {
        if (isalnum(expr[i]))
        {
            printf("%c ", expr[i]);
        }
        else
        {
            if (expr[i] == '(')
                push(expr[i]);
            else if (expr[i] == ')')
            {
                while ((x = pop()) != '(')
                {
                    printf("%c ", x);
                }
            }
            else
            {
                while (prior(expr[i]) <= prior(stack[top]))
                    printf("%c ", pop());
                push(expr[i]);
            }
        }
    }
    while (top != -1)
    {
        printf("%c ", pop());
    }
    return 0;
}
