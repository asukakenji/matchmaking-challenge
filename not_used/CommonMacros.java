package org.devnull.matchmaking;

import java.util.Arrays;
import java.util.List;

public class CommonMacros {

    @SafeVarargs
    public static <P extends PlayerInterface, T extends PlayerProperty<P>> PlayerProperties<P> pps(final PlayerProperties<? super P> parent, final T... t) {
        final List<PlayerProperty<P>> properties = Arrays.asList(t);
        return new PlayerProperties<P>(parent, properties);
    }

    public static <P extends PlayerInterface> PlayerProperty<P> pp(final String name, final java.util.function.Function<P, ?> getter) {
        return new PlayerProperty<P>(name, getter);
    }

}
