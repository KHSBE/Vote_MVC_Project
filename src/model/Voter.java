package model;

public class Voter {
    private String name;
    private String password;
    private boolean hasVoted;
    private String votedCandidate;

    public Voter(String name, String password) {
        this.name = name;
        this.password = password;
        this.hasVoted = false;
        this.votedCandidate = null;
    }
    //이름 반환하기
    public String getName() {
        return name;
    }
    //비밀번호 검증하기
    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
    //투표 여부 확인하기
    public boolean hasVoted() {
        return hasVoted;
    }
    //투표 여부 설정하기
    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
    //투표한 후보자의 이름 설정
    public void setVitedCandidate(String candidateName){
        this.votedCandidate = candidateName;
    }
    //투표한 후보자의 이름 가져오기
    public String getVotedCandidate() {
        return votedCandidate;
    }
}
