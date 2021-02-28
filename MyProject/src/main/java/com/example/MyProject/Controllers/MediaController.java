package com.example.MyProject.Controllers;

import com.example.MyProject.Models.Media;
import com.example.MyProject.Repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaRepository mediaRepository;

    @PostMapping("/link")
    public String MediaLinkCreate(@RequestParam String mediaLink, String mediaName, Long productId) {
        mediaRepository.save(new Media(mediaLink, mediaName, productId));
                return "saved " + mediaName;
    }

    @PostMapping("/upload")
    public @ResponseBody String MediaDataUpload(@RequestParam MultipartFile mediaData, String mediaName, Long productId) {
        if (!mediaData.isEmpty()) {
            try {
                byte[] mediaBytes = mediaData.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(mediaName)));
                stream.write(mediaBytes);
                stream.close();
                mediaRepository.save(new Media(mediaBytes, mediaName, productId));
                return "saved " + mediaName;
            } catch (Exception e) {
                return e.getMessage();
            }
        } else {
            return "not saved";
        }
    }

    @GetMapping
    public List<Media> MediaRead() {
        return (List<Media>) mediaRepository.findAll(); //todo вернем байты в картинку :)
    }

    @PutMapping("/link/{id}")
    public String MediaLinkUpdate(@PathVariable(value = "id") Long id, @RequestParam String mediaLink, String mediaName, Long productId) {
        Media mediaObject = mediaRepository.findById(id).orElseThrow();
        mediaObject.setMediaLink(mediaLink);
        mediaObject.setMediaName(mediaName);
        mediaObject.setProductId(productId);
        mediaRepository.save(mediaObject);
        return "updated " + mediaRepository.findById(id);
    }

    @PutMapping("/upload/{id}")
    public @ResponseBody String MediaDataUpdate(@PathVariable(value = "id") Long id, @RequestParam MultipartFile mediaData, String mediaName, Long productId) {
        Media mediaObject = mediaRepository.findById(id).orElseThrow();
        try {
            byte[] mediaBytes = mediaData.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(mediaName)));
            stream.write(mediaBytes);
            stream.close();
            mediaObject.setMediaData(mediaBytes);
            mediaObject.setMediaLink(mediaName);
            mediaObject.setProductId(productId);
            mediaRepository.save(mediaObject);
            return "updated " + mediaRepository.findById(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String MediaDelete(@PathVariable(value = "id") Long id) {
        Media mediaObject = mediaRepository.findById(id).orElseThrow();
        mediaRepository.delete(mediaObject);
        return "deleted id: " + id;
    }

    @GetMapping("/{id}")
    public Media MediaGetId(@PathVariable(value = "id") Long id) {
        Media mediaObject = mediaRepository.findById(id).orElseThrow();
        return mediaObject;
    }

}