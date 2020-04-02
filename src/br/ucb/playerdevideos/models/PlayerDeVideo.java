package br.ucb.playerdevideos.models;

public class PlayerDeVideo extends Thread {
    private Filme filme;
    private int momentoAtualDoFilme;
    private int momentoDePause;
    private int tempoDePause;

    public PlayerDeVideo(Filme filme, int momentoDePause, int tempoDePause) {
        setFilme(filme);
        setMomentoAtualDoFilme(0);
        setMomentoDePause(momentoDePause);
        setTempoDePause(tempoDePause);
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getMomentoAtualDoFilme() {
        return momentoAtualDoFilme;
    }

    public void setMomentoAtualDoFilme(int momentoAtualDoFilme) {
        this.momentoAtualDoFilme = momentoAtualDoFilme;
    }

    public int getMomentoDePause() {
        return momentoDePause;
    }

    public void setMomentoDePause(int momentoDePause) {
        this.momentoDePause = momentoDePause;
    }

    public int getTempoDePause() {
        return tempoDePause;
    }

    public void setTempoDePause(int tempoDePause) {
        this.tempoDePause = tempoDePause;
    }

    @Override
    public synchronized void start() {
        super.start();
        this.setName("PLAYER DO FILME '" + getFilme().getNome() + "'");
    }

    @Override
    public synchronized void run() {
        super.run();
        System.out.println("INICIANDO THREAD: " + this.getName() + "\n");
        do {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.reproduzirFilme();
            if(getMomentoAtualDoFilme() == getMomentoDePause()){
                this.pausarFilme(getTempoDePause());
            }
        } while (getMomentoAtualDoFilme() < getFilme().getDuracaoDoFilme());
        System.out.println("FIM DO FILME!\n");
    }

    private synchronized void reproduzirFilme() {
        setMomentoAtualDoFilme(getMomentoAtualDoFilme() + 1);
        System.out.println(
                "REPRODUZINDO O FILME '" + getFilme().getNome() + "' NO MOMENTO " + getMomentoAtualDoFilme() + "s");
    }

    private synchronized void pausarFilme(int tempo) {
        for (int i = tempo; i > 0; i--) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    "FILME '" + getFilme().getNome() + "' PAUSADO, AGUARDANDO " + i + "s PARA CONTINUAR\n");
        }
    }
}