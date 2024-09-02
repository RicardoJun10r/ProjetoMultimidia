package com.multimidia.projeto.trabalho_final.modules.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileResponseDTO {
    
    private String file_name;

    private int size;

    private byte[]data;

}
