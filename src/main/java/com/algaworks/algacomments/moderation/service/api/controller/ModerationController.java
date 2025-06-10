package com.algaworks.algacomments.moderation.service.api.controller;

import com.algaworks.algacomments.moderation.service.api.model.ModerationInput;
import com.algaworks.algacomments.moderation.service.api.model.ModerationOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/moderate")
public class ModerationController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ModerationOutput validateComment(@RequestBody ModerationInput input) {

        log.info("Validation comment with text: {}, and id: {}", input.getText(), input.getCommentId());

        return ModerationOutput.builder()
                .build();
    }

}
