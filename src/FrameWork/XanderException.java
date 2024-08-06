package FrameWork;

public class XanderException extends Exception {

    public XanderException(String e, String clase, String metodo) {
        System.out.println("[ERRO APP ---> LOG]" + clase + " , " + metodo + " , " + e);
    }

    @Override
    public String getMessage() {
        return "Thu no has visto nada";
    }

}
