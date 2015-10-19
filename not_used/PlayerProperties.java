package org.devnull.matchmaking;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class PlayerProperties<P extends PlayerInterface> {
    private final PlayerProperties<? super P> parent;
    private final Map<String, PlayerProperty<P>> map;

    public PlayerProperties(final PlayerProperties<? super P> parent, final List<PlayerProperty<P>> properties) {
        this.parent = parent;
        final Map<String, PlayerProperty<P>> map = new LinkedHashMap<String, PlayerProperty<P>>();
        for (final PlayerProperty<P> property : properties) {
            map.put(property.name, property);
        }
        this.map = Collections.unmodifiableMap(map);
    }

    public PlayerProperties<? super P> getParent() {
       return this.parent;
    }

    public PlayerProperty<P> get(final String name) {
        return this.map.get(name);
    }

    public Function<P, ?> getGetter(final String name) {
        return this.map.get(name).getter;
    }

}
