package com.kosign.easy_cart.service.file;

import com.kosign.easy_cart.entity.File;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    File insertFile(File file);

    String uploadFile(MultipartFile file) throws IOException;

    Resource getFile(String fileName) throws IOException;
}
