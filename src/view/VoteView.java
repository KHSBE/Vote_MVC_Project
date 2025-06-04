package view;

import java.util.*;
import model.*;

public class VoteView {

    private Scanner sc;

    public VoteView() {
        sc = new Scanner(System.in);
    }

    public void showMenu() {
        public void showMenu() {
    System.out.println("===== 메인 메뉴 =====");
    System.out.println("1. 후보 등록");
    System.out.println("2. 후보 삭제");
    System.out.println("3. 후보 목록 출력");
    System.out.println("4. 투표하기");
    System.out.println("5. 투표 결과 보기");
    System.out.println("6. 최다 득표자 보기");
    System.out.println("7. 투표자 등록");
    System.out.println("8. 투표자 정보 확인");
    System.out.println("9. 종료");
        }
    }

    public String input(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public String[] promptLogin() {
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("비밀번호: ");
        String password = sc.nextLine();
        return new String[]{name, password};
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showInvalidInput() {
        System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
    }

    public void showCandidates(Map<String, Candidate> candidates) {
        System.out.println("===== 후보자 목록 =====");
        for (String id : candidates.keySet()) {
            Candidate c = candidates.get(id);
            System.out.println("ID: " + id + " | 이름: " + c.getName() + " | 정당: " + c.getParty());
        }
    }

    public void showTopCandidates(List<Candidate> topCandidates) {
        System.out.println("===== 최다 득표자 =====");
        for (Candidate c : topCandidates) {
            System.out.println(c.getName() + " (" + c.getParty() + ") - " + c.getVoteCount() + "표");
        }
    }

    public void showVoteSuccess(String candidateName) {
        System.out.println("[투표 성공] " + candidateName + " 후보에게 투표되었습니다!");
    }

    public void showAlreadyVoted(String voterName) {
        System.out.println("[중복 투표] " + voterName + "님은 이미 투표하셨습니다.");
    }

    public void showRegisterSuccess(String name) {
        System.out.println("[등록 완료] " + name + "님이 등록되었습니다.");
    }

    public void showVoterInfoWithVoteStatus(Voter voter) {
        System.out.println("===== 투표자 정보 =====");
        System.out.println("이름: " + voter.getName());
        System.out.println("ID: " + voter.getId());
        if (voter.hasVoted()) {
            System.out.println("투표 여부: 완료");
            System.out.println("투표한 후보: " + voter.getVotedCandidate().getName());
        } else {
            System.out.println("투표 여부: 미완료");
        }
    }
} 