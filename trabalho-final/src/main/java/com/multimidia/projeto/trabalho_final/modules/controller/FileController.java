package com.multimidia.projeto.trabalho_final.modules.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.multimidia.projeto.trabalho_final.modules.model.FileEntity;
import com.multimidia.projeto.trabalho_final.modules.service.FileService;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping
    public List<FileEntity> getAllFiles() {
        return fileService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileEntity> getFileById(@PathVariable UUID id) {
        FileEntity fileEntity = fileService.findById(id);
        if (fileEntity != null) {
            return ResponseEntity.ok(fileEntity);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FileEntity> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileName(file.getOriginalFilename());
            fileEntity.setData(file.getBytes());
            fileService.save(fileEntity);

            return new ResponseEntity<>(fileEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FileEntity> updateFile(@PathVariable UUID id, @RequestBody FileEntity fileDetails) {
        FileEntity fileEntity = fileService.findById(id);
        if (fileEntity != null) {
            fileEntity.setFileName(fileDetails.getFileName());
            fileEntity.setData(fileDetails.getData());
            return ResponseEntity.ok(fileService.save(fileEntity));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable UUID id) {
        fileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
