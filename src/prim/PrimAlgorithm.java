package prim;

import java.util.Arrays;

public class PrimAlgorithm {

	public static void main(String[] args) {
		char[] data = new char[]{'A','B','C','D','E','F','G'};
		int verx = data.length;
		int [][]weight=new int[][]{
            {10000,5,7,10000,10000,10000,2},
            {5,10000,10000,9,10000,10000,3},
            {7,10000,10000,10000,8,10000,10000},
            {10000,9,10000,10000,10000,4,10000},
            {10000,10000,8,10000,10000,5,4},
            {10000,10000,10000,4,5,10000,6},
            {2,3,10000,10000,4,6,10000},};
        Graph graph = new Graph(verx);
        MinTree tree = new MinTree();
        tree.createGraph(graph, verx, data, weight);
        tree.showGraph(graph);
        tree.primAlgorithm(graph, 0);
	}

}

class MinTree{
	
	public void primAlgorithm(Graph graph,int v) {
		boolean[] isFlag = new boolean[graph.verx];
		isFlag[v] = true;
		int h1=-1,h2=-1;
		int maxValue = 10000;
		for(int k=1;k<graph.verx;k++) {
			for(int i=0;i<graph.verx;i++) {
				for(int j=0;j<graph.verx;j++) {
					if(isFlag[i]&&!isFlag[j]&&graph.weight[i][j]<maxValue) {
						maxValue=graph.weight[i][j];
						h1=i;
						h2=j;
					}
				}
			}
			System.out.println(graph.data[h1]+"->"+graph.data[h2]+",权值为:"+maxValue);
			isFlag[h2] = true;
			maxValue = 10000;
		}
	}
	
	public void createGraph(Graph graph,int verx,char[] data,int[][] weight) {
		for(int i=0;i<verx;i++) {
			graph.data[i] = data[i];
			for(int j=0;j<verx;j++) {
				graph.weight[i][j] = weight[i][j];
			}
		}
	}
	
	public void showGraph(Graph graph) {
		for(int[] arr:graph.weight) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
}

class Graph{
	
	int verx;
	char[] data;
	int[][] weight;
	
	public Graph(int verx){
		this.verx = verx;
		data = new char[verx];
		weight = new int[verx][verx];
	}
	
}