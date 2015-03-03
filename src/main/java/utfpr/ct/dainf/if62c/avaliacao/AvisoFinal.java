package utfpr.ct.dainf.if62c.avaliacao;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class AvisoFinal extends Aviso {

    public AvisoFinal(Compromisso compromisso) {
        super(compromisso);
    }
    @Override
    public void run() {
    AvisoFinal f = new AvisoFinal(compromisso);
    System.out.println(compromisso.getDescricao() + "começa agora");
    f.cancel();
    }
    
}
