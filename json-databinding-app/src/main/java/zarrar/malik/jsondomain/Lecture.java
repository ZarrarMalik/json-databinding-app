package zarrar.malik.jsondomain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "nameLine2", "id", "enabled"})
@JsonInclude(JsonInclude.Include.NON_NULL)
// json include ignores null values if there are any e.g desc line 2 is null then it won't show it
@JsonIgnoreProperties({"ignore", "ignore2"})
public class Lecture {

    private int id;
    private String name;
    private String nameLine2;
    
    @JsonProperty("description")
    private String desc;
    
    private boolean enabled;
    private free_preview free_preview;
    
    @JsonIgnore
    private String ignore;
    private String ignore2;

    public class QuizQuestions {
        private int id;
        private String question;
        private String answer;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }

  //  @JsonIgnoreType  This will ignore the type, in this case Enum
    public enum free_preview {
        FREE_PREVIEW_ENABLED, FREE_PREVIEW_NOT_ENABLED
    }

    public free_preview getFree_preview() {
        return free_preview;
    }

    public void setFree_preview(free_preview free_preview) {
        this.free_preview = free_preview;
    }

    List<QuizQuestions> listOfQuestions = new ArrayList<>();

    public List<QuizQuestions> getListOfQuestions() {
        return listOfQuestions;
    }

    public void setListOfQuestions(List<QuizQuestions> listOfQuestions) {
        this.listOfQuestions = listOfQuestions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameLine2() {
        return nameLine2;
    }

    public void setNameLine2(String nameLine2) {
        this.nameLine2 = nameLine2;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }

    public String getIgnore2() {
        return ignore2;
    }

    public void setIgnore2(String ignore2) {
        this.ignore2 = ignore2;
    }

}
