package br.com.awesomequestionnaires.domain;

import java.util.LinkedHashMap;
import java.util.UUID;

enum QuestionOptionTypes {
    SINGLE,
    MULTIPLE
}

enum QuestionStatus {
    DRAFT,
    PUBLISHED,
    DISCARDED
}

public class Questions {
    private UUID id;
    private Integer display_order;
    private QuestionOptionTypes question_type;
    private QuestionStatus status;
    private Boolean active;
    private LinkedHashMap<Integer, QuestionOption> options;

    public String toJson() {
        return String.format("{\"id\":\"%s\", \"display_order\":\"%s\", \"question_type\":\"%s\", \"status\":\"%s\", \"active\":\"%s\", \"options\":\"%s\"}", this.id, this.display_order, this.question_type, this.status, this.active, this.options);
    }
}
