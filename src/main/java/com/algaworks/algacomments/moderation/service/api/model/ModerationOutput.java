package com.algaworks.algacomments.moderation.service.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ModerationOutput {

    private Boolean approved;
    private String reason;
    private UUID commentId;

}
