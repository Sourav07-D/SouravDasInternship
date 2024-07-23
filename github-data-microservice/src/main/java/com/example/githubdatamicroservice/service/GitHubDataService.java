//
//package com.example.githubdatamicroservice.service;
//
//import com.example.githubdatamicroservice.model.GitHubData;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.time.LocalDate;
//import java.util.Map;
//
//@Service
//public class GitHubDataService {
//    private final int DAYS_LIMIT = 30;
//
//    public GitHubData getGitHubData(String username) {
//        RestTemplate restTemplate = new RestTemplate();
//        String eventsUrl = "https://api.github.com/users/" + username + "/events";
//        String userUrl = "https://api.github.com/users/" + username;
//
//        try {
//            GitHubEvent[] events = restTemplate.getForObject(eventsUrl, GitHubEvent[].class);
//
//            Map<String, Object> userProfile = restTemplate.getForObject(userUrl, Map.class);
//
//            int pushCount = 0;
//            int pullCount = 0;
//            LocalDate thirtyDaysAgo = LocalDate.now().minusDays(DAYS_LIMIT);
//
//            if (events != null) {
//                for (GitHubEvent event : events) {
//                    if (event.getType().equals("PushEvent")) {
//                        pushCount++;
//                    } else if (event.getType().equals("PullRequestEvent")) {
//                        pullCount++;
//                    }
//                }
//            }
//
//            GitHubData gitHubData = new GitHubData();
//            gitHubData.setPushCount(pushCount);
//            gitHubData.setPullCount(pullCount);
//            gitHubData.setProfilePhoto((String) userProfile.get("avatar_url"));
//            gitHubData.setFullName((String) userProfile.get("name"));
//            gitHubData.setBio((String) userProfile.get("bio"));
//            gitHubData.setSince((String) userProfile.get("created_at"));
//            return gitHubData;
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new GitHubData();
//        }
//    }
//
//
//    private static class GitHubEvent {
//        private String type;
//        private String createdAt;
//
//        public String getType() {
//            return type;
//        }
//        public void setType(String type) {
//            this.type = type;
//        }
//        public String getCreatedAt() {
//            return createdAt;
//        }
//        public void setCreatedAt(String createdAt) {
//            this.createdAt = createdAt;
//        }
//    }
//
//    private static class GitHubUserProfile {
//        private String avatarUrl;
//        private String name;
//        private String bio;
//        private String created_at;
//
//        public String getAvatarUrl() {
//            return avatarUrl;
//        }
//
//        public void setAvatarUrl(String avatarUrl) {
//            this.avatarUrl = avatarUrl;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getBio() {
//            return bio;
//        }
//
//        public void setBio(String bio) {
//            this.bio = bio;
//        }
//
//        public String getCreated_at() {
//            return created_at;
//        }
//
//        public void setCreated_at(String created_at) {
//            this.created_at = created_at;
//        }
//    }
//}




















