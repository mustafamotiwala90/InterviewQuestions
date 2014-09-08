//Remove 'b' and 'ac' from string in-place

void removeBandAC(char *p, int size)
{
	int i = 0;
	int j = 0;

	while( i < size )
	{
		if (p[i] == 'b')
		{
			i++;
		}
		else if ((p[i] == 'a') &&  (i+1 < size) && (p[i+1] == 'c'))
		{
			i += 2;
		}
		else
		{
			if (i != J) swap(p[i], p[j]);
			i++;
			j++;
		}
	}

	p[j] = '\0';
}
