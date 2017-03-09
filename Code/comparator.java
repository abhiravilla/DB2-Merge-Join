package merge_join;
import java.util.Arrays;

import java.util.List;

public class comparator {
	
	public String[][] compare(String[][]a,int key){
		//len and len 2 are needed to create the result array
		//check is to check if the values at that particular array is already present in the result array
		int len=a.length,len2=a[0].length,check=0,k,l=-1;
		String[][] result=new String[len][len2];
		//Array of index values already present in the result 
		int[] index=new int[len];
		//Initializing the array to -1
		Arrays.fill(index,-1);
		//The array that is sorted
		String temp[]=new String[len];
		for(int i=0;i<len;i++){
			temp[i]=a[i][key];
		}
		//The array that is referred for every value in temp to get its position before sorting
		String[] temp3= Arrays.copyOf(temp, len);
		Arrays.sort(temp);
		for(int i=0;i<len;i++){
			for(k=0;k<len;k++){
				check=0;
				//Checking if the key values are equal
				if(temp[i].compareToIgnoreCase(temp3[k])==0){
					//checking if the equaled value is in the result
					for(l=0;l<len;l++){
						if(index[l]==k){
							//Since it is in the result change check to 1 so it is skipped
							check=1;
							break;
						}
						if(index[l]==-1)
							//reaches end of the correct values in the result
							break;
					}				
				if(check==1){
					//Skip the value in temp3
					continue;
				}
				else{
					if(l!=len&&l!=-1){
						index[l]=k;
						break;
					}
				}
			}
			}
			if(k!=len+1){
			result[i]=a[k];
			}
		}
			return result;
	}
}
