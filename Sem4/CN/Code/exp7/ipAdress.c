#include<stdio.h>
#include<string.h>

char findClass(char str[])
{
	char arr[5];
	int i = 0;
	while (str[i] != '.')
	{
		arr[i] = str[i];
		i++;
	}
	i--;
	int ip = 0, j = 1;
	while (i >= 0)
	{
		ip = ip + (str[i] - '0') * j;
		j = j * 10;
		i--;
	}

	if (ip >=1 && ip <= 127)
		return 'A';

	else if (ip >= 128 && ip <= 191)
		return 'B';

	else if (ip >= 192 && ip <= 223)
		return 'C';

	else if (ip >= 224 && ip <= 239)
		return 'D';

	else if (ip >= 240 && ip <= 254)
		return 'E';
    
    else
        printf("Invalid IP");
        
    return 'Z';
}

int main()
{
	char str[] = {};
	printf("Enter an IP Address: ");
	scanf("%[^\n]s",str);
	char ipClass = findClass(str);
	printf("IP Address: %s\n", str);
	if (ipClass != 'Z'){
	    printf("Given IP address belongs to Class %c\n", ipClass);
	}
	
	return 0;
}