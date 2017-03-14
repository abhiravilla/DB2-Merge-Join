package merge_join;
import java.util.Arrays;

import java.util.List;

public class merge_join {
	String outer[][],inner[][];
	int okey=0,ikey=0,ib=0,ob=0,it=0,ot=0,len=0,len2=0,os=0,is=0;
	String[][] sub_array;
	int los=0,lis=0,rp=0;
	String result[][];
	void merge(String outer[][],String inner[][],int okey,int ikey,int ot,int it,int os,int is){
		 int ob=0,ib=0;
		 len=outer[0].length;
		 len2=inner[0].length;
	     this.outer=outer;
	     this.inner=inner;
	     this.okey=okey;
	     this.ikey=ikey;
	     this.ot=ot;
	     this.it=it;
	     this.os=os;
	     this.is=is;
	     sub_array=new String[2*it][len2];
	     result=new String[os*is][len+(len2-1)];
	     System.out.println("In join class");
		 System.out.println("Outer relation size "+os+" tuple size "+ot+" inner relation size "+is+" tuple size "+it);
		 while(los<=os||lis<=is){
			 if(los%ot*2==0&&lis%it*2==0){
				 System.out.println("Getting the "+ob+" and "+(ob+1)+" of outer relation and "+ib+" and "+(ib+1)+" of inner relation");
				 ob=ob+2;
				 ib=ib+2;
				 join(create_array("O",los,(los+(2*ot-(los%2*ot)))),create_array("I",lis,(lis+(2*it-(lis%2*it)))));
			 }
			 else if(los%ot*2==0){
				 System.out.println("Getting the "+ob+" and "+(ob+1)+" of outer relation");
				 ob=ob+2;
				 join(create_array("O",los-1,(los+(2*ot-(los%2*ot)))),create_array("I",lis,(lis+(2*it-(lis%2*it)))));
			 }
			 else{
				 System.out.println("Getting the "+ib+" and "+(ib+1)+" of inner relation");
				 ib=ib+2;
				 join(create_array("O",los-1,(los+(2*ot-(los%2*ot)))),create_array("I",lis,(lis+(2*it-(lis%2*it)))));
			 }
		 }
		 System.out.println("Completed join class");
	}
	
	void join(String[][] outer,String inner[][]){
			String output[][] = new String[5][len+(len2-1)];
			int os=outer.length,is=inner.length;
			boolean done=false;
			int o=0,i=0,j=0,si=0;
			while((is-i)!=0&&(os-o)!=0){
				sub_array[si]=inner[i];
				String key=sub_array[0][ikey];
				System.out.println(key);
				si++;
				i++;
				lis++;
				done=false;
			while((is-i)!=0&&!done){
				if(key==inner[i][ikey]){
					sub_array[si]=inner[i];
					i++;
					lis++;
					si++;
				}
				else
					done=true;
			}
			while((os-o)!=0&&(outer[o][okey].compareToIgnoreCase(key)<0)){
				o++;
				los++;
			}
			while((os-o)!=0&&(outer[o][okey].compareToIgnoreCase(key)==0)){
				int l=0;
				for(l=0;l<si;l++){
						for(int u=0;u<len;u++)
							output[j][u]=outer[o][u];
						for(int k=0;k<len2;k++){			
						if(k!=ikey){
							output[j][len+k]=sub_array[l][k];
							sub_array[l][k]=null;
						}
						sub_array[l][ikey]=null;
						}
						
						j++;
						if(j==5){
							System.out.println("Output block filled\n");
							for(int k=0;k<5;k++){
								for(int s=0;s<len+(len2-1);s++){
									System.out.print(output[k][s]+"\t");
									output[k][s]=null;
								}
								System.out.print("\n");
							}
							j=0;
						}
				}
				o++;
				los++; 	
				}
				si=0;
			}			
			if(j!=0){
				for(int k=0;k<j;k++){
					for(int s=0;s<len+(len2-1);s++){
						System.out.print(output[k][s]+"\t");
						output[k][s]=null;
					}
					System.out.print("\n");
				}
				j=0;
			}
	}
	String[][] create_array(String s,int start,int ends){
		int j=0;
	//	System.out.println(start);
		//System.out.println(ends);
		if(s.compareTo("O")==0){
			if(ends>os)
				ends=os;
			String result[][]=new String[(ends-start)][len];
			for(int i=start;i<ends;i++){
					result[j]=outer[i];
					j++;
			}
			return result;
		}
		if(s.compareTo("I")==0){
			if(ends>is)
				ends=os;
			String result[][]=new String[(ends-start)][len];
			for(int i=start;i<ends;i++){
				result[j]=inner[i];
					j++;
			}
			return result;
		}
		return null;
	}
		
	}

