package exercise;

public class VotesException extends Exception {

	private int errVote;
	
	public VotesException(String msg, int eV) {
		super(msg);
		this.setErrVote(eV);
	}

	public int getErrVote() {
		return errVote;
	}

	public void setErrVote(int errVote) {
		this.errVote = errVote;
	}
	
}
