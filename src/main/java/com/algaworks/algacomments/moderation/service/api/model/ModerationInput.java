package com.algaworks.algacomments.moderation.service.api.model;

import lombok.Data;

@Data
public class ModerationInput {

    private String text;
    private String commentId;

}
