package go.backend_go.entity;

import go.backend_go.dtos.tag.TagDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String tagName;

    @OneToMany(mappedBy = "tag")
    private List<Place_Tag> place_tag = new ArrayList<>();

    public void saveTag(TagDto tagDto){
        this.tagName = "#"+tagDto.getTagName();
    }
}
