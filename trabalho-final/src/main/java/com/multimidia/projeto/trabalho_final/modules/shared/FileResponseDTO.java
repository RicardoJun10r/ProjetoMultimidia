package com.multimidia.projeto.trabalho_final.modules.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileResponseDTO {

    private UUID id;
    
    private String fileName;

    private int size;

    private String type;

}
