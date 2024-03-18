package com.harsh.sondhi.firstspringaiproject.controller;

import com.harsh.sondhi.firstspringaiproject.respnse.JobDescription;
import com.harsh.sondhi.firstspringaiproject.respnse.JobReasons;
import com.harsh.sondhi.firstspringaiproject.service.OpenAiServiceHS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAiControllerHS {

    private final OpenAiServiceHS openAiServiceHS;

    public OpenAiControllerHS(OpenAiServiceHS openAiServiceHS) {
        this.openAiServiceHS = openAiServiceHS;
    }

    @GetMapping("/job-reasons")
    public ResponseEntity<String> jobReasons(@RequestParam(value = "count", required = false, defaultValue = "3") int count,
                                             @RequestParam("job") String job,
                                             @RequestParam("location") String location) {
        return ResponseEntity.ok(openAiServiceHS.jobReasons(count, job, location));
    }

    @GetMapping("/job-reasons/formatted")
    public ResponseEntity<JobReasons> formattedJobReasons(@RequestParam(value = "count", required = false, defaultValue = "3") int count,
                                                          @RequestParam("job") String job,
                                                          @RequestParam("location") String location) {
        return ResponseEntity.ok(openAiServiceHS.formattedJobReasons(count, job, location));
    }


    @GetMapping("/job-description")
    public ResponseEntity<String> jobDescription(@RequestParam("job") String job,
                                                 @RequestParam("location") String location) {
        return ResponseEntity.ok(openAiServiceHS.jobDescription(job, location));
    }

    @GetMapping("/job-description/formatted")
    public ResponseEntity<JobDescription> formattedJobDescription(@RequestParam("job") String job,
                                                                  @RequestParam("location") String location) {
        return ResponseEntity.ok(openAiServiceHS.formattedJobDescription(job, location));
    }



}
