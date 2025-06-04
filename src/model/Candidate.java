package model;

public class Candidate {
    private String name;  // 후보자 이름
    private int votes;    // 투표 수

    // 생성자
    public Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }

    // 투표 수 1 증가
    public void addVote() {
        votes++;
    }

    // 현재 투표 수 반환
    public int getVotes() {
        return votes;
    }

    // 후보자 이름 반환
    public String getName() {
        return name;
    }

    // 디버깅용 toString
    @Override
    public String toString() {
        return name + " : " + votes + " votes";
    }
}
