package com.multimidia.projeto.trabalho_final.modules.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<FileResponseDTO> findAll() {
        List<FileEntity> fileEntities = fileRepo.findAll();
        return mapper.map(fileEntities, new TypeToken<List<FileResponseDTO>>(){}.getType());
    }

    public FileEntity findById(UUID id) {
        return fileRepo.findById(id).orElse(null);
    }

    public FileResponseDTO save(UUID id, FileEntity fileEntity) {
        Optional<User> user = this.userRepo.findById(id);
        if(user.isPresent()){
            System.out.println("Achou usuario");
            fileEntity.setUser(user.get());
            user.get().getFiles().put(fileEntity.getFileName(), fileEntity);
            fileRepo.save(fileEntity);
            userRepo.save(user.get());
            return new FileResponseDTO(fileEntity.getFileName(), fileEntity.getData().length, fileEntity.getData());
        }
        return null;
    }

    public void deleteById(UUID id) {
        fileRepo.deleteById(id);
    }
}
