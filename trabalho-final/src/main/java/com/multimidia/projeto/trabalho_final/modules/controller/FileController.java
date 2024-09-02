package com.multimidia.projeto.trabalho_final.modules.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.multimidia.projeto.trabalho_final.modules.model.FileEntity;
import com.multimidia.projeto.trabalho_final.modules.service.FileService;
import com.multimidia.projeto.trabalho_final.modules.shared.FileResponseDTO;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping
    public List<FileResponseDTO> getAllFiles() {
        return fileService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFileById(@PathVariable UUID id) {
        FileEntity fileEntity = fileService.findById(id);
        if (fileEntity != null) {
            return ResponseEntity.ok(fileEntity.getData());
        }
        return ResponseEntity.notFound().build();
    }

    @SuppressWarnings("null")
    @PostMapping
    public ResponseEntity<FileResponseDTO> uploadFile(@RequestParam UUID user, @RequestParam("file") MultipartFile file) {
        try {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileName(file.getOriginalFilename());
            fileEntity.setData(file.getBytes());
            
            return new ResponseEntity<>(fileService.save(user, fileEntity), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable UUID id) {
        fileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
