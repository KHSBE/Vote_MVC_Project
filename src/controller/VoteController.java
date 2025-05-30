
package controller;

import model.VoteSystem;
import view.VoteView;

public class VoteController {
    private VoteSystem system;
    private VoteView view;

    public VoteController() {
        this.system = new VoteSystem();
        this.view = new VoteView();
    }

    public void run() {
        // 메뉴 반복 실행 로직
    }

    public void handleRegisterCandidate() {}
    public void handleRemoveCandidate() {}
    public void handleRegisterVoter() {}
    public void handleVote() {}
    public void handleShowResult() {}
    public void handleTopCandidates() {}
    public void handleVoterInfo() {}
}
