package com.cry.forum.controller;

import com.cry.forum.common.FileProperties;
import com.cry.forum.model.File;
import com.cry.forum.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;

    @Autowired
    private FileProperties fileProperties;

    @PostMapping("/upload")
    public File uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileService.storeFile(file);

//        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/f/")
//                .path(fileName)
//                .toUriString();
        String url = fileProperties.getDownloadPath()+fileName;
        File f = new File();
        f.setName(fileName);
        f.setUrl(url);
        f.setType(file.getContentType());
        f.setSize(file.getSize());
        return f;
    }


    @PostMapping("/uploads")
    public List<File> uploadMultipleFiles(@RequestParam("file") MultipartFile[] files) {
        return Arrays.stream(files)
                .map(this::uploadFile)
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
