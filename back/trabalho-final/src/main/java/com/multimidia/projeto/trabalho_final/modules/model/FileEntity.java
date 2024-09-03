package com.multimidia.projeto.trabalho_final.modules.model;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file_tb")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome_arquivo")
    private String fileName;

    @Column(name = "tipo_arquivo")
    private String type;

    @Lob
    @Column(name = "arquivo")
    private byte[] data;

    @Column(name = "tamanho")
    private Long size;

    @ManyToOne
    @JoinColumn(name = "user_id") // Nome da coluna para a chave estrangeira
    private User user;
}
