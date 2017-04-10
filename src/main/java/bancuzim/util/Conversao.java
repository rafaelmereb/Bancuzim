package bancuzim.util;

import java.util.ArrayList;
import java.util.List;

public class Conversao {

    public static <T> List<T> toList(Iterable<T> iteravel) {
        if(iteravel instanceof List) {
            return (List<T>) iteravel;
        }
        ArrayList<T> lista = new ArrayList<T>();
        if(iteravel != null) {
            for(T item: iteravel) {
                lista.add(item);
            }
        }
        return lista;
    }

}
