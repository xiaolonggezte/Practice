import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<K,V> extends LinkedHashMap<K,V> {

    private static final int maxCapacity = 1024;
    private static final float DEFAULT_LOAD_FATOR = 0.75f;

    public LRU(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCapacity;
    }
}




