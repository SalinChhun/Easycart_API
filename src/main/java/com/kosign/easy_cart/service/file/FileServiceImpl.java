package com.kosign.easy_cart.service.file;

import com.kosign.easy_cart.entity.File;
import com.kosign.easy_cart.repository.FileRepository;
import com.kosign.easy_cart.service.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final Path root= Paths.get("/ProductImages/EasyCartImages");

    @Override
    public File insertFile(File file) {
        return fileRepository.save(file);
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        try{
            String fileName = file.getOriginalFilename();
            if(fileName!=null) {
                fileName = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(fileName);

                if(!Files.exists(root)){
                    Files.createDirectories(root);
                }
                Files.copy(file.getInputStream(),root.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
                return fileName;
            }
            else {
                return "File Not Found!";
            }
        }catch (IOException ex){
            throw new IOException("File not found!");
        }
    }

    @Override
    public Resource getFile(String fileName) throws IOException {
        File files = fileRepository.findByFileName(fileName);
        Path path = Paths.get("/ProductImages/EasyCartImages"+files.getFileName());
        Resource file = new ByteArrayResource(Files.readAllBytes(path));
        return file;
    }
}
