package com.multimidia.projeto.trabalho_final.modules.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multimidia.projeto.trabalho_final.modules.model.FileEntity;
import com.multimidia.projeto.trabalho_final.modules.repo.FileRepo;

@Service
public class FileService {

    @Autowired
    private FileRepo fileRepository;

    public List<FileEntity> findAll() {
        return fileRepository.findAll();
    }

    public FileEntity findById(UUID id) {
        return fileRepository.findById(id).orElse(null);
    }

    public FileEntity save(FileEntity fileEntity) {
        return fileRepository.save(fileEntity);
    }

    public void deleteById(UUID id) {
        fileRepository.deleteById(id);
    }
}
