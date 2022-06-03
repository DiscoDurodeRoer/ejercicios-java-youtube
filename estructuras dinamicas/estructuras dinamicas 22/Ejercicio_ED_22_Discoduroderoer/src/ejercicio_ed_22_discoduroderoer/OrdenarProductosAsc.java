package ejercicio_ed_22_discoduroderoer;

import java.util.Comparator;

public class OrdenarProductosAsc implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
    
}
