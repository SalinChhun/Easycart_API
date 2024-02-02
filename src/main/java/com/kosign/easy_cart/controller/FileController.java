package com.kosign.easy_cart.controller;

import com.kosign.easy_cart.entity.File;
import com.kosign.easy_cart.service.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileController extends ResController{

    private final FileService fileService;

    @PostMapping(value = "/upload-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFiles(@RequestParam("files") List<MultipartFile> files) throws IOException {
        List<String> fileUrl = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = fileService.uploadFile(file);
            String url = ServletUriComponentsBuilder.fromCurrentRequestUri()
                    .replacePath("/api/v1/files/" + fileName)
                    .toUriString();

            File fileEntity = new File(url, fileName);
            fileService.insertFile(fileEntity);
            fileUrl.add(url);
        }

        return ok(fileUrl);
    }

    @GetMapping("get-all-file/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) throws IOException {
        Resource file = fileService.getFile(fileName);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(file);
    }
}
