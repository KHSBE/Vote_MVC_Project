package model;

import java.util.*;

public class VoteSystem {
    private Map<String, Candidate> candidates = new HashMap<>(); // 후보자 목록
    private Map<String, Voter> voters = new HashMap<>(); // 투표자 목록//
    private String cachedResult = ""; // 캐싱 결과

    public void registerCandidate(String name) {
        candidates.put(name, new Candidate(name));
    } // 후보자 등록

    public void removeCandidate(String name) {
        candidates.remove(name);
    } // 후보자 삭제

    public void registerVoter(String name, String password) {
        voters.put(name, new Voter(name, password));
    } // 투표자 등록

    public boolean verifyVoter(String name, String password) {
        Voter voter = voters.get(name);
        return voter != null && voter.checkPassword(password);
    } // 투표자 인증

    public boolean hasVoted(String name) {
        Voter voter = voters.get(name);
        return voter != null && voter.hasVoted();
    } // 투표 중복 확인

}