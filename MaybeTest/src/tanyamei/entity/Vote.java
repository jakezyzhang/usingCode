package tanyamei.entity;

public class Vote {
	private int vote_id;
	private String vote_title;
	private String[] choices;
	
	public Vote(){}
	public Vote(String title,String[] choices){
		this.vote_title = title;
		this.choices[0] = choices[0];
		this.choices[1] = choices[1];
		this.choices[2] = choices[2];
	}
	public Vote(int id,String title,String[] choices){
		this.vote_id = id;
		this.vote_title = title;
		this.choices[0] = choices[0];
		this.choices[1] = choices[1];
		this.choices[2] = choices[2];
	}
	public int getVote_id(){
		return vote_id;
	}
	
	public String getVote_title() {
		return vote_title;
	}

	public String[] getChoices() {
		return choices;
	}
}
