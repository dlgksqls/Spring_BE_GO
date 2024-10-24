package go.backend_go.controller;

import go.backend_go.dtos.tag.TagDto;
import go.backend_go.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @GetMapping("")
    public List<TagDto> findAll(){
        return tagService.findAll();
    }

    @PostMapping("")
    public String save(TagDto tagDto){

        tagService.save(tagDto);
        return "#"+tagDto.getTagName();
    }
}
