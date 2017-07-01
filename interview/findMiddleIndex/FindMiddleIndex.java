/**
 * Find out middle index where sum of both ends are equal.
 * 
 * You are given an array of numbers. 
 * Find out the array index or position where sum of numbers preceeding the index
 * is equals to sum of numbers succeeding the index.
 * 
 * http://www.java2novice.com/java-interview-programs/find-middle-index/
 * 
 */
 //package findMiddleIndex;

/**
 * @author John
 *
 */
class FindMiddleIndex {
	private static int[] numbers = {10,40,20,30,20};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int a : numbers) {
			System.out.printf("%3d,",a);
		}
		System.out.println();
		
		int idx = 0;
		while(idx<numbers.length&&sum(numbers,0,idx)!=sum(numbers,idx,numbers.length-1)){
			idx++;
		}
		System.out.println(idx==numbers.length?"It's not such index":"Index between 0 and "+(numbers.length-1)+": "+idx);

	}

	public static int sum(int[] num,int fromIdx, int toIdx){
		if(fromIdx>toIdx){
			int x=fromIdx;
			fromIdx=toIdx;
			toIdx = x;
		}
		int sumOfNum=0;
		for (int i = fromIdx; i <= toIdx; i++) {
			sumOfNum+=num[i];
		}
		return sumOfNum;
	}
}
