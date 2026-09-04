package com.habench.path1022.web;

import com.habench.path1022.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1022EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1022")
    public String handle(
            @RequestParam("filename") String filename) {
        Stage00.apply(filename);
        return "ok";
    }
}
