// Majority Voting classifier for the K-nearest Machine Learning problem
class MajorityVoting {
    public static void main(String[] args) {
        int[] number = new int[]{-1, 2 , 9};
        System.out.println("Majority candidate is : " + findCandidate(number, number.length));
    }

    public static int findCandidate(int[] numbers, int size) {
    	int maj_index = 0;
    	int count = 1;
    	for(int i = 1; i <= size - 1; i++) {
    		if(numbers[maj_index] == numbers[i]) {
    			count ++;
    		} else {
    			count --;
    		}
    		if(count == 0) {
    			maj_index = i;
    			count = 1;
    		}
    	}
    	return numbers[maj_index];
    }
}
