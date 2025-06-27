package com.algaworks.algacomments.moderation.service.api.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ModerationInput {

    private String text;
    private UUID commentId;

}
