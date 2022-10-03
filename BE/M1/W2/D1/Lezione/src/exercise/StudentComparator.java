package exercise;

public class StudentComparator {

	public static int compare(Student s1, Student s2) {
		
		int mediaS1 = getMedia(s1);
		int mediaS2 = getMedia(s2);
		
		if(mediaS1 > mediaS2) {
			return 1;
		}else if(mediaS1 == mediaS2) {
			return 0;
		}
		return -1;
	}
	
	private static int getMedia(Student s) {
		int sum = 0;
		for(int voto : s.votes) {
			sum += voto;
		}
		return sum/3;
	}
	
}
