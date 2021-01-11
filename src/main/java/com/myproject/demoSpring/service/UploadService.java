package com.myproject.demoSpring.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String storeFile(MultipartFile file);
    Resource loadFileAsResource(String fileName);
}
