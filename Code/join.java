package merge_join;

public class join {
	void merge(String outer[][],String inner[][],int okey,int ikey,int ot,int it,int os,int is){
		//To count number of the block parsing
		System.out.println("Outer relation size "+os+" inner relation size "+is);
		int ob=1,ib=1;
		int len=outer[0].length;
		String output[][]=new String[5][len];
		System.out.println();
		//To get the particular block of the relations.......o is outer and i is inner
		int o=0,i=0,j=0;
		//Getting maximum number of tuples for every relation every time until one of the relation reaches last block 
	//	for(o=0,i=0;o<os&i<is;o+=(ot-1),i+=(it-1)){
		while(o<os&&i<is){
			if(outer[o][okey].compareToIgnoreCase(inner[i][ikey])==0){
				System.out.println(outer[o][okey]);
				output[j]=outer[o];
				o++;
				i++;
				j++;
			}
			else if(outer[o][okey].compareToIgnoreCase(inner[i][ikey])>0){
				i++;
			}
			else{
				o++;
			}
			
			if(ob%2==1&&(o)%(2*ot)==1&&o!=1){
				System.out.println("Block number  "+ob+" tuple number "+o);
				System.out.println("Getting next two blocks of outer relation");
			}
			if(ib%2==1&&(i)%(2*it)==1&&i!=1){
				System.out.println("Block number  "+ib+" tuple number "+i);
				System.out.println("Getting next two blocks of inner relation");
			}
			if(o%ot==1&&o!=1){
				ob++;
				System.out.println("Block number  "+ob+" tuple number "+o);
				System.out.println("parsing through block "+ob+" of outer relation");
			}
			if(i%it==1&&i!=1){
				ib++;
				System.out.println("Block number  "+ib+" tuple number "+i);
				System.out.println("parsing through block "+ib+" of outer relation");
			}
			if(j==5){
				System.out.println("Output block filled\n");
				for(int k=0;k<5;k++){
					for(int l=0;l<len;l++){
						System.out.println(output[k][l]+"\t");
					}
					System.out.println("\n");
				}
				j=0;
			}
		}
		
			System.out.println("Join Completed\n");
			for(int k=0;k<j;k++){
				for(int l=0;l<len;l++){
					System.out.println(output[k][l]+"\t");
				}
				System.out.println("\n");
			}
			j=0;
		
	  //}
	}
}
