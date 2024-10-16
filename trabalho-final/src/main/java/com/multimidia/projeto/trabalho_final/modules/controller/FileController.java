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
import com.multimidia.projeto.trabalho_final.modules.shared.CommentDTO;
import com.multimidia.projeto.trabalho_final.modules.shared.FileResponseDTO;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PutMapping("/like/{fileId}")
    public ResponseEntity<Void> likeFile(@PathVariable UUID fileId) {
        fileService.incrementLikes(fileId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{fileId}/comments")
    public ResponseEntity<Void> addComment(@PathVariable UUID fileId, @RequestBody CommentDTO commentDTO) {
        fileService.addComment(fileId, commentDTO.getNickname(), commentDTO.getContent());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<FileResponseDTO> getAllFiles() {
        return fileService.findAll();
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> downloadFile(@RequestParam String user, @RequestParam("file") String file) {
        FileEntity fileEntity = fileService.findByName(user, file);
        if (fileEntity != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.valueOf(fileEntity.getType()))
                    .body(fileEntity.getData());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFileById(@PathVariable UUID id) {
        FileEntity fileEntity = fileService.findById(id);
        if (fileEntity != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.valueOf(fileEntity.getType()))
                    .body(fileEntity.getData());
        }
        return ResponseEntity.notFound().build();
    }

    @SuppressWarnings("null")
    @PostMapping
    public ResponseEntity<FileResponseDTO> uploadFile(@RequestParam String nickname,
            @RequestParam("file") MultipartFile file) {
        try {
            return new ResponseEntity<>(fileService.save(nickname, file), HttpStatus.CREATED);
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
