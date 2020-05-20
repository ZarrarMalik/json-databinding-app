package zarrar.malik.jsondomain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class LectureSchema {
    @JsonPropertyDescription(value="id of the field")
    private int id;
    
    @JsonPropertyDescription(value="description of the field and required is true")
    @JsonProperty(required = true)
    private String name;
    
    @JsonPropertyDescription(value="name of the field and requied is true")
    @JsonProperty(required=true)
    private String nameLine2;
    @JsonProperty("description")
    private String desc;

    private boolean enabled;

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

}