//package com.example.githubdatamicroservice.service;
//
//import com.example.githubdatamicroservice.model.GitHubData;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class GitHubDataService {
//    private final int DAYS_LIMIT = 30;
//
//    public GitHubData getGitHubData(String username) {
//        RestTemplate restTemplate = new RestTemplate();
//        String eventsUrl = "https://api.github.com/users/" + username + "/events";
//        String userUrl = "https://api.github.com/users/" + username;
//
//        try {
//            GitHubEvent[] events = restTemplate.getForObject(eventsUrl, GitHubEvent[].class);
//
//            Map<String, Object> userProfile = restTemplate.getForObject(userUrl, Map.class);
//
//            Map<String, Integer> pushCountMap = new HashMap<>();
//            Map<String, Integer> pullCountMap = new HashMap<>();
//            LocalDate today = LocalDate.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//            if (events != null) {
//                for (GitHubEvent event : events) {
//                    if (event.getCreatedAt() != null) { // Check if createdAt is not null
//                        LocalDate eventDate = LocalDate.parse(event.getCreatedAt().substring(0, 10), formatter);
//                        if (eventDate.isAfter(today.minusDays(DAYS_LIMIT))) {
//                            if (event.getType().equals("PushEvent")) {
//                                pushCountMap.put(eventDate.toString(), pushCountMap.getOrDefault(eventDate.toString(), 0) + 1);
//                            } else if (event.getType().equals("PullRequestEvent")) {
//                                pullCountMap.put(eventDate.toString(), pullCountMap.getOrDefault(eventDate.toString(), 0) + 1);
//                            }
//                        }
//                    }
//                }
//            }
//
//            GitHubData gitHubData = new GitHubData();
//            gitHubData.setPushCountMap(pushCountMap);
//            gitHubData.setPullCountMap(pullCountMap);
//            gitHubData.setProfilePhoto((String) userProfile.get("avatar_url"));
//            gitHubData.setFullName((String) userProfile.get("name"));
//            gitHubData.setBio((String) userProfile.get("bio"));
//            gitHubData.setSince((String) userProfile.get("created_at"));
//            return gitHubData;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new GitHubData();
//        }
//    }
//
//
//
//    private static class GitHubEvent {
//        private String type;
//        private String createdAt;
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public String getCreatedAt() {
//            return createdAt;
//        }
//
//        public void setCreatedAt(String createdAt) {
//            this.createdAt = createdAt;
//        }
//    }
//}






//
//
//
//package com.example.githubdatamicroservice.service;
//
//import com.example.githubdatamicroservice.model.GitHubData;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class GitHubDataService {
//    private final int DAYS_LIMIT = 30;
//
//    public GitHubData getGitHubData(String username) {
//        RestTemplate restTemplate = new RestTemplate();
//        String eventsUrl = "https://api.github.com/users/" + username + "/events";
//        String userUrl = "https://api.github.com/users/" + username;
//
//        try {
//            GitHubEvent[] events = restTemplate.getForObject(eventsUrl, GitHubEvent[].class);
//
//            Map<String, Object> userProfile = restTemplate.getForObject(userUrl, Map.class);
//
//            Map<String, Integer> pushCountMap = new HashMap<>();
//            Map<String, Integer> pullCountMap = new HashMap<>();
//            LocalDate today = LocalDate.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//            if (events != null) {
//                for (GitHubEvent event : events) {
//                    if (event.getCreatedAt() != null) {
//                        LocalDate eventDate = LocalDate.parse(event.getCreatedAt().substring(0, 10), formatter);
//                        if (eventDate.isAfter(today.minusDays(DAYS_LIMIT))) {
//                            if (event.getType().equals("PushEvent")) {
//                                pushCountMap.put(eventDate.toString(), pushCountMap.getOrDefault(eventDate.toString(), 0) + 1);
//                            } else if (event.getType().equals("PullRequestEvent")) {
//                                pullCountMap.put(eventDate.toString(), pullCountMap.getOrDefault(eventDate.toString(), 0) + 1);
//                            }
//                        }
//                    }
//                }
//            }
//
//            GitHubData gitHubData = new GitHubData();
//            gitHubData.setPushCountMap(pushCountMap);
//            gitHubData.setPullCountMap(pullCountMap);
//            gitHubData.setProfilePhoto((String) userProfile.get("avatar_url"));
//            gitHubData.setFullName((String) userProfile.get("name"));
//            gitHubData.setBio((String) userProfile.get("bio"));
//            gitHubData.setSince((String) userProfile.get("created_at"));
//            return gitHubData;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new GitHubData();
//        }
//    }
//
//    private static class GitHubEvent {
//        private String type;
//        private String createdAt;
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public String getCreatedAt() {
//            return createdAt;
//        }
//
//        public void setCreatedAt(String createdAt) {
//            this.createdAt = createdAt;
//        }
//    }
//}







//
//package com.example.githubdatamicroservice.service;
//
//import com.example.githubdatamicroservice.model.GitHubData;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class GitHubDataService {
//    private final int DAYS_LIMIT = 30;
//    private final String GITHUB_API_TOKEN = "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";
//
//    public GitHubData getGitHubData(String username) {
//        RestTemplate restTemplate = new RestTemplate();
//        String eventsUrl = "https://api.github.com/users/" + username + "/events";
//        String userUrl = "https://api.github.com/users/" + username;
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "token " + GITHUB_API_TOKEN);
//
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        try {
//            ResponseEntity<GitHubEvent[]> eventsResponse = restTemplate.exchange(eventsUrl, HttpMethod.GET, entity, GitHubEvent[].class);
//            ResponseEntity<Map> userResponse = restTemplate.exchange(userUrl, HttpMethod.GET, entity, Map.class);
//
//            GitHubEvent[] events = eventsResponse.getBody();
//            Map<String, Object> userProfile = userResponse.getBody();
//
//            Map<String, Integer> pushCountMap = new HashMap<>();
//            Map<String, Integer> pullCountMap = new HashMap<>();
//            LocalDate today = LocalDate.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//            if (events != null) {
//                for (GitHubEvent event : events) {
//                    System.out.println("Event: " + event.getType() + ", Full Data: " + event);
//                    if (event.getCreatedAt() != null) {
//                        LocalDate eventDate = LocalDate.parse(event.getCreatedAt().substring(0, 10), formatter);
//                        if (eventDate.isAfter(today.minusDays(DAYS_LIMIT))) {
//                            if ("PushEvent".equals(event.getType())) {
//                                pushCountMap.put(eventDate.toString(), pushCountMap.getOrDefault(eventDate.toString(), 0) + 1);
//                            } else if ("PullRequestEvent".equals(event.getType())) {
//                                pullCountMap.put(eventDate.toString(), pullCountMap.getOrDefault(eventDate.toString(), 0) + 1);
//                            }
//                        }
//                    }
//                }
//            }
//
//            GitHubData gitHubData = new GitHubData();
//            gitHubData.setPushCountMap(pushCountMap);
//            gitHubData.setPullCountMap(pullCountMap);
//            if (userProfile != null) {
//                gitHubData.setProfilePhoto((String) userProfile.get("avatar_url"));
//                gitHubData.setFullName((String) userProfile.get("name"));
//                gitHubData.setBio((String) userProfile.get("bio"));
//                gitHubData.setSince((String) userProfile.get("created_at"));
//            }
//            return gitHubData;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new GitHubData();
//        }
//    }
//
//    private static class GitHubEvent {
//        private String type;
//        private String created_at;  // Adjust the field name to match the API response
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public String getCreatedAt() {
//            return created_at;
//        }
//
//        public void setCreatedAt(String created_at) {
//            this.created_at = created_at;
//        }
//
//        @Override
//        public String toString() {
//            return "GitHubEvent{" +
//                    "type='" + type + '\'' +
//                    ", created_at='" + created_at + '\'' +
//                    '}';
//        }
//    }
//}












package com.example.githubdatamicroservice.service;

import com.example.githubdatamicroservice.model.GitHubData;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class GitHubDataService {
    private final int DAYS_LIMIT = 30;
    private final String GITHUB_API_TOKEN = "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";

    public GitHubData getGitHubData(String username) {
        RestTemplate restTemplate = new RestTemplate();
        String eventsUrl = "https://api.github.com/users/" + username + "/events";
        String userUrl = "https://api.github.com/users/" + username;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token " + GITHUB_API_TOKEN);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<GitHubEvent[]> eventsResponse = restTemplate.exchange(eventsUrl, HttpMethod.GET, entity, GitHubEvent[].class);
            ResponseEntity<Map> userResponse = restTemplate.exchange(userUrl, HttpMethod.GET, entity, Map.class);

            GitHubEvent[] events = eventsResponse.getBody();
            Map<String, Object> userProfile = userResponse.getBody();

            Map<String, Integer> pushCountMap = new HashMap<>();
            Map<String, Integer> pullCountMap = new HashMap<>();
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            if (events != null) {
                for (GitHubEvent event : events) {
                    System.out.println("Event: " + event.getType() + ", Full Data: " + event);
                    if (event.getCreatedAt() != null) {
                        LocalDate eventDate = LocalDate.parse(event.getCreatedAt().substring(0, 10), formatter);
                        if (eventDate.isAfter(today.minusDays(DAYS_LIMIT))) {
                            if ("PushEvent".equals(event.getType())) {
                                pushCountMap.put(eventDate.toString(), pushCountMap.getOrDefault(eventDate.toString(), 0) + 1);
                            } else if ("PullRequestEvent".equals(event.getType())) {
                                pullCountMap.put(eventDate.toString(), pullCountMap.getOrDefault(eventDate.toString(), 0) + 1);
                            }
                        }
                    }
                }
            }

            GitHubData gitHubData = new GitHubData();
            gitHubData.setPushCountMap(pushCountMap);
            gitHubData.setPullCountMap(pullCountMap);
            if (userProfile != null) {
                gitHubData.setProfilePhoto((String) userProfile.get("avatar_url"));
                gitHubData.setFullName((String) userProfile.getOrDefault("name", "No Name Provided"));
                gitHubData.setBio((String) userProfile.getOrDefault("bio", "No Bio Available"));
                gitHubData.setSince((String) userProfile.get("created_at"));
            }
            return gitHubData;

        } catch (Exception e) {
            e.printStackTrace();
            return new GitHubData();
        }
    }

    public static class GitHubEvent {
        private String type;

        @JsonProperty("created_at")
        private String createdAt;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        @Override
        public String toString() {
            return "GitHubEvent{" +
                    "type='" + type + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    '}';
        }
    }
}
