package utfpr.ct.dainf.if62c.avaliacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Agenda {
    private final String descricao;
    private final List<Compromisso> compromissos = new ArrayList<>();
    private final Timer timer;

    public Agenda(String descricao) {
        this.descricao = descricao;
        timer = new Timer(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }
    
    public void novoCompromisso(Compromisso compromisso) {
        compromissos.add(compromisso);
        Aviso aviso = new AvisoFinal(compromisso);
        compromisso.registraAviso(aviso);
        // com a classe Aviso devidamente implementada, o erro de compilação
        // deverá desaparecer
        timer.schedule(aviso, compromisso.getData());
    }
    
    public void novoAviso(Compromisso compromisso, int antecedencia) {
         Aviso aviso = new Aviso(compromisso);
         compromisso.registraAviso(aviso);
         timer.schedule(aviso, antecedencia);
    }
    
    public void novoAviso(Compromisso compromisso, int antecedencia, int intervalo) {
         Aviso aviso = new Aviso(compromisso);
         compromisso.registraAviso(aviso);
         timer.schedule(aviso, antecedencia, intervalo);
    }
    
    public void cancela(Compromisso compromisso) {
         compromissos.remove(compromisso);
         compromisso.getAvisos().clear();
    }
    
    public void cancela(Aviso aviso) {
         compromissos.remove(aviso);
         aviso.cancel();
   
    }
    
    public void destroi() {
         timer.cancel();
    }
}
