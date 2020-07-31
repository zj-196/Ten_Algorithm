package kruskal;

import java.util.Arrays;

public class KruskalAlgorithm {

	private char[] verx;
	private int[][] weight;
	private static int edageNum;
	private static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		char[] verx = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		//克鲁斯卡尔算法的邻接矩阵  
	      int matrix[][] = {
	      /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
	/*A*/ {   0,  12, INF, INF, INF,  16,  14},
	/*B*/ {  12,   0,  10, INF, INF,   7, INF},
	/*C*/ { INF,  10,   0,   3,   5,   6, INF},
	/*D*/ { INF, INF,   3,   0,   4, INF, INF},
	/*E*/ { INF, INF,   5,   4,   0,   2,   8},
	/*F*/ {  16,   7,   6, INF,   2,   0,   9},
	/*G*/ {  14, INF, INF, INF,   8,   9,   0}}; 
		KruskalAlgorithm kruskal = new KruskalAlgorithm(verx, matrix);
		System.out.println("邻接矩阵为：");
		kruskal.show(matrix);
		System.out.println("边的数目："+edageNum);
		EData[] edges = kruskal.getEdges();
		System.out.println("排序前："+Arrays.toString(edges));
		kruskal.sortEdges(edges);
		System.out.println("排序后："+Arrays.toString(edges));
		kruskal.kruskal();
	}
	
	public KruskalAlgorithm(char[] verx,int[][] weight) {
		this.verx = new char[verx.length];
		for(int i=0;i<verx.length;i++) {
			this.verx[i]=verx[i];
		}
		this.weight = new int[verx.length][verx.length];
		for(int j=0;j<weight.length;j++) {
			for(int k=0;k<weight[0].length;k++) {
				this.weight[j][k]=weight[j][k];
			}
		}
		for(int i=0;i<weight.length;i++) {
			for(int j=i+1;j<weight[0].length;j++) {
				if(weight[i][j]!=INF) {
					edageNum++;
				}
			}
		}
	}
	
	private void show(int[][] weight) {
		for(int i=0;i<weight.length;i++) {
			for(int j=0;j<weight[0].length;j++) {
				System.out.printf("%12d",weight[i][j]);
			}
			System.out.println();
		}
	}
	
	private int getChar(char c) {
		for(int i=0;i<verx.length;i++) {
			if(verx[i]==c) {
				return i;
			}
		}
		return -1;
	}
	
	private EData[] getEdges(){
		EData[] eData = new EData[edageNum];
		int index = 0;
		for(int i=0;i<verx.length;i++) {
			for(int j=i+1;j<verx.length;j++) {
				if(weight[i][j]!=INF) {
					eData[index]=new EData(verx[i],verx[j],weight[i][j]);
					index++;
				}
			}
		}
		return eData;
	}
	
	private void sortEdges(EData[] eData) {
		for(int i=0;i<eData.length-1;i++) {
			for(int j=0;j<eData.length-1-i;j++) {
				if(eData[j].w>eData[j+1].w) {
					EData temp = eData[j];
					eData[j] = eData[j+1];
					eData[j+1] = temp;
				}
			}
		}
	}
	
	private int getEnd(int[] ends,int i){
		while(ends[i]!=0) {
			i=ends[i];
		}
		return i;
	}
	
	private void kruskal() {
		int index = 0;
		int[] ends = new int[edageNum];
		EData[] res = new EData[edageNum];
		EData[] edges = getEdges();
		sortEdges(edges);
		for(int i=0;i<res.length;i++) {
			int p1 = getChar(edges[i].start);
			int p2 = getChar(edges[i].end);
			int m = getEnd(ends, p1);
			int n = getEnd(ends, p2);
			if(m!=n) {
				ends[m]=n;
				res[index]=edges[i];
				index++;
			}
		}
		for(int i=0;i<index;i++) {
			System.out.println(res[i]);
		}
	}

}

class EData{
	char start;
	char end;
	int w;
	public EData(char start, char end, int weight) {
		this.start = start;
		this.end = end;
		this.w = weight;
	}
	@Override
	public String toString() {
		return "EData [start=" + start + ", end=" + end + ", weight=" + w + "]";
	}
	
}