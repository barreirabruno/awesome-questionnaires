package br.com.awesomequestionnaires.domain;

import java.util.UUID;

public class QuestionOption {
    private UUID id;
    private String option_display_text;
    private Boolean is_correct_option;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getOption_display_text() {
        return option_display_text;
    }
    public void setOption_display_text(String option_display_text) {
        this.option_display_text = option_display_text;
    }
    public Boolean getIs_correct_option() {
        return is_correct_option;
    }
    public void setIs_correct_option(Boolean is_correct_option) {
        this.is_correct_option = is_correct_option;
    }

    public String toJson() {
        return String.format("{\"id\":\"%s\", \"option_display_text\":\"%s\", \"is_correct_option\":\"%s\"}", this.id, this.option_display_text, this.is_correct_option);
    }
}
