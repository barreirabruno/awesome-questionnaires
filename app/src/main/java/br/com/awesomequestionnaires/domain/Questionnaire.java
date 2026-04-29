package br.com.awesomequestionnaires.domain;

import java.util.UUID;

enum QuestionnaireStatus {
    DRAFT,
    PUBLISHED,
    DISCARDED
}

public class Questionnaire {
    private UUID id;
    private String title;
    private String description;
    private ActiveStatus status;

    public Questionnaire() {
        this.id = UUID.randomUUID();
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ActiveStatus getStatus() {
        return status;
    }
    public void setStatus(ActiveStatus true1) {
        this.status = true1;
    }
    
    public String toJson() {
        return String.format("{\"id\":\"%s\", \"title\":\"%s\", \"description\":\"%s\", \"status\":\"%s\"}", this.id, this.title, this.description, this.status);
    }
}
