package com.multimidia.projeto.trabalho_final.modules.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.multimidia.projeto.trabalho_final.modules.model.FileEntity;
import com.multimidia.projeto.trabalho_final.modules.model.User;
import com.multimidia.projeto.trabalho_final.modules.repo.FileRepo;
import com.multimidia.projeto.trabalho_final.modules.repo.UserRepo;
import com.multimidia.projeto.trabalho_final.modules.shared.FileResponseDTO;

@Service
public class FileService {

    @Autowired
    private FileRepo fileRepo;

    @Autowired
    private UserRepo userRepo;

    private ModelMapper mapper = new ModelMapper();

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<FileResponseDTO> findAll() {
        List<FileEntity> fileEntities = fileRepo.findAll();
        return mapper.map(fileEntities, new TypeToken<List<FileResponseDTO>>(){}.getType());
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public FileEntity findById(UUID id) {
        return fileRepo.findById(id).orElse(null);
    }

    @org.springframework.transaction.annotation.Transactional
    public FileResponseDTO save(UUID id, MultipartFile file) {
        Optional<User> user = this.userRepo.findById(id);
        if(user.isPresent()){
            try {
                FileEntity fileEntity = new FileEntity();
                fileEntity.setFileName(file.getOriginalFilename());
                fileEntity.setData(file.getBytes());
                fileEntity.setType(file.getContentType());
                fileEntity.setSize(file.getSize());
                fileEntity.setUser(user.get());
                user.get().getFiles().put(fileEntity.getFileName(), fileEntity);
                fileRepo.save(fileEntity);
                userRepo.save(user.get());
                return new FileResponseDTO(fileEntity.getId() ,fileEntity.getFileName(), fileEntity.getData().length, fileEntity.getType());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void deleteById(UUID id) {
        fileRepo.deleteById(id);
    }
}
