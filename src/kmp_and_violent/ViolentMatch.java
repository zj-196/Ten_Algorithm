package kmp;

public class ViolentMatch {

	public static void main(String[] args) {
		String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
		String str2 = "尚硅谷你尚硅你";
		int i = violentMatch(str1, str2);
		System.out.println(i);
	}
	
	public static int violentMatch(String str1,String str2) {
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int i = 0;
		int j = 0;
		while(i<str1.length()&&j<str2.length()) {
			if(c1[i]==c2[j]) {
				i++;
				j++;
			}else {
				i=i-(j-1);
				j=0;
			}
		}
		if(j==str2.length()) {
			return i-j;
		}else {
			return -1;
		}
	}
	
}
