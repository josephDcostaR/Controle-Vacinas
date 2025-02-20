package br.com.api;

public class Vacinas {
    private String id;
    private String vacina;
    private String descricao;
    private int limiteAplicacao;
    private PublicoAlvo publicoAlvo;
    
    public enum PublicoAlvo{
        CRIANÇA, ADOLESCENTE, ADULTO, GESTANTE;

    }

    public Vacinas(String id, String vacina, String descricao, int limiteAplicacao, PublicoAlvo publicoAlvo) {
        this.id = id;
        this.vacina = vacina;
        this.descricao = descricao;
        this.limiteAplicacao = limiteAplicacao;
        this.publicoAlvo = publicoAlvo;
    }

    public Vacinas(String id,String vacina, int limiteAplicacao, PublicoAlvo publicoAlvo) {
        this.id = id;
        this.vacina = vacina;
        this.limiteAplicacao = limiteAplicacao;
        this.publicoAlvo = publicoAlvo;
    }


    // Getters e Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getVacina() {
        return vacina;
    }
    
    public void setVacina(String vacina) {
        this.vacina = vacina;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getlimiteAplicacao(){
        return limiteAplicacao;
    }
    
    public void setlimiteAplicacao(int limiteAplicacao){
        this.limiteAplicacao =limiteAplicacao;
    }
    
    public PublicoAlvo getPublicoAlvo(){
        return publicoAlvo;
    }

    public void setPublicoAlvo(PublicoAlvo publicoAlvo){
        this.publicoAlvo =publicoAlvo;
    }

}