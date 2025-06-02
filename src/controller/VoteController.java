package controller;

import model.*;
import view.VoteView;

import java.util.*;

public class VoteController {
    private final VoteSystem system = new VoteSystem();
    private final VoteView view = new VoteView();
    private final Map<String, Runnable> menuMap = new HashMap<>();

    public VoteController() {
        menuMap.put("1", this::registerCandidate);
        menuMap.put("2", this::removeCandidate);
        menuMap.put("3", () -> view.showCandidates(system.getCandidates()));
        menuMap.put("4", this::vote);
        menuMap.put("5", () -> view.showMessage(system.getResults()));
        menuMap.put("6", () -> view.showTopCandidates(system.getTopCandidates()));
        menuMap.put("7", this::registerVoter);
        menuMap.put("8", this::showVoterInfo);
    }

    public void run() {
        while (true) {
            view.showMenu();
            String input = view.input("선택 >> ");
            if ("9".equals(input)) {
                view.showMessage("프로그램을 종료합니다.");
                break;
            }
            menuMap.getOrDefault(input, view::showInvalidInput).run();
        }
    }

    private void registerCandidate() {
        String name = view.input("등록할 후보자 이름: ");
        system.registerCandidate(name);
        view.showRegisterSuccess(name);
    }

    private void removeCandidate() {
        String name = view.input("삭제할 후보자 이름: ");
        system.removeCandidate(name);
        view.showMessage(name + " 후보자 삭제 완료");
    }

    private void registerVoter() {
        String name = view.input("등록할 투표자 이름: ");
        String pwd = view.input("비밀번호 입력: ");
        system.registerVoter(name, pwd);
        view.showRegisterSuccess(name);
    }

    private void vote() {
        String[] login = view.promptLogin();
        String name = login[0], pwd = login[1];

        if (!system.verifyVoter(name, pwd)) {
            view.showInvalidInput();
            return;
        }

        if (system.hasVoted(name)) {
            view.showAlreadyVoted(name);
            return;
        }

        String candidate = view.input("투표할 후보자 이름: ");
        boolean result = system.vote(name, pwd, candidate);

        if (result) view.showVoteSuccess(name);
        else view.showInvalidInput();
    }

    private void showVoterInfo() {
        String[] login = view.promptLogin();
        Voter voter = system.getVerifiedVoter(login[0], login[1]);

        if (voter != null) view.showVoterInfoWithVoteStatus(voter);
        else view.showInvalidInput();
    }
}
