package com.multimidia.projeto.trabalho_final.modules.shared;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    
    private String email;

    private Map<String, FileResponseDTO> files;

}
