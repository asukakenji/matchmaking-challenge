package org.devnull.matchmaking;

import java.util.function.Function;

public class PlayerProperty<P> {
    public final String name;
    public final Function<P, ?> getter;

    public PlayerProperty(final String name, final Function<P, ?> getter) {
        this.name = name;
        this.getter = getter;
    }
}
