package don616.apitarot.entity;

public enum EnumEstiloTiragem {

    TIRAGEM_UMA_CARTA,
    TIRAGEM_PASSADO_PRESENTE_FUTURO,
    TIRAGEM_ARCANO_MAIOR_MENOR;

    public static EnumEstiloTiragem fromInteger(Integer num){
        switch (num){
            case 0:
                return TIRAGEM_UMA_CARTA;
            case 1:
                return TIRAGEM_PASSADO_PRESENTE_FUTURO;
            case 2:
                return TIRAGEM_ARCANO_MAIOR_MENOR;
        }
        return null;
    }
}
