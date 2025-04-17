public class Mergesort {
	public static void main(String[] args) {
		if (args.length >= 1) {
			try {
				int[] unsortedList = new int[Integer.parseInt(args[0])];
				for (int i = 1; i < args.length; i++) {
					unsortedList[i - 1] = Integer.parseInt(args[i]);
				}
				printList(unsortedList);
				printList(mergesort(unsortedList));
			} catch (NumberFormatException e) {
				System.out.println(String.format("Error Parsing %s", args[0]));
			}
			return;
		}
		
		// Testausgabe für Studenten dies dürfen Sie nach Bedarf verändern
		
		int[] sampleOne = {1,5,8,3,4,6};
		int[] sampleTwo = {2,7,8,6,5,4,8};
		int[] sampleThree = {10,5,4,4,7};
		printList(mergesort(sampleOne));
		printList(mergesort(sampleTwo));
		printList(mergesort(sampleThree));
	}
	
	public static void printList(int[] list) {
        System.out.print("[");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
            if (i != list.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
	
	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		
		for (int i = 0;i < result.length;i++) {
			if (leftIndex == left.length && rightIndex == right.length) {
				return result;
			} else if (leftIndex == left.length) {
				result[i] = right[rightIndex];
				rightIndex++;
			} else if (rightIndex == right.length) {
				result[i] = left[leftIndex];
				leftIndex++;
			} else {
				if (left[leftIndex] <= right[rightIndex]) {
					result[i] = left[leftIndex];
					leftIndex++;
				} else {
					result[i] = right[rightIndex];
					rightIndex++;
				}
			}
		}
		return result;
	}

    public static int[] mergesort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i]; 
        }

        int[] leftSorted = mergesort(left);
        int[] rightSorted = mergesort(right);

        return merge(leftSorted, rightSorted);
    }
}