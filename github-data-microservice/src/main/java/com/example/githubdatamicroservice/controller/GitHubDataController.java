//package com.example.githubdatamicroservice.controller;
//
//import com.example.githubdatamicroservice.model.GitHubData;
//import com.example.githubdatamicroservice.service.GitHubDataService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class GitHubDataController {
//
//    @Autowired
//    private GitHubDataService gitHubDataService;
//    public GitHubDataController(GitHubDataService gitHubDataService) {
//        this.gitHubDataService = gitHubDataService;
//    }
//
//    @GetMapping("/github-data")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public ResponseEntity<?> getGitHubData(@RequestParam String username) {
//        try {
//            GitHubData gitHubData;
//            gitHubData = gitHubDataService.getGitHubData(username);
//            return ResponseEntity.ok(gitHubData);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
//        }
//    }
//}

package com.example.githubdatamicroservice.controller;

import com.example.githubdatamicroservice.model.GitHubData;
import com.example.githubdatamicroservice.service.GitHubDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubDataController {

    @Autowired
    private GitHubDataService gitHubDataService;

    public GitHubDataController(GitHubDataService gitHubDataService) {
        this.gitHubDataService = gitHubDataService;
    }

    @GetMapping("/github-data")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> getGitHubData(@RequestParam String username) {
        try {
            GitHubData gitHubData = gitHubDataService.getGitHubData(username);
            return ResponseEntity.ok(gitHubData);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}

