
package view;

import model.Candidate;
import model.Voter;

import java.util.*;

public class VoteView {
    private Scanner sc = new Scanner(System.in);

    public void showMenu() {
        System.out.println("========= 투표 시스템 =========");
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

    public String input(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public String[] promptLogin() {
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("비밀번호: ");
        String pwd = sc.nextLine();
        return new String[]{name, pwd};
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showInvalidInput() {
        System.out.println("⚠️ 잘못된 입력입니다.");
    }

    public void showCandidates(Map<String, Candidate> candidates) {
        System.out.println("📋 후보 목록:");
        for (Candidate c : candidates.values()) {
            System.out.println("- " + c.getName() + " (" + c.getVotes() + "표)");
        }
    }

    public void showTopCandidates(List<Candidate> list) {
        System.out.println("🏆 최다 득표자:");
        for (Candidate c : list) {
            System.out.println("- " + c.getName() + ": " + c.getVotes() + "표");
        }
    }

    public void showAlreadyVoted(String name) {
        System.out.println(name + "님은 이미 투표를 완료하셨습니다.");
    }

    public void showVoteSuccess(String name) {
        System.out.println(name + "님, 투표가 성공적으로 완료되었습니다.");
    }

    public void showRegisterSuccess(String name) {
        System.out.println(name + "님이 등록되었습니다.");
    }

    public void showVoterInfoWithVoteStatus(Voter voter) {
        System.out.println("🧾 투표자 정보: " + voter.getName());
        if (voter.hasVoted()) {
            System.out.println("✅ 투표 완료 - 후보: " + voter.getVotedCandidate());
        } else {
            System.out.println("❌ 아직 투표하지 않음");
        }
    }
}
