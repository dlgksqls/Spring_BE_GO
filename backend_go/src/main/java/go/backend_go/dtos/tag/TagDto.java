package go.backend_go.dtos.tag;

import go.backend_go.entity.Tag;
import lombok.Data;

@Data
public class TagDto {
    private String tagName;

    public TagDto(Tag tag) {
        this.tagName = tag.getTagName();
    }

    public TagDto(String tagName) {
    }

    public TagDto() {
    }
}
