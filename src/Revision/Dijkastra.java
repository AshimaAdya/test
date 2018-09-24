package Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkastra 
{
	public static void main(String args[]) throws IOException
	{
		int n=14;
		int m=10;
		System.out.println("Enter::");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> adj[]=new ArrayList[m];
		for(int i=1;i<m;i++)
		{
			adj[i]=new ArrayList();
		}
		while(n-->0)
		{
			String t[]=br.readLine().split(" ");
			int s=Integer.parseInt(t[0]);
			int d=Integer.parseInt(t[1]);
			int w=Integer.parseInt(t[2]);
			int temp[]=new int[2];
			temp[0]=s;
			temp[1]=w;
			adj[d].add(temp);
			
			 temp=new int[2];
			temp[0]=d;
			temp[1]=w;
			adj[s].add(temp);
		}
			int dist[]=new int[m];
			for(int i=2;i<m;i++)
			{
				dist[i]=Integer.MAX_VALUE;
			}
			dist[1]=0;
			
			PriorityQueue<int[]> q=new PriorityQueue<int[]>(m,new Comparator<int[]>()
					{
				public int compare(int[]o1,int o2[])
				{
					return o1[1]-o2[1];
				}
					}) ;
			
			int p[]=new int[2];
			p[0]=1;
			p[1]=0;
			q.add(p);
			
			while(!q.isEmpty())
			{
				int ele[]=q.remove();
				int pare=ele[0];
			    int size=adj[pare].size();
			    for(int i=0;i<size;i++)
			    {
			    	int e[]=adj[pare].get(i);
			    	int cval=e[0];
			    	int cwt=e[1];
			    	if(dist[cval]>dist[pare]+cwt)
			    	{
			    		dist[cval]=dist[pare]+cwt;
			    		int ct[]=new int[2];
			    		ct[0]=cval;
			    		ct[1]=dist[cval];
			    		q.add(ct);
			    	}
			    }
			}
			
			for(int i=1;i<m;i++)
			{
				System.out.print(dist[i]+" ");
			}
			
			
		
	}

}
