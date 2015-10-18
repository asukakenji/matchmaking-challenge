package org.devnull.matchmaking.player;

//import static org.devnull.matchmaking.CommonMacros.*;

import org.devnull.matchmaking.Player;

/**
 * <p>
 * Representation of a player with equipments.
 * </p>
 * <p>
 * This class demonstrates a situation that the {@link BasicPlayer} needs to be
 * extended for various reasons. Fields could have been added to the
 * {@code BasicPlayer} class directly, but this could have a great chain effect
 * when the project grows large.
 * </p>
 */
public class EquippedPlayer extends BasicPlayer implements java.io.Serializable {

    /** Generated by the serialver utility */
    //TODO: private static final long serialVersionUID = 9164335284358958805L;

    //public static final PlayerProperties<EquippedPlayer> PLAYER_PROPERTIES = pps(
    //    BasicPlayer.PLAYER_PROPERTIES,
    //    pp("equipmentLevel", EquippedPlayer::getEquipmentLevel)
    //);



    private final int equipmentLevel;

    public EquippedPlayer(final String name, final long wins, final long losses, final int equipmentLevel) {
        super(name, wins, losses);
        if (equipmentLevel < 0) throw new IllegalArgumentException(name + " (equipmentLevel: " + equipmentLevel + ")");
        this.equipmentLevel = equipmentLevel;
    }

    //@Override
    //public PlayerProperties<PlayerInterface> getPlayerProperty() {
    //    return null;
    //}

    public int getEquipmentLevel() {
        return this.equipmentLevel;
    }

    @Override
    public int hashCode() {
        // The same as java.util.Objects#hash(Object...)
        return super.hashCode() * 31 + this.equipmentLevel;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        // Note: Do NOT use "instanceof" here
        // Java equality sucks, let's use Scala!
        // See: http://stackoverflow.com/q/12239344/142239
        if (obj.getClass() != EquippedPlayer.class) return false;
        final EquippedPlayer p = (EquippedPlayer) obj;
        return this.getName().equals(p.getName())
            && this.getWins() == p.getWins()
            && this.getLosses() == p.getLosses()
            && this.equipmentLevel == p.equipmentLevel;
    }

    @Override
    public String toString() {
        // TODO: Should use Apache Commons StringEscapeUtils to escape this.name here,
        //       but let's assume there are no special characters for simplicity.
        return new StringBuilder("[EquippedPlayer: \"name\": \"")
            .append(this.getName())
            .append("\", \"wins\": ")
            .append(this.getWins())
            .append(", \"losses\": ")
            .append(this.getLosses())
            .append(", \"equipmentLevel\": ")
            .append(this.equipmentLevel)
            .append("]")
            .toString();
    }

}