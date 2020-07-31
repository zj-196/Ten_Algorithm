package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GreedyAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HashMap<String, HashSet> broadcasts = new HashMap<String, HashSet>();
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("广州");
		hashSet2.add("北京");
		hashSet2.add("深圳");
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("上海");
		hashSet4.add("天津");
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("杭州");
		hashSet5.add("大连");
		broadcasts.put("K1", hashSet1);
		broadcasts.put("K2", hashSet2);
		broadcasts.put("K3", hashSet3);
		broadcasts.put("K4", hashSet4);
		broadcasts.put("K5", hashSet5);
		
		HashSet<String> allAreas = new HashSet<String>();
		for(int i=0;i<broadcasts.size();i++) {
			HashSet<String> hashSet = (HashSet) broadcasts.get("K"+(i+1));
			for(String str:hashSet) {
				allAreas.add(str);
			}
		}
		
		ArrayList<String> list = new ArrayList<String>();
		HashSet<String> tempArea = new HashSet<String>();
		String maxKey;
		while(allAreas.size()>0) {
			maxKey = null;
			for(String key:broadcasts.keySet()) {
				tempArea.clear();
				tempArea.addAll(broadcasts.get(key));
				tempArea.retainAll(allAreas);
				if(tempArea.size()>0&&(maxKey==null||tempArea.size()>broadcasts.get(maxKey).size())) {
					maxKey=key;
				} 
			}
				if(maxKey!=null) {
					list.add(maxKey);
					allAreas.removeAll(broadcasts.get(maxKey));
				}
			}
		System.out.println(list);
	}
	
}
