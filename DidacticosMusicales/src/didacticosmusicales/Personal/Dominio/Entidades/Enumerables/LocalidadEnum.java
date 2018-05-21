/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Dominio.Entidades.Enumerables;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author XGAnalista2
 */
public enum LocalidadEnum {
    Rural(1), 
    Urbano(2);
    
    private static Map map = new HashMap<>();
    private final int value;
    
    private LocalidadEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
     static {
        for (LocalidadEnum t : LocalidadEnum.values()) {
            map.put(t.value, t);
        }
    }

    public static LocalidadEnum valueOf(int t) {
        return (LocalidadEnum) map.get(t);
    }
}
