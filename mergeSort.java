public static int[] mergeSort(int [] m)
	{
		int len = m.length;
		if (len <= 1)
				return m;
		int[] left = new int[len/2];
		int[] right;
		//if odd, add an extra slot in array
		if(len % 2 != 0)
			right = new int[(len/2) + 1];	
		else
			right = new int[len/2];
		int mid = m.length / 2;
		for (int i = 0; i < mid; i++)
			left[i] = m[i];
		for (int j = 0; j < right.length; j++)
			right[j] = m[j + mid];
		
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}
	
	private static int[] merge(int[] left, int[] right)
	{
		int [] result = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		while ( left.length != i || right.length != j)
		{
			if( left.length != i && right.length != j )
			{
				if( left[i] <= right[j])
					result[i + j] = left[i++];
				else
					result[i + j] = right[j++];
			}
			else if( left.length == i)	
				result[i + j] = right[j++];		
			else
				result[i + j] = left[i++];
			
		}
		return result;
	}
	