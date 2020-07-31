package horse;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChess {

	private static int X;
	private static int Y;
	private static boolean[] isVisited;
	private static boolean isfinished;
	
	public static void main(String[] args) {
		X = 8;
		Y = 8;
		int row = 1;
		int column = 5; 
		int[][] chess = new int[X][Y];
		isVisited = new boolean[X*Y];
		long start = System.currentTimeMillis();
		horseChess(chess, row-1, column-1, 1);
		long end = System.currentTimeMillis();
		System.out.println("需要："+(end-start)+"毫秒");
		for(int[] arr:chess) {
			for(int step:arr) {
				System.out.print(step+"\t");
			}
			System.out.println();
		}
	}
	
	public static void horseChess(int[][] chess,int row,int column,int step) {
		chess[row][column] = step;
		isVisited[row*X+column] = true;
		ArrayList<Point> list = nextPoint(new Point(column,row));
		sort(list);
		while(!list.isEmpty()) {
			Point p1 = list.remove(0);
			if(!isVisited[p1.y*X+p1.x]) {
				horseChess(chess, p1.y, p1.x, step+1);
			}
		}
		if(step<X*Y&&!isfinished) {
			chess[row][column]=0;
			isVisited[row*X+column] = false;
		}else {
			isfinished=true;
		}
		
	}
	
	public static ArrayList<Point> nextPoint(Point point){
		ArrayList<Point> ps = new ArrayList<Point>();
		Point p = new Point();
		if((p.x=point.x-2)>=0&&(p.y=point.y-1)>=0) {
			ps.add(new Point(p));
		}
		if((p.x=point.x-1)>=0&&(p.y=point.y-2)>=0) {
			ps.add(new Point(p));
		}
		if((p.x=point.x+1)<X&&(p.y=point.y-2)>=0) {
			ps.add(new Point(p));
		}
		if((p.x=point.x+2)<X&&(p.y=point.y-1)>=0) {
			ps.add(new Point(p));
		}
		if((p.x=point.x+2)<X&&(p.y=point.y+1)<Y) {
			ps.add(new Point(p));
		}
		if((p.x=point.x+1)<X&&(p.y=point.y+2)<Y) {
			ps.add(new Point(p));
		}
		if((p.x=point.x-1)>=0&&(p.y=point.y+2)<Y) {
			ps.add(new Point(p));
		}
		if((p.x=point.x-2)>=0&&(p.y=point.y+1)<Y) {
			ps.add(new Point(p));
		}
		return ps;
	}
	
	public static void sort(ArrayList<Point> ps) {
		ps.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				int count1 = nextPoint(o1).size();
				int count2 = nextPoint(o2).size();
				return count1-count2;
			}
		});
		
	}
	
}


