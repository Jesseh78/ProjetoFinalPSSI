package br.gov.denuncias.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "denuncias")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 160)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(length = 255)
    private String endereco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Status status = Status.ABERTA;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "criado_em", nullable = false)
    private Instant criadoEm = Instant.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Instant getCriadoEm() { return criadoEm; }
    public void setCriadoEm(Instant criadoEm) { this.criadoEm = criadoEm; }
}


