package com.algaworks.algacomments.moderation.service.domain.service;

import com.algaworks.algacomments.moderation.service.api.model.ModerationInput;
import com.algaworks.algacomments.moderation.service.api.model.ModerationOutput;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ValidationCommentService {

    private static final List<String> BANNED_WORDS = List.of("ódio", "xingamento", "php");

    public ModerationOutput validate(ModerationInput input) {
        String text = input.getText();
        boolean containsProhibited = BANNED_WORDS.stream()
                .anyMatch(word -> text != null && text.toLowerCase().contains(word));
        if (containsProhibited) {
            return ModerationOutput.builder()
                    .approved(false)
                    .reason("Contém palavras proibidas")
                    .build();
        }
        return ModerationOutput.builder()
                .commentId(input.getCommentId())
                .approved(true)
                .reason("Sem palavras proibidas")
                .build();

    }

    public ModerationOutput moderate(ModerationInput request) {
        String text = request.getText().toLowerCase();

        Set<String> bannedWordsFound = new HashSet<>();
        for (String word : BANNED_WORDS) {
            if (text.contains(word.toLowerCase())) {
                bannedWordsFound.add(word);
            }
        }

        if (!bannedWordsFound.isEmpty()) {
            return ModerationOutput.builder()
                    .approved(false)
                    .reason("Contém palavras proibidas: " + bannedWordsFound)
                    .build();
        }

        return ModerationOutput.builder()
                .commentId(request.getCommentId())
                .approved(true)
                .reason("Comentário aprovado não palavras proibidas")
                .build();
    }
}
