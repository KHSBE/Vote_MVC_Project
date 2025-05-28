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

    public boolean vote(String voterName, String password, String candidateName) {
        if (!verifyVoter(voterName, password) || hasVoted(voterName)) return false;
        Candidate candidate = candidates.get(candidateName);
        if (candidate != null) {
            candidate.addVote();
            Voter voter = voters.get(voterName);
            voter.setHasVoted(true);
            voter.setVotedCandidate(candidateName);
            cachedResult = ""; // invalidate cache
            return true;
        }
        return false;
    } // 투표 처리

    public String getResults() {
        if (!cachedResult.isEmpty()) return cachedResult;
        StringBuilder sb = new StringBuilder();
        candidates.values().stream()
                .sorted(Comparator.comparingInt(Candidate::getVotes).reversed())
                .forEach(c -> sb.append(c.name).append(" : ").append(c.getVotes()).append("표\n"));
        cachedResult = sb.toString();
        return cachedResult;
    } // 투표 결과 반환

    public List<Candidate> getTopCandidates() {
        int maxVotes = candidates.values().stream().mapToInt(Candidate::getVotes).max().orElse(0);
        List<Candidate> top = new ArrayList<>();
        for (Candidate c : candidates.values()) {
            if (c.getVotes() == maxVotes) {
                top.add(c);
            }
        }
        return top;
    } // 최다 득표자 리스트 반환

    public Map<String, Candidate> getCandidates() {
        return candidates;
    }// 후보자 목록 반환

    public Voter getVerifiedVoter(String name, String password) {
        Voter v = voters.get(name);
        if (v != null && v.checkPassword(password)) {
            return v;
        }
        return null;
    } // 투표자 정보 확인

}