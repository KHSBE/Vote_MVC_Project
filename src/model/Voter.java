
package model;

public class Voter {
    private String name;
    private String password;
    private boolean hasVoted = false;
    private String votedCandidate = null;

    public Voter(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public boolean checkPassword(String pwd) {
        return this.password.equals(pwd);
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public void setVotedCandidate(String candidate) {
        this.votedCandidate = candidate;
    }

    public String getVotedCandidate() {
        return votedCandidate;
    }

    public String getName() {
        return name;
    }
}
