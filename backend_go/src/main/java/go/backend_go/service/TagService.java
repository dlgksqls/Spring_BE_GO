package go.backend_go.service;

import go.backend_go.dtos.tag.PlaceTagDto;
import go.backend_go.dtos.tag.TagDto;
import go.backend_go.entity.Place_Tag;
import go.backend_go.entity.Tag;
import go.backend_go.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public void save(TagDto tagDto) {

        Tag findTag = tagRepository.findByTagName(tagDto.getTagName());

        if (findTag != null){
            return;
        }

        Tag saveTag = new Tag();
        saveTag.saveTag(tagDto);

        tagRepository.save(saveTag);
    }

    public List<TagDto> findAll(){
        List<Tag> allTag = tagRepository.findAll();
        List<TagDto> returnTag = new ArrayList<>();

        for (Tag tag : allTag) {
            if (tag != null) {
                TagDto dto = new TagDto(tag.getTagName());
                returnTag.add(dto);
            }
        }
        return returnTag;
    }
}
