package com.algaworks.algacomments.moderation.service.api.controller;

import com.algaworks.algacomments.moderation.service.api.model.ModerationInput;
import com.algaworks.algacomments.moderation.service.api.model.ModerationOutput;
import com.algaworks.algacomments.moderation.service.domain.service.ValidationCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/moderate")
@RequiredArgsConstructor
public class ModerationController {

    private final ValidationCommentService validationCommentService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ModerationOutput validateComment(@RequestBody ModerationInput input) {

        log.info("Validation comment with text: {}, and id: {}", input.getText(), input.getCommentId());

        return validationCommentService.validate(input);
    }

}
